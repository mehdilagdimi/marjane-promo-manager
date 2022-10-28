package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.controller.BeanController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.SectionManagerController;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SectionManagerServlet", value = "/SectionManagerServlet")
public class SectionManagerServlet extends HttpServlet {

    SectionManagerController sectionManagerController;
    @Override
    public void init() throws ServletException {
        super.init();
        sectionManagerController = new SectionManagerController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("manager_id", 1);
        request.setAttribute("fullname", "sectionManager_01");
        request.setAttribute("email", "lagdimi.mehdi@gmail.com");
        request.setAttribute("passw", "1234");


        Category category = BeanController.find(1, Category.class);
        request.setAttribute("category", category);

        sectionManagerController.addSectionManager(request, "manager_id", "fullname", "email", "passw", "center", "category");


    }
}
