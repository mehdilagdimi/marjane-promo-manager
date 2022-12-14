package com.marjanefranchise.marjane_franchise_promotion_manager.dao;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.TransactionGetExecuterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.HibernateUtil.TransactionExecuter;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.IntStream;

public class DaoExecuter<T> extends TransactionExecuter{
    private Class<? extends T> type;
    String typeStr;
    String paramTypeStr;
    TransactionExecuterFI<Session> expression;
    TransactionGetExecuterFI<Session, T> getExpression;


    TransactionGetExecuterFI<Session, List<T>> getListExpression;
    TransactionGetExecuterFI<Session, T> getCountExpression;
    public DaoExecuter() {

    }
    public DaoExecuter(Class<T> beanImpl){
        type = beanImpl;
        typeStr = type.getSimpleName();
    }
    public void setType(Class<? extends T> type) {

        this.type = type;
        this.typeStr = this.type.getSimpleName();
    }


    public List<T> customSelectQuery(TransactionGetExecuterFI<Session, List<T>> getListExpressionParam){
        return (List<T>) executeTransaction(getListExpressionParam);
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
        getListExpression = (s -> (List<T>) s.createQuery("SELECT m FROM "+ typeStr +" m", type).getResultList());
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

    public long count(){
        getCountExpression = (s -> (T) s.createQuery("SELECT COUNT(*) FROM "+ typeStr +" m", type).uniqueResult());
        return  (long)executeTransaction(getCountExpression);
    }

    public long namedQueryCount(String namedQuery, String param, String value){
        getCountExpression = (s-> (T) s.createNamedQuery(namedQuery, type).setParameter(param, value).uniqueResult());
        return (long) executeTransaction(getCountExpression);
    }

}
