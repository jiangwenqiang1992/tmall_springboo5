package com.how2java.tmall.service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.dao.PropertyDAO;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    PropertyDAO propertyDAO;

    @Autowired
    CategoryDAO categoryDAO;

    public List<Property> list(int cid){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Category category = categoryDAO.findOne(cid);
        return  propertyDAO.findByCategory(category,sort);
    }

    public void add(Property property){
        propertyDAO.save(property);
    }

    public void update(Property property){
        propertyDAO.save(property);
    }

    public void delete(int id){
        propertyDAO.delete(id);
    }
}
