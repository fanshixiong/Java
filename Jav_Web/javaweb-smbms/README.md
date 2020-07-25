## SMBMS(超市管理项目)

### 搭建项目准备工作

1. 搭建一个maven web 项目

2. 配置Tomcat

3. 测试项目是否能够跑起来

4. 导入项目中需要的jar包;
	jsp，Servlet，mysql驱动jstl，stand......
	
5. 构建项目包结构
	
	![image-20200725193654292](F:\Java\Java_Study\Jav_Web\javaweb-smbms\README.assets\image-20200725193654292.png)
	
6. 编写实体类
  ROM映射:表-类映射

7. 编写基础公共类
   1、数据库配置文件（mysql5.xx和8.xx的编写有差异）

   ```xml
   driver=com.mysql.jdbc.Driver
   #在和mysql传递数据的过程中，使用unicode编码格式，并且字符集设置为utf-8
   url=jdbc:mysql://127.0.0.1:3306/smbms?useSSL=false&useUnicode=true&characterEncoding=utf-8
   user=root
   password=root
   ```
     2、编写数据库的公共类

```java
package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 操作数据库的基类--静态类
 * @author Administrator
 *
 */
public class BaseDao {
	
	static{//静态代码块,在类加载的时候执行
		init();
	}
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	//初始化连接参数,从配置文件里获得
	public static void init(){
		Properties params=new Properties();
		String configFile = "database.properties";
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream(configFile);
		try {
			params.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver=params.getProperty("driver");
		url=params.getProperty("url");
		user=params.getProperty("user");
		password=params.getProperty("password");

	}   
	
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	/**
	 * 查询操作
	 * @param connection
	 * @param pstm
	 * @param rs
	 * @param sql
	 * @param params
	 * @return
	 */
	public static ResultSet execute(Connection connection,PreparedStatement pstm,ResultSet rs,
			String sql,Object[] params) throws Exception{
		pstm = connection.prepareStatement(sql);
		for(int i = 0; i < params.length; i++){
			pstm.setObject(i+1, params[i]);
		}
		rs = pstm.executeQuery();
		return rs;
	}
	/**
	 * 更新操作
	 * @param connection
	 * @param pstm
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static int execute(Connection connection,PreparedStatement pstm,
			String sql,Object[] params) throws Exception{
		int updateRows = 0;
		pstm = connection.prepareStatement(sql);
		for(int i = 0; i < params.length; i++){
			pstm.setObject(i+1, params[i]);
		}
		updateRows = pstm.executeUpdate();
		return updateRows;
	}
	
	/**
	 * 释放资源
	 * @param connection
	 * @param pstm
	 * @param rs
	 * @return
	 */
	public static boolean closeResource(Connection connection,PreparedStatement pstm,ResultSet rs){
		boolean flag = true;
		if(rs != null){
			try {
				rs.close();
				rs = null;//GC回收
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		if(pstm != null){
			try {
				pstm.close();
				pstm = null;//GC回收
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		if(connection != null){
			try {
				connection.close();
				connection = null;//GC回收
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		
		return flag;
	}

}
```

. 3、编写字符编码过滤器

8. 导入静态资源

9. 数据库：

    ![image-20200725213959723](F:\Java\Java_Study\Jav_Web\javaweb-smbms\README.assets\image-20200725213959723.png)
### 登录功能实现
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200516125301633.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2JlbGxfbG92ZQ==,size_16,color_FFFFFF,t_70)
1. 编写前端页面
2. 设置首页
	1.设置欢迎首页
```xml
  <welcome-file-list>
    <welcome-file>login.jsp</welcome-file>
  </welcome-file-list>
```
3. 编写dao层登录用户登录的接口
	

```java
public User getLoginUser(Connection connection, String userCode) throws Exception;
```

4.  编写dao层接口的实现类
	

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.BaseDao;
import pojo.User;

public class UserDaoImpl implements UserDao{
	//持久层只做查询数据库的内容
	public User getLoginUser(Connection connection, String userCode) throws Exception{
		//准备三个对象
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		//判断是否连接成功
		if(null != connection){
			String sql = "select * from smbms_user where userCode=?";
			Object[] params = {userCode};
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setGender(rs.getInt("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setUserRole(rs.getInt("userRole"));
				user.setCreatedBy(rs.getInt("createdBy"));
				user.setCreationDate(rs.getTimestamp("creationDate"));
				user.setModifyBy(rs.getInt("modifyBy"));
				user.setModifyDate(rs.getTimestamp("modifyDate"));
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return user;
	}	
}
```

5. 业务层接口
	

```java
//用户登录
public User login(String userCode, String userPassword);
```

6. 业务层实现类
	

```java
import java.sql.Connection;

//import org.junit.Test;

import dao.BaseDao;
import dao.user.UserDao;
import dao.user.UserDaoImpl;
import pojo.User;

public class UserServiceImpl implements UserService{
	//业务层都会调用dao层.所以我们要引入Dao层（重点）
	//只处理对应业务
	
	private UserDao userDao;
	public UserServiceImpl(){
		userDao = new UserDaoImpl();
	}
	
	public User login(String userCode,String userPassword) {
		// TODO Auto-generated method stub
		Connection connection = null;
		//通过业务层调用对应的具体数据库操作
		User user = null;
		try {
			connection = BaseDao.getConnection();
			user = userDao.getLoginUser(connection, userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return user;
	}
	
	/*@Test
	public void test() {
		UserServiceImpl userService = new UserServiceImpl();
		String userCode = "admin";
		String userPassword = "12345678";
		User admin = userService.login(userCode, userPassword);
		System.out.println(admin.getUserPassword());

	}
	*/
}
```
7. 编写Servlet
	

```java
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import util.Constants;
import service.user.UserService;
import service.user.UserServiceImpl;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet{
	//接受用户参数、调用业务层、转发视图
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		
		System.out.println("login ============ " );
		//获取用户名和密码
		String userCode = req.getParameter("userCode");
		String userPassword = req.getParameter("userPassword");
		//调用service方法，进行用户匹配
		UserService userService = new UserServiceImpl();
		User user = userService.login(userCode,userPassword);
		if(null != user){//登录成功
			//放入session
			req.getSession().setAttribute(Constants.USER_SESSION,user);
			//页面跳转（frame.jsp）
			resp.sendRedirect("jsp/frame.jsp");
		}else{
			//页面跳转（login.jsp）带出提示信息--转发
			req.setAttribute("error", "用户名或密码不正确");
			req.getRequestDispatcher("login.jsp").forward(req,resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}
}
```
8. 注册Servlet
	

```xml
<servlet>
	<servlet-name>LoginServlet</servlet-name>
	<servlet-class>com.frans.servlet.user.LoginServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>LoginServlet</servlet-name>
	<url-pattern>/login.do</url-pattern>
</servlet-mapping>
```
9. 测试访问,保证以上功能可以成功
### 登录功能优化
注销功能
思路：移除session，返回登录页面

```java
public class LogoutServlet extends HttpServlet {

	public void doPOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//清除session
		request.getSession().removeAttribute(Constants.USER_SESSION);
		response.sendRedirect(request.getContextPath()+"/login.jsp");//返回登录页面
	}

}
```
注册xml
```xml
<servlet>
	<servlet-name>LogoutServlet</servlet-name>
	<servlet-class>servlet.user.LogoutServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>LogoutServlet</servlet-name>
	<url-pattern>/jsp/logout.do</url-pattern>
</servlet-mapping>
```
### 登录拦截优化
编写一个过滤器，并注册

```java
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import util.Constants;

public class SysFilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException{
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO 自动生成的方法存根
		HttpServletRequest request =  (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		//过滤器，从session中获取用户
		User user = (User)request.getSession().getAttribute(Constants.USER_SESSION);
		if(user == null){//已经被移除或者注销了，或者未登录
			response.sendRedirect("/smbms/error.jsp");
		}else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		
	}
}
```
注册xml
```xml
<!-- 用户登录过滤器 -->
<filter>
	<filter-name>SysFilter</filter-name>
	<filter-class>filter.SysFilter</filter-class>
</filter> 
<filter-mapping>
	<filter-name>SysFilter</filter-name>
	<url-pattern>/jsp/*</url-pattern>
</filter-mapping>
```
测试，登录，注销，权限，都要保证OK
### 密码修改
1. 导入前端素材

```html
<li><a href="${pageContext.request.contextPath }/jsp/pwdmodify.jsp">密码修改</a></li>

```
2. 写项目，建议从底层向上写
						![image-20200725193547041](F:\Java\Java_Study\Jav_Web\javaweb-smbms\README.assets\image-20200725193547041.png)
3. UserDao接口

```java
//修改当前用户密码
	public int updatePwd(Connection connection,int id,int password)throws SQLException, Exception;
```

4. UserDao接口实现类

```java
@Override//修改当前密码
	public int updatePwd(Connection connection, int id, int password) throws Exception {
		// TODO 自动生成的方法存根
		PreparedStatement pstm = null;
		int execute =0;
		if(connection!=null) {
			String sql = "update smbms_user set = userPassword = ? where id = ?";
			Object[] params = {password,id};
			execute = BaseDao.execute(connection, pstm, sql, params);
			BaseDao.closeResource(null, pstm, null);
		}
		return execute;			
	}
```
5. UserService层

```java
public boolean updatePwd(int id,int password)throws SQLException, Exception;
```
6. UserService实现类
```java
public boolean updatePwd(int id, int password) throws SQLException, Exception {
		// TODO 自动生成的方法存根
		Connection connection = null;
		boolean flag = false;
		//修改密码
		try {
			connection = BaseDao.getConnection();
			if(userDao.updatePwd(connection, id, password)>0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			BaseDao.closeResource(connection, null, null);
			
		}
		return flag;
	}
```
7. servlet记得实现复用，要提取出方法！
在 **dao层** 和 **service层** 自己写映射类和实现类
下面是 **servlet层** 的主体
```java
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String method = req.getParameter("method");
		if (method != "savepwd" && method != null) {
			this.updatePwd(req, resp);
		}
		//实现复用~~~~~~
		// 想添加新的增删改查，直接用if(method != "savepwd" && method != null);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}

	public void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
		// 通过session获得用户id
		Object o = req.getSession().getAttribute(Constants.USER_SESSION);
		String newpassword = req.getParameter("newpassword");
		boolean flag = false;
		if (o != null && newpassword != null) {
			UserService userService = new UserServiceImpl();

			try {
				flag = userService.updatePwd(((User) o).getId(), newpassword);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (flag) {
				req.setAttribute("message", "密码修改成功，请退出，使用新密码登录");
				// 密码修改成功,移除session(移除后不能再次修改密码,建议不移除)
				req.getSession().removeAttribute(Constants.USER_SESSION);
			} else {
				// 密码修改失败
				req.setAttribute("message", "密码修改失败");
			}

		} else {
			// 密码修改有问题
			req.setAttribute("message", "新密码有问题");
		}
		try {
			req.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
```
注册xml
```xml
<servlet>
		<servlet-name>UserServlet</servlet-name>
		<servlet-class>servlet.user.UserServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>UserServlet</servlet-name>
		<url-pattern>/jsp/user.do</url-pattern>
	</servlet-mapping>
```
8. 测试
### 优化密码修改使用Ajax
1. 阿里巴巴的fastjson
```xml
<!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.68</version>
</dependency>
```
2. 后台代码修改

导入阿里的包

```xml
<!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.68</version>
</dependency>
```

```java
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.StringUtils;
import com.mysql.cj.xdevapi.JsonArray;

//import com.mysql.cj.util.StringUtils;

import pojo.User;
import service.user.UserService;
import service.user.UserServiceImpl;
import util.Constants;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		String method = req.getParameter("method");
		if (method.equals( "savepwd") && method != null) {
			this.updatePwd(req, resp);
		}else if (method.equals( "pwdmodify") && method != null) {
			
		}
		// 想添加新的增删改查，直接用if(method != "savepwd" && method != null);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		doGet(req, resp);
	}

	public void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
		// 通过session获得用户id
		Object o = req.getSession().getAttribute(Constants.USER_SESSION);
		String newpassword = req.getParameter("newpassword");
		boolean flag = false;
		if (o != null && newpassword != null) {
			UserService userService = new UserServiceImpl();

			try {
				flag = userService.updatePwd(((User) o).getId(), newpassword);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (flag) {
				req.setAttribute("message", "密码修改成功，请退出，使用新密码登录");
				// 密码修改成功,移除session(移除后不能再次修改密码,建议不移除)
				req.getSession().removeAttribute(Constants.USER_SESSION);
			} else {
				// 密码修改失败
				req.setAttribute("message", "密码修改失败");
			}

		} else {
			// 密码修改有问题
			req.setAttribute("message", "新密码有问题");
		}
		try {
			req.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void pqdmodify(HttpServletRequest req, HttpServletResponse resp) {
		// 通过session获得用户id
		Object o = req.getSession().getAttribute(Constants.USER_SESSION);
		String oldpassword = req.getParameter("oldpassword");
		
		Map<String, String> resultMap = new HashMap<String, String>();
		if(o==null) {//session失效，session过期了
			resultMap.put("result","seesionerror");
		}else if(StringUtils.isNullOrEmpty(oldpassword)){//输入密码为空
			resultMap.put("result","error");
		}else {//
			String userPassword = ((User)o).getUserPassword();//seesion中的用户密码
			if(oldpassword.equals(userPassword)) {
				resultMap.put("result","true");
			}else {
				resultMap.put("result","false");
			}
		}
		
		
		try {
			resp.setContentType("application/josn");
			PrintWriter writer = resp.getWriter();
			/*
			 * resultMap = ["result","sessionerror","result",error]
			 * josn格式={key,value
			 */
			//writer.write(JSONArray.toJSONString(resultMap));
			writer.write(JsonArray.class.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
```

3. 测试
### 用户管理实现
![image-20200725193529807](F:\Java\Java_Study\Jav_Web\javaweb-smbms\README.assets\image-20200725193529807.png)

1. 导入分页的工具类-PageSupport
2. 用户列表页面导入-userlist.jsp
#### 1、获取用户数量
1. UserDao

```java
//根据用户名或者角色查询用户总数
public int getUserCount(Connection connection,String username ,int userRole)throws SQLException, Exception;
```
2. UserDaoImpl

```java
@Override
	public int getUserCount(Connection connection, String userName, int userRole)
			throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		if(connection != null){
			StringBuffer sql = new StringBuffer();
			sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
			List<Object> list = new ArrayList<Object>();
			if(!StringUtils.isNullOrEmpty(userName)){
				sql.append(" and u.userName like ?");
				list.add("%"+userName+"%");
			}
			if(userRole > 0){
				sql.append(" and u.userRole = ?");
				list.add(userRole);
			}
			Object[] params = list.toArray();
			System.out.println("sql ----> " + sql.toString());
			rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
			if(rs.next()){
				count = rs.getInt("count");
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return count;
	}
```
3. UserService

```java
//查询记录数
	public int getUserCount(String username, int userRole);
```
4. UserServiceImpl

```java
//查询记录数
	@Override
	public int getUserCount(String queryUserName, int queryUserRole) {
		// TODO Auto-generated method stub
		Connection connection = null;
		int count = 0;
		System.out.println("queryUserName ---- > " + queryUserName);
		System.out.println("queryUserRole ---- > " + queryUserRole);
		try {
			connection = BaseDao.getConnection();
			count = userDao.getUserCount(connection, queryUserName,queryUserRole);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		//System.out.println("count"+count);
		return count;
	}
```
#### 2、获取用户列表
1.UserDao 
	
```java
//通过条件查询-userList
	public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)throws Exception;
```
2. UserDaoImpl
	
```java
@Override
	public List<User> getUserList(Connection connection, String userName,int userRole,int currentPageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		if(connection != null){
			StringBuffer sql = new StringBuffer();
			sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
			List<Object> list = new ArrayList<Object>();
			if(!StringUtils.isNullOrEmpty(userName)){
				sql.append(" and u.userName like ?");
				list.add("%"+userName+"%");
			}
			if(userRole > 0){
				sql.append(" and u.userRole = ?");
				list.add(userRole);
			}
			//在数据库中，分页显示 limit startIndex，pageSize；总数
			//当前页  (当前页-1)*页面大小
			//0,5	1,0	 01234
			//5,5	5,0	 56789
			//10,5	10,0 10~
			sql.append(" order by creationDate DESC limit ?,?");
			currentPageNo = (currentPageNo-1)*pageSize;
			list.add(currentPageNo);
			list.add(pageSize);
			
			Object[] params = list.toArray();
			System.out.println("sql ----> " + sql.toString());
			
			rs = BaseDao.execute(connection, pstm, rs, sql.toString(), params);
			while(rs.next()){
				User _user = new User();
				_user.setId(rs.getInt("id"));
				_user.setUserCode(rs.getString("userCode"));
				_user.setUserName(rs.getString("userName"));
				_user.setGender(rs.getInt("gender"));
				_user.setBirthday(rs.getDate("birthday"));
				_user.setPhone(rs.getString("phone"));
				_user.setUserRole(rs.getInt("userRole"));
				_user.setUserRoleName(rs.getString("userRoleName"));
				userList.add(_user);
			}
			BaseDao.closeResource(null, pstm, rs);
		}
		return userList;
	}
```
3. UserService
	
```java
//根据条件查询用户列表
	public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
```
4. UserServiceImpl
	
```java
@Override
	public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo, int pageSize) {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<User> userList = null;
		System.out.println("queryUserName ---- > " + queryUserName);
		System.out.println("queryUserRole ---- > " + queryUserRole);
		System.out.println("currentPageNo ---- > " + currentPageNo);
		System.out.println("pageSize ---- > " + pageSize);
		try {
			connection = BaseDao.getConnection();
			userList = userDao.getUserList(connection, queryUserName,queryUserRole,currentPageNo,pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return userList;
	}
```
#### 3、获取角色操作
为了我们的职责统一，我们可以把**角色的操作**单独放在一个包中，和pojo类对应。。。

1. RoleDao 
	
```java
//获取角色列表
		public List<Role> getRoleList(Connection connection)throws Exception;
```

2. RoleDaoIpml

```java
public class RoleDaoImpl implements RoleDao {

	@Override
	public List<Role> getRoleList(Connection connection) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Role> roleList = new ArrayList<Role>();
		if (connection != null) {
			String sql = "select * from smbms_role";
			Object[] params = {};
			rs = BaseDao.execute(connection, pstm, rs, sql, params);
			while (rs.next()) {
				Role _role = new Role();
				_role.setId(rs.getInt("id"));
				_role.setRoleCode(rs.getString("roleCode"));
				_role.setRoleName(rs.getString("roleName"));
				roleList.add(_role);
			}
			BaseDao.closeResource(null, pstm, rs);
		}

		return roleList;
	}
}
```
3. RoleService

```java
public interface RoleService {
	//角色列表查询
	public List<Role> getRoleList();  
	
}
```

4. RoleServiceIpml

```java
public class RoleServiceImpl implements RoleService{
	
	private RoleDao roleDao;
	
	public RoleServiceImpl(){
		roleDao = new RoleDaoImpl();
	}
	
	@Override
	public List<Role> getRoleList() {
		Connection connection = null;
		List<Role> roleList = null;
		try {
			connection = BaseDao.getConnection();
			roleList = roleDao.getRoleList(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeResource(connection, null, null);
		}
		return roleList;
	}
	
}
```
#### 4、用户显示的Servlet
1. 获取用户前端的数据（查询）
2. 判断请求是否需要执行，看参数的值判断
3. 为了实现分页，需要计算出当前页面和总页面，页面大小...
4. 用户列表展示
5. 返回前端

```java
//重点、难点
	private void query(HttpServletRequest req, HttpServletResponse resp) {
		// TODO 自动生成的方法存根
		//查询用户列表
		//从前端获取数据
		//查询用户列表
		String queryUserName = req.getParameter("queryname");
		String temp = req.getParameter("queryUserRole");
		String pageIndex = req.getParameter("pageIndex");
		int queryUserRole = 0;
		
		//获取用户列表
		UserServiceImpl userService = new UserServiceImpl();
		List<User> userList = null;
		
		//第一此请求肯定是走第一页，页面大小固定的
		//设置页面容量
    	int pageSize = 5;//把它设置在配置文件里,后面方便修改
    	//当前页码
    	int currentPageNo = 1;
		
		if(queryUserName == null){
			queryUserName = "";
		}
		if(temp != null && !temp.equals("")){
			queryUserRole = Integer.parseInt(temp);
		}
		if(pageIndex != null) {
			currentPageNo = Integer.parseInt(pageIndex);
		}
		//获取用户总数（分页	上一页：下一页的情况）
		//总数量（表）	
    	int totalCount	= userService.getUserCount(queryUserName,queryUserRole);
			
		//总页数支持
		PageSupport pageSupport = new PageSupport();
		pageSupport.setCurrentPageNo(currentPageNo);
		pageSupport.setPageSize(pageSize);
		pageSupport.setTotalCount(totalCount);
		
		int totalPageCount =pageSupport.getTotalPageCount();//总共有几页
		//(totalCount+pageSize-1/pageSize)取整
		// pageSupport.getTotalCount()
		
		//System.out.println("totalCount ="+totalCount);
		//System.out.println("pageSize ="+pageSize);
		//System.out.println("totalPageCount ="+totalPageCount);
		//控制首页和尾页
		//如果页面小于 1 就显示第一页的东西
		if(currentPageNo < 1) {
			currentPageNo = 1;
		}else if(currentPageNo > totalPageCount) {//如果页面大于了最后一页就显示最后一页
			currentPageNo =totalPageCount;
		}
		
		userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
		req.setAttribute("userList", userList);
		
		RoleServiceImpl roleService = new RoleServiceImpl();
		List<Role> roleList = roleService.getRoleList();
		req.setAttribute("roleList", roleList);
		req.setAttribute("totalCount", totalCount); 
		req.setAttribute("currentPageNo", currentPageNo);
		req.setAttribute("totalPageCount", totalPageCount);
		req.setAttribute("queryUserName", queryUserName);
		req.setAttribute("queryUserRole", queryUserRole);
		
		//返回前端
		try {
			req.getRequestDispatcher("userlist.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
```
小黄鸭调试法：自言自语

**项目原理流程图：**
                              ![image-20200725193454070](F:\Java\Java_Study\Jav_Web\javaweb-smbms\README.assets\image-20200725193454070.png)

