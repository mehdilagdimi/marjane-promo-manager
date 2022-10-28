package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import jakarta.servlet.http.HttpServletRequest;



public class ManagerController {

    public void addManager(HttpServletRequest request, String findFirst, String... params){
        Manager manager = new Manager();
        //set manager on center entity before adding center to manager and creating it(manager)
        Center center = BeanController.find((int)request.getAttribute(findFirst), Center.class);
        request.setAttribute("center", center);

        //set this current manager object reference in BeanLambdaSetters class in order to get its corresponding setters as lambda expressions
        BeanLambdaSetters.setManagerReference(manager);
        BeanLambdaSetters.setBeanSetters(manager);
        BeanController.add(manager, Manager.class, request, params);
    }

}
