package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionGetExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.TransactionExecuter;
import org.hibernate.Session;

import java.util.List;

public class DaoExecuter<T> extends TransactionExecuter{
    private Class<? extends T> type;
    String typeStr;
    TransactionExecuterFI<Session> expression;
    TransactionGetExecuterFI<Session, T> getExpression;


    TransactionGetExecuterFI<Session, List<T>> getListExpression;
    public DaoExecuter() {

    }
    public DaoExecuter(Class<T> beanImpl){
        type = beanImpl;
        typeStr = type.getClass().getSimpleName();
    }
    public void setType(Class<? extends T> type) {
        this.type = type;
    }

    public T get(int id){
        getExpression = (s -> s.get(type, id));
        return (T) executeTransaction(getExpression);
    }

    public T find(int id){
        getExpression = (s -> s.find(type, id));
        return (T) executeTransaction(getExpression);
    }

    public List<T> getAll(){
        System.out.println(" type " + typeStr);
        System.out.println(" type get class " + type.getClass().toString());
        getListExpression = (s -> (List<T>) s.createQuery("SELECT m FROM "+ typeStr +" m", type.getClass()).getResultList());
        return (List<T>) executeTransaction(getListExpression);
    }

    public void save(T jpaBean){
        expression = (s -> s.persist(jpaBean));
        executeTransaction(expression);
    }

    public void update(T jpaBean){
        expression = (s -> s.merge(jpaBean));
        executeTransaction(expression);
    }

    public void delete(T jpaBean){
        expression = (s -> s.remove(jpaBean));
        executeTransaction(expression);
    }
}
