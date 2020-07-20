package com.frans.controller;


import com.frans.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1.接受前端参数
        System.out.println("接受到前端的参数为：" + name);
        //2. 将返回的结果传递给前端
        model.addAttribute("msg", name);

        //3. 视图跳转
        return "test";
    }

    //前端接受的是对象

    /**
     *
     * @param user
     *   1. 接受前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接受用
     *   2. 假设传递的是一个User对象，匹配User对象中的字段名，如果名字一致则ok，否则匹配不到
     * @return
     */
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

}
