package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.Person;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.AuthController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.ManagerController;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.SectionManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

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

        if(AuthController.checkEmailExist(email, Manager.class)){
            if(AuthController.checkAccountExist(email, passw, Manager.class) != null){
                System.out.println(" manager ");
                Manager user = AuthController.checkAccountExist(email, passw, Manager.class);
                request.getSession().setAttribute("user", user);
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
