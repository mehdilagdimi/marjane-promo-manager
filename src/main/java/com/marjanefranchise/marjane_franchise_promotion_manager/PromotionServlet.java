package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanLambdaSetters;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.BeanController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.CategoryController;
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
import java.util.stream.Collectors;

@WebServlet(name = "PromotionServlet", value = "/PromotionServlet")
public class PromotionServlet extends HttpServlet {
    PromotionController promotionController;
    String baseURL;
    @Override
    public void init() throws ServletException {
        promotionController = new PromotionController();
        baseURL = getServletContext().getInitParameter("url");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //for testing doPost from direct browser requesting
//        doPost(request, response);
        if(request.getParameter("get") != null){
            List<Promotion> promotionList = null;
            List<Category> categoryList = null;
            if(request.getParameter("get").equals("all")){
               if(request.getSession().getAttribute("role").equals("superadmin")){
                   promotionList = promotionController.getAll();
               } else {
                   //check conencted user role
                   int id = (int)request.getSession().getAttribute("user_id");

                   //if role is manager then
                   if(request.getSession().getAttribute("role").equals("manager")){
                       promotionList = promotionController.getAllForManager(id);
                       categoryList = new CategoryController().getAllSubCategory();
                       request.getSession().setAttribute("subcategoriesoptions", categoryList);
                   }
                    else if(request.getSession().getAttribute("role").equals("sectionmanager")){
                        if(promotionController.checkAuthorizedAccessForManager()){
                            promotionList = promotionController.getAllForSectionManager(request);
                        } else {
                            System.out.println(" Unauthorizd access promotions list : View of promotions only availabe btwn 8-12 ");
                            request.setAttribute("unauthorizedAccess", true);
                        }
                   }
               }
                request.getSession().setAttribute("records", promotionList);
                request.getSession().setAttribute("recordstype", "promotion");
                request.getRequestDispatcher("pages/dashboard.jsp").forward(request,response);
           }

        } else if(request.getParameter("selected") != null){
            int selectedPromoId = Integer.valueOf(request.getParameter("selected"));
            List<Promotion> promotionList = ((List<Promotion>)request.getSession().getAttribute("records"));
            Promotion selectedPromotion = promotionList.stream().filter(promotion -> promotion.getId() == selectedPromoId).collect(Collectors.toList()).get(0);

            request.getSession().setAttribute("selectedPromotion", selectedPromotion);
            request.getRequestDispatcher("pages/dashboard.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("post")!= null){
            //get params passed in url; this was made to make posting promotion, comment, status in same request if wanted
           String[] params = request.getParameter("post").split(",");
            if(Arrays.stream(params).anyMatch(param -> param.equals("promotion"))){
                //CHECK IF ROLE IS MANAGER BEFORE CONTINUE
                System.out.println(" ADDING PROMOTION ");
                promotionController.addPromotion(request,  "percentage", "validUntil", "subcategories", "center");
            }
            if (Arrays.stream(params).anyMatch(param -> param.equals("status")) && Arrays.stream(params).anyMatch(param -> param.equals("status"))){
                if(request.getParameter("promotionId")!= null){
                    promotionController.updatePromotionStatusAndComment(request, "promotionId");
                }
            }
            response.sendRedirect(baseURL + "PromotionServlet?get=all");
        }
    }
}
