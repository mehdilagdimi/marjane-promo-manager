package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.HibernateUtil;
import jakarta.persistence.Table;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDaoTest {

    @Test
    public void testInsertCategory(){
        DaoExecuter<Category> categoryDao = new DaoExecuter<>(Category.class);
//        System.out.println(" adding electronics ");
        Category category = new Category();
        category.setName("Nutrition");
        category.setParent(null);
        categoryDao.save(category);
    }

    @Test
    Category testFindCategory(int id) {
        if(id == 0) id = 1;
        DaoExecuter<Category> daoExecuter = new DaoExecuter<>(Category.class);
        Category category = daoExecuter.find(id);;
        System.out.println(" category name " + category.getName());
        assertEquals("Nutrition", category.getName());
        return category;
    }

    @Test
    public void testInsertSubCategory(){
        DaoExecuter<Category> daoExecuter = new DaoExecuter<>(Category.class);
        Category category = testFindCategory(1);
        Category subCategory = new Category();
        subCategory.setName("Fruits");
        subCategory.setParent(category);
        category.addSubCategory(subCategory);
        daoExecuter.save(category);
//        categoryDao.addSubCategory(16);
    }
    @Test
    public void testGetAllCategory(){
        DaoExecuter<Category> daoExecuter = new DaoExecuter<>(Category.class);
        List<Category> listCategories = daoExecuter.getAll();
        listCategories.forEach(System.out::print);
    //        categoryDao.addSubCategory(16);
    }

}