package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<Product> list(int cid){
        return productService.list(cid);
    }

    @PostMapping("/product")
    public Product add(Product product,Category category, HttpServletRequest httpServletRequest){
        category.setId(Integer.valueOf(httpServletRequest.getParameter("cid")));
        product.setCategory(category);
        productService.update(product);
        return product;
    }

    @PutMapping("/product/{id}")
    public Product update(Product product,Category category, HttpServletRequest httpServletRequest){
        category.setId(Integer.valueOf(httpServletRequest.getParameter("cid")));
        product.setCategory(category);
        productService.update(product);
        return product;
    }

    @DeleteMapping("/product/{id}")
    public int delete(@PathVariable(name = "id") int id){
        productService.delete(id);
        return 1;
    }

}
