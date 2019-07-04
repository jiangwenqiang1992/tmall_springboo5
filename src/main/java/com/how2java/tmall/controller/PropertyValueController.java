package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;

    @GetMapping("/propertyValue")
    public List<PropertyValue> list(int pid){
        return  propertyValueService.list(pid);
    }

    @PostMapping("/propertyValue")
    public PropertyValue add(PropertyValue propertyValue , Product product,Property property,int pid, int ptid){
        product.setId(pid);
        property.setId(ptid);
        propertyValue.setProduct(product);
        propertyValue.setProperty(property);
        propertyValueService.add(propertyValue);
        return propertyValue;
    }

    @PutMapping("/propertyValue/{id}")
    public PropertyValue update(PropertyValue propertyValue, Product product,Property property, HttpServletRequest request){
        product.setId(Integer.valueOf(request.getParameter("pid")));
        property.setId(Integer.valueOf(request.getParameter("ptid")));
        propertyValue.setProduct(product);
        propertyValue.setProperty(property);
        propertyValueService.update(propertyValue);
        return propertyValue;
    }

    @DeleteMapping("/propertyValue/{id}")
    public int delete(@PathVariable(name = "id") int id){
        propertyValueService.delete(id);
        return 1;
    }



}
