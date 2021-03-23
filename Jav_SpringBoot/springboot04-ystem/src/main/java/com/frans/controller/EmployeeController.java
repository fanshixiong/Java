package com.frans.controller;

import com.frans.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {


    @RequestMapping("/emps")
    public String list(Model model){
        model.addAttribute("emps",  new Employee());
        return "emp/list.html";
    }

    @GetMapping("/emp")
    public String toAddPage(){
        return "emp/add.html";
    }
}
