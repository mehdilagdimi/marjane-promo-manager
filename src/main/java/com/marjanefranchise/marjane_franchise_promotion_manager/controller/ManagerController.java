package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.EmailService.SimpleEmail;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


public class ManagerController {
    private Manager managerObj;
    public List<Manager> getAll(){
        return BeanController.getAll(Manager.class);
    }

    public void addManager(HttpServletRequest request, String findFirst, String... params){
        Manager manager = new Manager();
        //set manager on center entity before adding center to manager and creating it(manager)
        Center center = BeanController.find(Integer.parseInt(request.getParameter(findFirst)), Center.class);
        request.setAttribute("center", center);

        //set this current manager object reference in BeanLambdaSetters class in order to get its corresponding setters as lambda expressions
        BeanController.add(manager, Manager.class, request, params);
        managerObj = manager;
    }

    public void sendEmail(HttpServletRequest request){
        String email = request.getParameter("email");
        String passw = (String)request.getAttribute("passw");

        String msg = ""
                + "<h2>Marjane Back-Office : Auto-generated Password for temporary use</h2><br>"
                + "<h4 style=\"font-weight: normal;\">An account has been created for you to access your dashboard</h4><br>"
                + "<h4 style=\"font-weight: normal;\">Email : " + email + "</h4><br>"
                + "<h4 style=\"font-weight: normal;\">Password : " + passw + "</h4><br>"
                ;
        SimpleEmail.sendSimpleEmail(email, "Temporary Password", msg);
    }

    public Manager getManagerObj() {
        return managerObj;
    }
}
