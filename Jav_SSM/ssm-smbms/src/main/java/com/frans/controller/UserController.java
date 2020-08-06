package com.frans.controller;

import com.frans.pojo.User;
import com.frans.service.user.UserService;
import com.frans.tools.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {

    /*
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserService userService = (UserService) context.getBean("userService");
    */

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/login.do")
    public String login(HttpSession session, User user){
        User login = userService.login(user.getUserCode(), user.getUserPassword());
        if(login == null){
            //此账号不存在
            session.setAttribute("error","用户或密码不正确！");
            return "redirect:../login.jsp";
        }else{
            //登陆成功
            session.setAttribute(Constants.USER_SESSION, login);
            //System.out.println( ((User)session.getAttribute(Constants.USER_SESSION)).getId() + "==============");
            return "frame";
        }
    }

    //验证旧密码
    @ResponseBody
    @RequestMapping("/checkPwd.do")
    public String checkPwd(HttpSession session, @RequestParam(value = "oldpassword",required = false) String oldpassword) {
        String result;
        if (oldpassword.equals(null) || oldpassword.equals("")){
            result = "error";
        }else if(session.getAttribute(Constants.USER_SESSION) == null){
            result = "sessionerror";
        }else{
            result = userService.checkPwd(((User) session.getAttribute(Constants.USER_SESSION)).getId(), oldpassword);
        }
        //System.out.println( ((User)session.getAttribute(Constants.USER_SESSION)).getId() + "==========>>>>>>>>>>>"  + result);
        return "{\"result\": \""+result+"\"}"; //json
    }

    @RequestMapping(value = "/pwdmodify.do",method = RequestMethod.GET)
    public String pwdModity(){
        return "pwdmodify";
    }

    @RequestMapping(value = "/pwdmodify.do", method = RequestMethod.POST)
    public String pwdmodify(HttpSession session, String newpassword){
        /*交给前端做
        if(!reNewPassword.equals(newpassword)){
            session.setAttribute("message", "两次密码输入不一致");
            return "pwdmodify";
        }
        */
        User user = (User) session.getAttribute(Constants.USER_SESSION);

        /*同样密码判断交给前端做
        if(!oldpassword.equals(user.getUserPassword())){
            session.setAttribute("message", "密码输入有误");
            return "pwdmodify";
        }
        */
        boolean flag = userService.updatePwd(user.getId(), newpassword);
        if(flag){
            session.setAttribute("message","密码修改成功！");
            return "redirect:../login.jsp";
        }
        else{
            session.setAttribute("message", "密码修改失败");
            return "pwdmodify";
        }
    }

    @RequestMapping("/exit.do")
    public String exit(HttpServletRequest request){
        request.removeAttribute(Constants.USER_SESSION);
        return "redirect:../login.jsp";
    }

}
