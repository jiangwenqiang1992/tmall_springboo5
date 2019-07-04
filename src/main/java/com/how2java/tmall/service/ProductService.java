package com.how2java.tmall.service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.dao.ProductDAO;
import com.how2java.tmall.dao.PropertyDAO;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    @Autowired
    CategoryDAO categoryDAO;

    public List<Product> list(int cid){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Category category = categoryDAO.findOne(cid);
        return  productDAO.findByCategory(category,sort);
    }

    public Product findOne(int id){
        return productDAO.findOne(id);
    }

    public void add(Product product){
        productDAO.save(product);
    }

    public void update(Product product){
        productDAO.save(product);
    }

    public void delete(int id){
        productDAO.delete(id);
    }
}
