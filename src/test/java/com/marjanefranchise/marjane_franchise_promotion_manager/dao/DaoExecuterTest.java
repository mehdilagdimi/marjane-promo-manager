package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DaoExecuterTest {

    @Test
    public void testInsertCategory(){
        DaoExecuter<Category> daoExecuter = new DaoExecuter<>(Category.class);
//        System.out.println(" adding electronics ");
        Category category = new Category();
        System.out.println(" id " + category.getId());
        category.setName("Test Category");
        category.setParent(null);
        daoExecuter.save(category);
        assertNotEquals(0, category.getId());
    }

    @Test
    public void testInsertCenter(){
        DaoExecuter<Center> daoExecuter = new DaoExecuter<>(Center.class);
        Center center = new Center();
        center.setCity("Test City");
        daoExecuter.save(center);
        assertNotEquals(0, center.getId());
    }

    @Test
    void testFindCategory() {
        int id = 1;
        DaoExecuter<Category> daoExecuter = new DaoExecuter<>(Category.class);
        Category category = daoExecuter.find(id);;
        System.out.println(" category name " + category.getName());
        assertEquals("Nutrition", category.getName());
    }



    @Test
    void testFindCenter() {
        int id = 1;
        DaoExecuter<Center> daoExecuter = new DaoExecuter<>(Center.class);
        Center center = daoExecuter.find(id);;
        System.out.println(" center city " + center.getCity());
        assertEquals("Safi", center.getCity());
    }

    @Test
    public void testInsertSubCategory(){
        DaoExecuter<Category> daoExecuter = new DaoExecuter<>(Category.class);
        Category category =  daoExecuter.find(1);
        Category subCategory = new Category();
        subCategory.setName("Fruits");
        subCategory.setParent(category);
        category.addSubCategory(subCategory);
        daoExecuter.save(category);
        assertNotEquals(0, category.getId());
    }
    @Test
    public void testGetAllCategory(){
        DaoExecuter<Category> daoExecuter = new DaoExecuter<>(Category.class);
        List<Category> listCategories = daoExecuter.getAll();
        listCategories.forEach(System.out::print);
        assertEquals(12, listCategories.size());
    }


}