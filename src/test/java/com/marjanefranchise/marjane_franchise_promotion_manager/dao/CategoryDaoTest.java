package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDaoTest {

    @Test
    public void testInsertCategory(){
        CategoryDao categoryDao = new CategoryDao();
        System.out.println(" adding electronics ");
        categoryDao.addCategory();
    }
    @Test
    public void testInsertSubCategory(){
        CategoryDao categoryDao = new CategoryDao();
        System.out.println(" adding laptops ");
        categoryDao.addSubCategory(16);
    }

}