package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.stream.Collectors;


public class CategoryController {

    public List<Category> getAll(){
        return BeanController.getAll(Category.class);
    }

    public List<Category> getAllSubCategory(){
        return getAll().stream().filter(category -> category.getParent() != null).collect(Collectors.toList());
    }

}
