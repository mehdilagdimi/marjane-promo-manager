package com.marjanefranchise.marjane_franchise_promotion_manager.base;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Promotion;

import java.sql.Timestamp;
import java.util.*;

public abstract class BeanLambdaSetters {

    private static Manager manager;
    private static Promotion promotion;
    private static Category category;
    private static List<BeanSetterFI> beanSettersAsLambdas;

//    public static void setAllBeansSettersAsLambda (){
//        allBeansSettersAsLambda = new HashMap<>(Map.ofEntries(
//                Map.entry("Manager", managerSettersAsLambdas)
//        ));
//    }
    public static List<BeanSetterFI> getBeanLambdaSetters(String bean){
        return beanSettersAsLambdas;
    }

    public static void setManagerReference (Manager managerRef){
        manager = managerRef;
    }
    public static void setPromotionReference (Promotion promotionRef){
        promotion = promotionRef;
    }
    public static void setCategoryReference (Category categoryRef){
        category = categoryRef;
    }
    public static void setManagerSetters(){
        BeanSetterFI<String> beanSetFullName = manager::setFullname;
        BeanSetterFI<String> beanSetEmail = manager::setEmail;
        BeanSetterFI<String> beanSetPassword = manager::setPassw;
        BeanSetterFI<Center> beanSetCenter = manager::setCenter;

        beanSettersAsLambdas = new ArrayList<>(Arrays.asList(
                beanSetFullName,
                beanSetEmail,
                beanSetPassword,
                beanSetCenter
        ));
    }
    public static void setPromotionSetters(){
        BeanSetterFI<Float> beanSetPercentage = promotion::setPercentage;
        BeanSetterFI<Timestamp> beanSetValidUntil = promotion::setValidUntil;
        BeanSetterFI<List<Category>> beanSetSubCategory = promotion::addSubCategory;
        BeanSetterFI<Center> beanSetCenter = promotion::setCenter;

        beanSettersAsLambdas = new ArrayList<>(Arrays.asList(
                beanSetPercentage,
                beanSetValidUntil,
                beanSetSubCategory,
                beanSetCenter
        ));
    }
    public static void setCategorySetters(){
        BeanSetterFI<String> beanSetFullName = category::setName;
        BeanSetterFI<Category> beanSetParent = category::setParent;


        beanSettersAsLambdas = new ArrayList<>(Arrays.asList(
                beanSetFullName,
                beanSetParent
        ));
    }


}
