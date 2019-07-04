package com.how2java.tmall.dao;


import com.how2java.tmall.pojo.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskDAO extends JpaRepository<Task,Integer> {

}
