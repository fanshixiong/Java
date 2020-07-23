package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.staff;
import model.InsertStaff;
@SuppressWarnings("serial")
public class InsertStaffServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertStaffServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt( request.getParameter("id"));
		String name=request.getParameter("name");
		if(name==null || name.equals("")){
			request.setAttribute("error", "姓名不能为空");
			request.getRequestDispatcher("/jsp/staffInsert.jsp").forward(request, response);
			return;
		}
		String sex=request.getParameter("sex");
		String nation=request.getParameter("nation");
		String birth=request.getParameter("birth");
		String phone=request.getParameter("phone");
		String idcard=request.getParameter("idcard");
		String depart=request.getParameter("depart");
		String profe=request.getParameter("profe");
		String email=request.getParameter("email");
		String school=request.getParameter("school");
		String educat=request.getParameter("educat");
		String entry=request.getParameter("entry");
		staff s=new staff();
		s.setId(id);
		s.setName(name);
		s.setSex(sex);
		s.setNation(nation);
		s.setBirth(birth);
		s.setPhone(phone);
		s.setIdcard(idcard);
		s.setDepart(depart);
		s.setProfe(profe);
		s.setEmail(email);
		s.setSchool(school);
		s.setEducat(educat);
		s.setEntry(entry);
		InsertStaff model=new InsertStaff();
		boolean result=model.Insert(s);
		if(result==true){
			response.sendRedirect(request.getContextPath()+"/servlet/ListStaff");
		}else{
			response.sendRedirect(request.getContextPath()+"/jsp/satffInsert.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
