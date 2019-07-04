package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> list(){
        return categoryService.list();
    }

    @PostMapping("/categories")
    public Category add(Category category){
        categoryService.add(category);
        return category;
    }

    @PutMapping("/categories/{id}")
    public Category update(Category category, HttpServletRequest httpServletRequest){
        category.setName(httpServletRequest.getParameter("name"));
        categoryService.update(category);
        return category;
    }

    @DeleteMapping("/categories/{id}")
    public int delete(@PathVariable(name = "id") int id){
        categoryService.delete(id);
        return 1;
    }

}
