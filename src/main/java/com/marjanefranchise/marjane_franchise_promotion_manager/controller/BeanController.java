package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.dao.DaoExecuter;
import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.IntStream;

public class BeanController{

    private static DaoExecuter daoExecuter = new DaoExecuter<>();


    public static<T> T find(int id, Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        return (T) daoExecuter.find(id);
    }

    //pass request and get params values to set them into bean
    public static<T> T add(T bean, Class<T> beanImpl, HttpServletRequest request, String... params)  {
        daoExecuter.setType(beanImpl);

        IntStream.range(0, params.length).forEachOrdered( i -> {
            BeanLambdaSetters.getBeanLambdaSetters(bean.getClass().getSimpleName()).get(i).set(request.getAttribute(params[i]));
        });

        daoExecuter.save(bean);
        return bean;
    }

    public static<T> void update(T bean, Class<T> beanImpl, String[] params, BeanSetterFI[] beanSetters, HttpServletRequest request){
        daoExecuter.setType(beanImpl);

        IntStream.range(0, params.length).forEachOrdered(i -> {
            beanSetters[i].set(request.getParameter(params[i]));
        });

        daoExecuter.update(bean);
    }

//    public static<T1, T2> void updateBean(T1 bean, Class<T1> beanImpl, List<T2> params, BeanSetterFI[] beanSetters, HttpServletRequest request){
//        daoExecuter.setType(beanImpl);
//
//        IntStream.range(0, beanSetters.length).forEachOrdered(i -> {
//            beanSetters[i].set(params.get(i));
//        });
//
//        daoExecuter.update(bean);
//    }
//    public static<T1, T2> void updateBean(T1 bean, Class<T1> beanImpl, T2 param, BeanSetterFI beanSetter){
//        daoExecuter.setType(beanImpl);
//        beanSetter.set(param);
//        daoExecuter.update(bean);
//    }
//
    public static<T> void delete(T bean, Class<T> beanImpl){
        daoExecuter.setType(beanImpl);
        daoExecuter.save(bean);
    }

}
