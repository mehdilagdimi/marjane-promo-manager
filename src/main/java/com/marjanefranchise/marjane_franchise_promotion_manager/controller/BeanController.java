package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.dao.DaoExecuter;

import java.util.stream.IntStream;

public class BeanController<T> {

    private DaoExecuter daoExecuter;

    public BeanController(){
        daoExecuter = new DaoExecuter<>();
    }

    public T find(int id, Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        return (T) daoExecuter.find(id);
    }

    public void add(T bean, Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        daoExecuter.save(bean);
    }

    public void update(T bean, Class<T> beanImpl, String[] params, BeanSetterFI[] beanSetters){
        daoExecuter.setType(beanImpl);

        IntStream.range(0, params.length).forEachOrdered(i -> {
            beanSetters[i].set(params[i]);
        });

        daoExecuter.update(bean);
    }

    public void delete(T bean, Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        daoExecuter.save(bean);
    }

}
