package com.marjanefranchise.marjane_franchise_promotion_manager;

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

//                request.getRequestDispatcher("index.jsp").forward(request,response);
                response.sendRedirect(baseURL);
                return;
            }
        } else {
                request.getRequestDispatcher("pages/loginPage.jsp").forward(request,response);
                return;
        }
        return;
//        else if(AuthController.checkEmailExist(email, SectionManager.class)){
//            if(AuthController.checkAccountExist(email, passw, SectionManager.class)){
//                System.out.println(" sectionmanager ");
//            } else {
//
//            }
//
//        }

//        if(userID.equals(user) && password.equals(pwd)){
//            HttpSession session = request.getSession();
//            session.setAttribute("user", "Pankaj");
//            //setting session to expiry in 30 mins
//            session.setMaxInactiveInterval(30*60);
//            Cookie userName = new Cookie("user", user);
//            userName.setMaxAge(30*60);
//            response.addCookie(userName);
//            response.sendRedirect("loginSuccess.jsp");
//        }else{
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//            PrintWriter out= response.getWriter();
//            out.println("<font color=red>Either user name or password is wrong.</font>");
//            rd.include(request, response);
//        }

    }
}
