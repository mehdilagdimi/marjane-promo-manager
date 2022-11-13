package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.controller.BeanController;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.EmailService.EmailHelper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ManagerServletTest extends HttpServlet {


    @Test
    void testInsertManager() {
        Manager manager;
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ServletConfig servletConfig = mock(ServletConfig.class);
        ServletContext servletContext = mock(ServletContext.class);

        ManagerServlet managerServlet =  new ManagerServlet();

        when(request.getParameter("center_id")).thenReturn("5");
        when(request.getAttribute("center_id")).thenReturn("5");
        when(request.getParameter("fullname")).thenReturn("testingManager");
        when(request.getAttribute("fullname")).thenReturn("testingManager");
        when(request.getParameter("email")).thenReturn("testing.manager@gmail.com");
        when(request.getAttribute("email")).thenReturn("testing.manager@gmail.com");
        when(request.getAttribute("passw")).thenReturn(EmailHelper.codeGenerator());
        Center center = BeanController.find(5, Center.class);
        when(request.getAttribute("center")).thenReturn(center);
//        Center center = BeanController.find(5, Center.class);
//        when(request.getAttribute("center")).thenReturn(center);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getInitParameter("url")).thenReturn("http://localhost:8080/marjane_franchise_promotion_manager_war_exploded/");
        try{

            managerServlet.init(servletConfig);
            managerServlet.doPost(request, response);
        } catch (ServletException | IOException e){
            e.printStackTrace();
        }
        manager = managerServlet.managerController.getManagerObj();
        assertEquals("testing.manager@gmail.com", manager.getEmail());
        assertEquals("testingManager", manager.getFullname());
        assertEquals(5, manager.getCenter().getId());

    }

}