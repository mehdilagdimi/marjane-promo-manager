//package com.marjanefranchise.marjane_franchise_promotion_manager.dao;
//
//import com.marjanefranchise.marjane_franchise_promotion_manager.base.DaoBase;
//import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionExecuterFI;
//import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionGetExecuterFI;
//import com.marjanefranchise.marjane_franchise_promotion_manager.base.TranscationExecuterFI;
//import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
//import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
//import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.HibernateUtil;
//import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import java.util.List;
//
//public class CategoryDao extends TransactionExecuter implements DaoBase<Category> {
//    private Category category;
//    TransactionExecuterFI<Session> expression;
//    TransactionGetExecuterFI<Session, Manager> getExpression;
//    TransactionGetExecuterFI<Session, List<Manager>> getListExpression;
//
//    @Override
//    public Category get(int id){
//        Category category = null;
//        try{
//            category = session.find(Category.class, id);
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return category;
//    }
//    @Override
//    public Category find(int id){
//        Category category = null;
//        try{
//            category = session.find(Category.class, id);
//
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return category;
//    }
//
//    @Override
//    public List<Category> getAll(){
//        return null;
//    }
//
//    @Override
//    public void save(Category category){
//        Transaction transaction = session.getTransaction();
//        try{
//            transaction.begin();
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
//
//    @Override
//    public void update(Category category, String params[]){
//
//    }
//
//    @Override
//    public void delete(Category category){
//        Transaction transaction = session.getTransaction();
//        try{
//            transaction.begin();
//            session.remove(category);
//            transaction.commit();
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            if(transaction.isActive()){
//                transaction.rollback();
//            }
//            session.close();
//        }
//
//    }
//
////    public void addCategory(){
//////        Transaction transaction = session.getTransaction();
////        session.getTransaction().begin();
////        Category category = new Category();
////        category.setName("Electronics");
////        category.setParent(null);
////        category.addCategory(category);
////        System.out.println(" adding electo ");
////        session.persist(category);
//////        transaction.commit();
////        session.getTransaction().commit();
////    }
////
////    public void addSubCategory(int category_id){
////        Transaction transaction = session.getTransaction();
////        try{
////            transaction.begin();
////            Category category = session.find(Category.class, category_id);
////            System.out.println(" printing parent " + category.getId());
////            Category subCategory = new Category();
////            subCategory.setName("Laptop");
////    //        subCategory.setParent(category);
////            category.addSubCategory(subCategory);
////            System.out.println(" adding sub category  ");
////            session.persist(category);
////            transaction.commit();
////        } catch (Exception e){
////            e.printStackTrace();
////        } finally {
////            if(transaction.isActive()){
////                transaction.rollback();
////            }
////            session.close();
////        }
////    }
//
//}
