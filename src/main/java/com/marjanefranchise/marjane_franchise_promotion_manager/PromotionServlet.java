package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.BeanController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.ManagerController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.PromotionController;
import com.marjanefranchise.marjane_franchise_promotion_manager.dao.DaoExecuter;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Category;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "PromotionServlet", value = "/PromotionServlet")
public class PromotionServlet extends HttpServlet {
    PromotionController promotionController;
    @Override
    public void init() throws ServletException {
        super.init();
        promotionController = new PromotionController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category = BeanController.find(2, Category.class);
        List<Category> listSubCategory = new ArrayList<>(Arrays.asList(
                category
        ));

        request.setAttribute("manager_id", 1);
//        request.setAttribute("manager_id", request.getSession().getAttribute("user_id"));
        request.setAttribute("percentage", 20f);
        request.setAttribute("validUntil", Timestamp.from(Instant.now()));
        request.setAttribute("listSubCategory", listSubCategory);
//        request.setAttribute("center", null);
        System.out.println(" ADDING PROMOTION ");
        promotionController.addPromotion(request, "manager_id", "percentage", "validUntil", "listSubCategory", "center");
    }
}
