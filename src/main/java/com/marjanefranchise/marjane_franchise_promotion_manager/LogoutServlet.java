package com.marjanefranchise.marjane_franchise_promotion_manager;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            response.setContentType("text/html");
//            Cookie[] cookies = request.getCookies();
//            if(cookies != null){
//                for(Cookie cookie : cookies){
//                    if(cookie.getName().equals("JSESSIONID")){
//                        System.out.println("JSESSIONID="+cookie.getValue());
//                        break;
//                    }
//                }
//            }
            String baseUrl = "http://localhost:8080/marjane_franchise_promotion_manager_war_exploded/";
            //invalidate the session if exists
            HttpSession session = request.getSession(false);
            System.out.println("User="+session.getAttribute("user"));
            if(session != null){
                session.invalidate();
            }
            response.sendRedirect( baseUrl + "pages/loginPage.jsp");
        }
}
