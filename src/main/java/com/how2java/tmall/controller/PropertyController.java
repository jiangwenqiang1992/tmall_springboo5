package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping("/property")
    public List<Property> list(int cid){
        return propertyService.list(cid);
    }

    @PostMapping("/property")
    public Property add(Property property,Category category, HttpServletRequest httpServletRequest){
        category.setId(Integer.valueOf(httpServletRequest.getParameter("cid")));
        property.setCategory(category);
        propertyService.update(property);
        return property;
    }

    @PutMapping("/property/{id}")
    public Property update(Property property,Category category, HttpServletRequest httpServletRequest){
        category.setId(Integer.valueOf(httpServletRequest.getParameter("cid")));
        property.setCategory(category);
        propertyService.update(property);
        return property;
    }

    @DeleteMapping("/property/{id}")
    public int delete(@PathVariable(name = "id") int id){
        propertyService.delete(id);
        return 1;
    }

}
