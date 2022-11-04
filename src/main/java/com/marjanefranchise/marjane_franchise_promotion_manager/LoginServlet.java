package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.AuthController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.ManagerController;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.SectionManager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.SuperAdmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    AuthController authController;
    String baseURL;
    @Override
    public void init() throws ServletException {
        authController = new AuthController();
        baseURL = getServletContext().getInitParameter("url");
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for userID and password
        String email = request.getParameter("email");
        String passw = request.getParameter("password");

        Map<String, String> titleMap = new LinkedHashMap<>();
            titleMap.put("superadmin", "Super Admin Dashboard");
            titleMap.put("manager", "Manager Dashboard");
            titleMap.put("sectionmanager", "Section Manager Dashboard");

        Map<String, String[]> superAdminSideBarContent = new LinkedHashMap<>();
            superAdminSideBarContent.put("Statistics", new String[] {"#", "fa-solid fa-chart-pie"});
            superAdminSideBarContent.put("Promotion", new String[] {"PromotionServlet?get=all", "fa-solid fa-percent"});
            superAdminSideBarContent.put("SectionManager" , new String[] {"SectionManagerServlet?get=all", "fa-solid fa-people-roof"});
            superAdminSideBarContent.put("Category", new String[] {"#", "fa-solid fa-layer-group"});
            superAdminSideBarContent.put("Manager", new String[] {"ManagerServlet?get=all","fa-solid fa-people-roof"});
            superAdminSideBarContent.put("Center", new String[] {"#", "fa-solid fa-shop"});

        Map<String, String[]> managerSideBarContent = new LinkedHashMap<>();
            managerSideBarContent.put("Statistics", new String[] {"#", "fa-solid fa-chart-pie"});
            managerSideBarContent.put("Promotion", new String[] {"PromotionServlet?get=all", "fa-solid fa-percent"});
            managerSideBarContent.put("Category",new String[] {"#", "fa-solid fa-layer-group"});
            managerSideBarContent.put("SectionManager" , new String[] {"SectionManagerServlet?get=all","fa-solid fa-people-roof"});

        Map<String, Map<String, String[]>> sideBarContentMap = new LinkedHashMap<>(Map.ofEntries(
                Map.entry("superadmin", superAdminSideBarContent),
                Map.entry("manager", managerSideBarContent)
        ));


        request.getSession().setAttribute("headerTitles", titleMap);
        request.getSession().setAttribute("sidebarTabs", sideBarContentMap);


        //check if super admin station
        if(AuthController.checkIfSuperAdmin(email, passw)){

            SuperAdmin user = SuperAdmin.getInstance("SuperAdmin", email, passw);
//
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("role", "superadmin");
            request.getSession().setMaxInactiveInterval(30*60);
            response.sendRedirect(baseURL + "pages/dashboard.jsp");
            return;
        }

        if(AuthController.checkEmailExist(email, Manager.class)){
            if(AuthController.checkAccountExist(email, passw, Manager.class) != null){
                System.out.println(" manager ");
                Manager user = AuthController.checkAccountExist(email, passw, Manager.class);
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("user_id", user.getId());
                request.getSession().setAttribute("role", "manager");
                request.getSession().setMaxInactiveInterval(30*60);
//                Cookie userName = new Cookie("user_", user);
//                userName.setMaxAge(30*60);
//                response.addCookie(userName);
                response.sendRedirect(baseURL + "pages/dashboard.jsp");
                return;
            }
        } else if(AuthController.checkEmailExist(email, SectionManager.class)) {
            if(AuthController.checkAccountExist(email, passw, SectionManager.class) != null){
                System.out.println(" Section Manager ");
                SectionManager user = AuthController.checkAccountExist(email, passw, SectionManager.class);
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("user_id", user.getId());
                request.getSession().setAttribute("role", "sectionManager");
                request.getSession().setMaxInactiveInterval(30*60);
                response.sendRedirect(baseURL + "pages/dashboard.jsp");
            }

        }
        else {
                request.getRequestDispatcher("pages/loginPage.jsp").forward(request,response);
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
                return;
        }

    }
}
