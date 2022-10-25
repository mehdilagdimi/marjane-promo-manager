package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.DaoBase;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionGetExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.HibernateUtil;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.TransactionExecuter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ManagerDao extends TransactionExecuter implements DaoBase<Manager> {

    Manager manager = null;
    TransactionExecuterFI<Session> expression;
    TransactionGetExecuterFI<Session, Manager> getExpression;
    TransactionGetExecuterFI<Session, List<Manager>> getListExpression;

    @Override
    public Manager get(int id){
        getExpression = (s -> s.get(Manager.class, id));
        return (Manager) executeTransaction(getExpression);
    }

    @Override
    public Manager find(int id){
        getExpression = (s -> s.find(Manager.class, id));
        return (Manager) executeTransaction(getExpression);
    }

    @Override
    public List<Manager> getAll(){
        getListExpression = (s -> s.createQuery("SELECT m FROM Manager m", Manager.class).getResultList());
        return null;
    }

    @Override
    public void save(Manager manager){
        expression = (s -> s.persist(manager));
        executeTransaction(expression);
    }

    @Override
    public void update(Manager manager, String params[]){
        expression = (s -> s.merge(manager));
        executeTransaction(expression);
    }

    @Override
    public void delete(Manager manager){
        expression = (s -> s.remove(manager));
        executeTransaction(expression);
    }



}
