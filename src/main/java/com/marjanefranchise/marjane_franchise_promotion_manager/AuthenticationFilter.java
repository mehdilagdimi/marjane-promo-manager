//package com.marjanefranchise.marjane_franchise_promotion_manager;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.*;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//
//@WebFilter(filterName = "AuthenticationFilter", value = "/AuthenticationFilter")
//public class AuthenticationFilter implements Filter {
//    private ServletContext context;
//
//    public void init(FilterConfig fConfig) throws ServletException {
//        this.context = fConfig.getServletContext();
//        this.context.log("AuthenticationFilter initialized");
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse res = (HttpServletResponse) response;
//
//        String uri = req.getRequestURI();
//        this.context.log("Requested Resource::"+uri);
//
//        HttpSession session = req.getSession(false);
//
//        if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet"))){
//            this.context.log("Unauthorized access request");
//            res.sendRedirect("login.html");
//        }else{
//            // pass the request along the filter chain
//            chain.doFilter(request, response);
//        }
//
//
//    }
//
//    public void destroy() {
//        //close any resources here
//    }
//
//}
