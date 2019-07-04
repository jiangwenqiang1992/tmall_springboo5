package com.how2java.tmall.service;

import com.how2java.tmall.dao.TaskDAO;
import com.how2java.tmall.pojo.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskDAO taskDAO;

    public List<Task> list(){
        Sort sort = new Sort(Sort.Direction.ASC,"lastTime");
        return taskDAO.findAll(sort);
    }

    public void add(Task task){
        taskDAO.save(task);
    }

}
