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

        if(request.getParameter("get") != null){
           if(request.getParameter("get").equals("all")){
               //check conencted user role
//               int id = request.getSession("user_id");
               int id = 1;
               //if role is manager then
//               if(request.getSession().getAttribute("role").equals("manager")){
                   List<Promotion> promotionList = promotionController.getAllForManager(id);
//               }
//                else if(request.getSession().getAttribute("role").equals("sectionmanager")){
//                    if(promotionController.checkAuthorizedAcessForManager()){
//                        List<Promotion> promotionList promotionController.getAllForSectionManager(id);
//                    } else {
//                        System.out.println(" Unauthorizd access promotions list : View of promotions only availabe btwn 8-12 ");
//                    }
//               }
               System.out.println(" getting promotions ");
               promotionList.forEach(System.out::println);
           }
        }
        //THIS IS FOR TESTING ADDING MANAGER REQUESTING THROUW BROWSER
//        doPost(request, response);
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
        //CHECK IF ROLE IS MANAGER BEFORE CONTINUE
        promotionController.addPromotion(request, "manager_id", "percentage", "validUntil", "listSubCategory", "center");
    }
}
