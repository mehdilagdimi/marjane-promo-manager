package com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionGetExecuterFI;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class TransactionExecuter<T> {

    public void executeTransaction(TransactionExecuterFI transactionExpression){
        Transaction transaction = null;
        try{
            transaction = HibernateUtil.getSession().getTransaction();

            transaction.begin();
            transactionExpression.accept(HibernateUtil.getSession());
            transaction.commit();

        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
//            HibernateUtil.closeSession();
        }
    }
    public T executeTransaction(TransactionGetExecuterFI transactionGetExpression){
        Transaction transaction = null;
        T obj = null;
        try{
            transaction = HibernateUtil.getSession().getTransaction();

            transaction.begin();
            obj = (T) transactionGetExpression.accept(HibernateUtil.getSession());
            transaction.commit();

        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
//            HibernateUtil.closeSession();
        }
        return obj;
    }

//    public void executeTransaction(TransactionGetExecuterFI transactionExpression){
//        Transaction transaction = null;
//        try{
//            transaction = HibernateUtil.getSession().getTransaction();
//
//            transaction.begin();
//            transactionExpression.accept(HibernateUtil.getSession());
//            transaction.commit();
//
//        } catch (RuntimeException e){
//            e.printStackTrace();
//        } finally {
//            if(transaction.isActive()){
//                transaction.rollback();
//            }
//            HibernateUtil.closeSession();
//        }
//    }
}
