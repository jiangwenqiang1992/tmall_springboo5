package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskView {

    @RequestMapping("/taskManager")
    public String get(){
        return "admin/listTask";
    }

    @RequestMapping("/category")
    public String getCategory(){
        return "admin/listCategory";
    }

}
