package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.*;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.TimeHelper.TimeUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class PromotionController<T> {

    public List<Promotion> getAll(){
        return BeanController.getAll(Promotion.class);
    }

    public List<Promotion> getAllForManager(int id){
       Manager manager = BeanController.find(id, Manager.class);

       List<Promotion> promotionList = BeanController.getAll(Promotion.class);
       return promotionList.stream()
               .filter(promotion -> promotion.getCenter() == manager.getCenter())
               .collect(Collectors.toList());
    }
    public List<Promotion> getAllForSectionManager(HttpServletRequest request){
            SectionManager sectionManager = (SectionManager) request.getSession().getAttribute("user");
           List<Promotion> promotionListForCenter = BeanController.customSelectQuerySingleParam(Promotion.class, Integer.class, "center", sectionManager.getCenter().getId());
          return promotionListForCenter.stream()
                   .filter(promotion -> promotion.getSubCategoryList().stream().anyMatch(category -> category.getParent() ==  sectionManager.getCategory()))
                   .collect(Collectors.toList());
    }

    public boolean checkAuthorizedAccessForManager(){
        LocalTime start = LocalTime.parse("08:00");
        LocalTime end = LocalTime.parse("12:00");
        LocalTime now = LocalTime.now();
        return (now.isAfter(start) && now.isBefore(end));
    }
    public void addPromotion(HttpServletRequest request, String... params){
        Promotion promotion = new Promotion();
        Manager manager =  (Manager)request.getSession().getAttribute("user");

        List<Category> listSubCategory = new ArrayList<>();
        for(String subCategoryId : request.getParameterValues("selectSubCategories")){
            System.out.printf(" cat id " + subCategoryId);
            listSubCategory.add(BeanController.find(Integer.valueOf(subCategoryId), Category.class));
        }

        request.setAttribute("subcategories", listSubCategory);
        request.setAttribute("percentage", Float.valueOf(request.getParameter("percentage")));
        request.setAttribute("validUntil", TimeUtil.stringToTimestamp(request.getParameter("validUntil")));
        request.setAttribute("center", manager.getCenter());

        //set this current manager object reference in BeanLambdaSetters class in order to get its corresponding setters as lambda expressions
        BeanController.add(promotion, Promotion.class, request, params);
    }
    public void updatePromotionStatusAndComment(HttpServletRequest request, String findFirst){
        Promotion promotion = BeanController.find(Integer.valueOf(request.getParameter(findFirst)), Promotion.class);
        request.setAttribute("status", request.getParameter("status"));
        request.setAttribute("comment", request.getParameter("comment"));
        BeanController.update(promotion, Promotion.class, request, "status", "comment");
    }
    public void updatePromotionStatus(HttpServletRequest request){
        Promotion promotion = (Promotion) request.getAttribute("promotion");
        promotion.setStatus((String)request.getAttribute("status"));
        BeanController.simpleUpdate(promotion, Promotion.class);
    }
    public void addPromotionComment(HttpServletRequest request){
        Promotion promotion = (Promotion) request.getAttribute("promotion");
        promotion.setComment((String)request.getAttribute("comment"));
        BeanController.simpleUpdate(promotion, Promotion.class);
    }

}
