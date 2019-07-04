package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Task;
import com.how2java.tmall.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping(value = "/task")
    public List<Task> list(){
        return  taskService.list();
    }

    @PostMapping(value = "/task")
    public Task add(Task task){
        taskService.add(task);
        return task;
    }


}
