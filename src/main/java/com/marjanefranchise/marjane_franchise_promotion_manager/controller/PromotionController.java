package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Promotion;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.SectionManager;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;


public class PromotionController<T> {

    public List<Promotion> getAllForManager(int id){
       Manager manager = BeanController.find(id, Manager.class);

       List<Promotion> promotionList = BeanController.getAll(Promotion.class);
       return promotionList.stream()
               .filter(promotion -> promotion.getCenter() == manager.getCenter())
               .collect(Collectors.toList());
    }
    public List<Promotion> getAllForSectionManager(int id){
           SectionManager sectionManager = BeanController.find(id, SectionManager.class);

           List<Promotion> promotionList = BeanController.getAll(Promotion.class);
           return promotionList.stream()
                   .filter(promotion -> promotion.getCenter() == sectionManager.getCenter())
                   .collect(Collectors.toList());
    }

    public boolean checkAuthorizedAcessForManager(){
        LocalTime start = LocalTime.parse("08:00");
        LocalTime end = LocalTime.parse("12:00");
        LocalTime now = LocalTime.now();
        return (now.isAfter(start) && now.isBefore(end));
    }
    public void addPromotion(HttpServletRequest request, String findFirst, String... params){
        Promotion promotion = new Promotion();
        //set manager on center entity before adding center to manager and creating it(manager)
        Manager manager = BeanController.find((int)request.getAttribute(findFirst), Manager.class);
        Center center = manager.getCenter();
        request.setAttribute("center", center);

        //set this current manager object reference in BeanLambdaSetters class in order to get its corresponding setters as lambda expressions
        BeanLambdaSetters.setPromotionReference(promotion);
        BeanLambdaSetters.setBeanSetters(promotion);
        BeanController.add(promotion, Promotion.class, request, params);
    }



}
