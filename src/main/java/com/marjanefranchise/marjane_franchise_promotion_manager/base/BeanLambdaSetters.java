package com.marjanefranchise.marjane_franchise_promotion_manager.base;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.*;

import java.sql.Timestamp;
import java.util.*;

public abstract class BeanLambdaSetters {

//    private static List<BeanSetterFI> beanSettersAsLambdas;
    private static Map<String, BeanSetterFI> beanSettersAsLambdas;

    public static<T extends getBeanSettersFI> Map<String, BeanSetterFI> getBeanLambdaSetters(T bean){
        setBeanSetters(bean);
        return beanSettersAsLambdas;
    }

    public static<T extends getBeanSettersFI> void setBeanSetters(T bean){
        beanSettersAsLambdas = bean.getSetters();
    }

}
