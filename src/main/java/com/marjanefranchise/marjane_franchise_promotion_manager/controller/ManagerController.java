package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ManagerController {

    public void addManager(HttpServletRequest request, String findFirst, String... params){
        Manager manager = new Manager();
        //set manager on center entity before adding center to manager and creating it(manager)
        Center center = BeanController.find((int)request.getAttribute(findFirst), Center.class);
        request.setAttribute("center", center);

        BeanLambdaSetters.setManagerReference(manager);
        BeanController.add(manager, Manager.class, request, params);
    }

}
