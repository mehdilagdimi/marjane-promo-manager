package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.controller.BeanController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.SectionManagerController;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Promotion;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.SectionManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

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
//        doPost(request,response);
        if(request.getParameter("get") != null) {
            List<SectionManager> sectionManagerList = null;
            if (request.getSession().getAttribute("role") == "superadmin") {
                if (request.getParameter("get").equals("all")) {
                    sectionManagerList = sectionManagerController.getAll();
                }
                } else if (request.getSession().getAttribute("role") == "manager") {
                    if (request.getParameter("get").equals("all")) {
                        sectionManagerList = sectionManagerController.getAllByMarket(request);
                }
            }
            request.setAttribute("records", sectionManagerList);
            request.setAttribute("recordstype", "sectionmanager");
            request.getRequestDispatcher("pages/dashboard.jsp").forward(request, response);
        }
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
