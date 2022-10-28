package com.marjanefranchise.marjane_franchise_promotion_manager.base;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.*;

import java.sql.Timestamp;
import java.util.*;

public abstract class BeanLambdaSetters {

    private static Manager manager;
    private static SectionManager sectionManager;
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
    public static void setSectionManagerReference (SectionManager sectionManagerRef){
        sectionManager = sectionManagerRef;
    }
    public static void setPromotionReference (Promotion promotionRef){
        promotion = promotionRef;
    }
    public static void setCategoryReference (Category categoryRef){
        category = categoryRef;
    }
    public static<T extends getBeanSettersFI> void setBeanSetters(T bean){
        beanSettersAsLambdas = new ArrayList<>();
        for(int i = 0; i < bean.getSetters().size(); i++){
            beanSettersAsLambdas.add((BeanSetterFI)bean.getSetters().get(i));
        }
    }




}
