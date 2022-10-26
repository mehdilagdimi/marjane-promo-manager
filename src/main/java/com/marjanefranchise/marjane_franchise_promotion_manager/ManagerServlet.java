package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.BeanController;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ManagerServlet", value = "/ManagerServlet")
public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("fullname", "lagdimimehdi");
        request.setAttribute("email", "lagdimi.mehdi@gmail.com");
        request.setAttribute("passw", "1234");
        String[] params = {"fullname", "email", "passw","center"};


        Manager manager = new Manager();
        //set manager on center entity before adding center to manager and creating it(manager)
        Center center = BeanController.find(2, Center.class);
        BeanSetterFI<Manager> beanSetFullName = m -> m.setFullname("lagdimimehdi");
        BeanSetterFI<Manager> beanSetEmail = m -> m.setEmail("lagdimi.mehdi@gmail.com");
        BeanSetterFI<Manager> beanSetPassword = m -> m.setPassw("1234");
        BeanSetterFI<Manager> beanSetCenter = m -> m.setCenter(center);
        List<BeanSetterFI> beanSetters = new ArrayList<>(
                Arrays.asList(
                        beanSetFullName,
                        beanSetEmail,
                        beanSetPassword,
                        beanSetCenter
                )
        );

        System.out.println(" adding manager ");

        Manager retManager = BeanController.add(manager, Manager.class, params, beanSetters);
        System.out.println(" ret man" + retManager.getCenter().getCity());
        System.out.println(" ret man" + retManager.getEmail());
        System.out.println(" ret man" + retManager.getFullname());

    }
}
