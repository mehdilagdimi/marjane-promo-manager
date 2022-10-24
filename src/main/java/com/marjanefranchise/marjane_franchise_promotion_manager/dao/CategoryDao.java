package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDao {

    public void addCategory(){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Category category = new Category();
        category.setName("Electronics");
        category.setParent(null);
        category.addCategory(category);
        System.out.println(" adding electo ");
        session.persist(category);
        transaction.commit();
    }
    public void addSubCategory(int category_id){
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Category category = session.find(Category.class, category_id);
        System.out.println(" printing parent " + category.getId());
        Category subCategory = new Category();
        subCategory.setName("Laptop");
//        subCategory.setParent(category);
        category.addSubCategory(subCategory);
        System.out.println(" adding sub category  ");
        session.persist(category);
        transaction.commit();
    }

}
