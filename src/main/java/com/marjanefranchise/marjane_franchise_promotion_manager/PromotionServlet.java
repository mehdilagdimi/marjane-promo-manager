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
    String baseURL;
    @Override
    public void init() throws ServletException {
        super.init();
        promotionController = new PromotionController();
        baseURL = getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //for testing doPost from direct browser requesting
//        doPost(request, response);

        if(request.getParameter("get") != null){
            List<Promotion> promotionList = null;
           if(request.getParameter("get").equals("all")){
               if(request.getSession().getAttribute("role").equals("superadmin")){
                   promotionList = promotionController.getAll();
               } else {
                   //check conencted user role
                   int id = (int)request.getSession().getAttribute("user_id");

                   //if role is manager then
                   if(request.getSession().getAttribute("role").equals("manager")){
                       promotionList = promotionController.getAllForManager(id);
                   }
                    else if(request.getSession().getAttribute("role").equals("sectionmanager")){
                        if(promotionController.checkAuthorizedAcessForManager()){
                            promotionList = promotionController.getAllForSectionManager(id);
                        } else {
                            System.out.println(" Unauthorizd access promotions list : View of promotions only availabe btwn 8-12 ");
                        }
                   }
               }
               //clear attrivute records
//                if(request.getAttribute("records")!= null){
//                    request.removeAttribute("records");
//                }
                request.setAttribute("records", promotionList);
                request.setAttribute("recordstype", "promotion");
                request.getRequestDispatcher("pages/dashboard.jsp").forward(request,response);
           }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("post")!= null){
           String[] params = request.getParameter("post").split(",");
            if(Arrays.stream(params).anyMatch(param -> param.equals("promotion"))){
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
                //CHECK IF ROLE IS MANAGER BEFORE CONTINUE
                promotionController.addPromotion(request, "manager_id", "percentage", "validUntil", "listSubCategory", "center");
            }
            if (Arrays.stream(params).anyMatch(param -> param.equals("status"))){
                if(request.getParameter("promotion")!= null){
                    Promotion promotion = BeanController.find(1, Promotion.class);
                    request.setAttribute("promotion", promotion);
                    request.setAttribute("status", "accepter");
                    promotionController.updatePromotionStatus(request);
                }
            }
            if(Arrays.stream(params).anyMatch(param -> param.equals("comment"))){
                if(request.getParameter("promotion")!= null){
                    Promotion promotion = BeanController.find(1, Promotion.class);
                    request.setAttribute("promotion", promotion);
                    request.setAttribute("comment", "Quantité de stock suffisante : 80");
                    promotionController.addPromotionComment(request);
                }
            }

        }
    }
}
