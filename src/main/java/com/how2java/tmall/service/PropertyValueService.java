package com.how2java.tmall.service;

import com.how2java.tmall.dao.PropertyValueDAO;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyValueService {
    @Autowired
    PropertyValueDAO propertyValueDAO;

    @Autowired ProductService productService;

    public List<PropertyValue> list(int pid){
        Product product = productService.findOne(pid);
        return  propertyValueDAO.findByProduct(product);
    }

    public void add(PropertyValue propertyValue){
        propertyValueDAO.save(propertyValue);
    }

    public void update(PropertyValue propertyValue){
        propertyValueDAO.save(propertyValue);
    }

    public void delete(int id){
        propertyValueDAO.delete(id);
    }
}
