package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.HibernateUtil;
import jakarta.persistence.Table;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;



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
    public void testInsertSubCategory(){
        Session session = HibernateUtil.getSession() != null ? HibernateUtil.getSession() : HibernateUtil.openSession();
//        session.createQuery()
//        CategoryDao categoryDao = new CategoryDao();
//        System.out.println(" adding laptops ");
//         = session.createCriteria(Category.class);
//        YourObject yourObject = criteria.add(Restrictions.eq("yourField", yourFieldValue))
//                .uniqueResult();
//        Category subCategory = new Category();
//        subCategory.setName("Laptop");
//        subCategory.setParent(category);
//        category.addSubCategory(subCategory);
//        categoryDao.addSubCategory(16);
    }

}