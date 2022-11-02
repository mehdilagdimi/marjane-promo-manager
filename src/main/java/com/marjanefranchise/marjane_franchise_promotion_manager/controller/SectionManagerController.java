package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.*;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


public class SectionManagerController {

    public List<SectionManager> getAll(){
        return BeanController.getAll(SectionManager.class);
    }
    public void addSectionManager(HttpServletRequest request, String findFirst, String... params){
        SectionManager sectionManager = new SectionManager();
        //set sectionManager on center entity before adding center to sectionManager and creating it(sectionManager)
        Manager manager = BeanController.find((int)request.getAttribute(findFirst), Manager.class);
        request.setAttribute("center", manager.getCenter());
        //set this current sectionManager object reference in BeanLambdaSetters class in order to get its corresponding setters as lambda expressions
        BeanLambdaSetters.setBeanSetters(sectionManager);
        BeanController.add(sectionManager, SectionManager.class, request, params);
    }


}
