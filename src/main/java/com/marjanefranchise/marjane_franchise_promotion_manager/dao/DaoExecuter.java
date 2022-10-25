package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionGetExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.TransactionExecuter;
import org.hibernate.Session;

import java.util.List;

public class DaoExecuter<T> extends TransactionExecuter{
    private Class<T> type;
    String typeStr;
    TransactionExecuterFI<Session> expression;
    TransactionGetExecuterFI<Session, T> getExpression;
    TransactionGetExecuterFI<Session, List<T>> getListExpression;
    public DaoExecuter(Class<T> beanImpl){
        type = beanImpl;
        typeStr = type.getClass().toString();
    }

    public T get(int id){
        getExpression = (s -> s.get(type, id));
//        getExpression = (s -> s.get(Category.class, id));
        return (T) executeTransaction(getExpression);
    }

    public T find(int id){
        getExpression = (s -> s.find(type, id));
        return (T) executeTransaction(getExpression);
    }

    public List<T> getAll(){
//        Class<T> clss;
        getListExpression = (s -> (List<T>) s.createQuery("SELECT m FROM "+ typeStr +" m", type.getClass()).getResultList());
        return null;
    }

    public void save(T jpaBean){
        expression = (s -> s.persist(jpaBean));
        executeTransaction(expression);
    }

    public void update(T jpaBean, String params[]){
        expression = (s -> s.merge(jpaBean));
        executeTransaction(expression);
    }

    public void delete(T jpaBean){
        expression = (s -> s.remove(jpaBean));
        executeTransaction(expression);
    }

//    public void addCategory(){
////        Transaction transaction = session.getTransaction();
//        session.getTransaction().begin();
//        Category category = new Category();
//        category.setName("Electronics");
//        category.setParent(null);
//        category.addCategory(category);
//        System.out.println(" adding electo ");
//        session.persist(category);
////        transaction.commit();
//        session.getTransaction().commit();
//    }
//
//    public void addSubCategory(int category_id){
//        Transaction transaction = session.getTransaction();
//        try{
//            transaction.begin();
//            Category category = session.find(Category.class, category_id);
//            System.out.println(" printing parent " + category.getId());
//            Category subCategory = new Category();
//            subCategory.setName("Laptop");
//    //        subCategory.setParent(category);
//            category.addSubCategory(subCategory);
//            System.out.println(" adding sub category  ");
//            session.persist(category);
//            transaction.commit();
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            if(transaction.isActive()){
//                transaction.rollback();
//            }
//            session.close();
//        }
//    }

}
