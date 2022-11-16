package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.controller.BeanController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.CategoryController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.PromotionController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.StatisticController;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Promotion;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.SectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "StatisticServlet", value = "/StatisticServlet")
public class StatisticServlet extends HttpServlet {
    StatisticController statisticController;
    String baseURL;
    @Override
    public void init() throws ServletException {
        statisticController = new StatisticController();
        baseURL = getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //for testing doPost from direct browser requesting
//        doPost(request, response);
//        if(request.getParameter("get") != null){
//
////
//
//        }
        request.getSession().setAttribute("recordstype", "statistics");
        System.out.println( " promotion count" + BeanController.count(Promotion.class));
        request.getSession().setAttribute("promotionCount", BeanController.count(Promotion.class));
        request.getSession().setAttribute("managerCount", BeanController.count(Manager.class));
        request.getSession().setAttribute("categoryCount", BeanController.count(Category.class));
        request.getSession().setAttribute("sectionManagerCount", BeanController.count(SectionManager.class));
        request.getSession().setAttribute("promotionStatusStatistics", statisticController.getPromotionStatusPercentages());

        request.getRequestDispatcher("pages/dashboard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
