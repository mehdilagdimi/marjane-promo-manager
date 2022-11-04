package com.marjanefranchise.marjane_franchise_promotion_manager;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String baseUrl = "http://localhost:8080/marjane_franchise_promotion_manager_war_exploded/";
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //set servlet path into request

        res.setHeader("Cache-Control","no-cache");
        res.setHeader("Cache-Control","no-store");
        res.setHeader("Pragma","no-cache");
        res.setDateHeader ("Expires", 0);
        String uri = req.getRequestURI();
        System.out.println("uri " + uri);

        System.out.println(" url " + req.getRequestURL());
        System.out.println( " param" + req.getParameter("loginattempt"));
        HttpSession session = req.getSession();
        System.out.println(" url " + req.getServletPath());
        System.out.println(" user obj " + session.getAttribute("user"));
        session.setAttribute("servletpath", req.getServletPath().toUpperCase());

        if(uri.contains("assets")) chain.doFilter(request, response);

        if(session.getAttribute("user") == null){
            if(req.getParameter("loginattempt") != null){
                chain.doFilter(request, response);
                return;
            }
            if(!uri.contains("loginPage.jsp")){
                    System.out.println(" inside page ");
                    res.sendRedirect(baseUrl + "pages/loginPage.jsp");
                    return;
            }
        } else {
            if(uri.contains("loginPage.jsp")){
                res.sendRedirect(baseUrl );
                return;
            }
        }
        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
}
