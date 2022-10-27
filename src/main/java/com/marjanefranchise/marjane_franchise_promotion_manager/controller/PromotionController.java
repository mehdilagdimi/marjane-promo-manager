package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Promotion;
import jakarta.servlet.http.HttpServletRequest;


public class PromotionController {

    public void addPromotion(HttpServletRequest request, String findFirst, String... params){
        Promotion promotion = new Promotion();
        //set manager on center entity before adding center to manager and creating it(manager)
        Manager manager = BeanController.find((int)request.getAttribute(findFirst), Manager.class);
        Center center = manager.getCenter();
        request.setAttribute("center", center);

        //set this current manager object reference in BeanLambdaSetters class in order to get its corresponding setters as lambda expressions
        BeanLambdaSetters.setPromotionReference(promotion);
        BeanLambdaSetters.setPromotionSetters();
        BeanController.add(promotion, Promotion.class, request, params);
    }

}
