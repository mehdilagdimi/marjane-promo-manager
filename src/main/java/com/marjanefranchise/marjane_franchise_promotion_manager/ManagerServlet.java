package com.marjanefranchise.marjane_franchise_promotion_manager;

import com.marjanefranchise.marjane_franchise_promotion_manager.base.BeanSetterFI;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.BeanController;
import com.marjanefranchise.marjane_franchise_promotion_manager.controller.ManagerController;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.SectionManager;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ManagerServlet", value = "/ManagerServlet")
public class ManagerServlet extends HttpServlet {
    private ManagerController managerController;
    String baseURL;
    @Override
    public void init() throws ServletException {
        baseURL = getServletContext().getInitParameter("url");
        managerController = new ManagerController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" inside manager serv");
//        doPost(request,response);
        if(request.getParameter("get") != null) {
            List<Manager> managerList = null;
            if (request.getSession().getAttribute("role") == "superadmin") {
                if (request.getParameter("get").equals("all")) {
                    managerList = managerController.getAll();
                    request.getSession().setAttribute(
                            "markets",
                            BeanController.getAll(Center.class).stream().filter(center -> center.getManager() == null).collect(Collectors.toList())
                    );
                }
            }

            request.getSession().setAttribute("records", managerList);
            request.getSession().setAttribute("recordstype", "manager");
            request.getRequestDispatcher("pages/dashboard.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("center_id", request.getParameter("center_id"));
        request.setAttribute("fullname", request.getParameter("fullname"));
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("center", null);

        request.setAttribute("passw", "1234");
        managerController.addManager(request, "center_id","fullname", "email", "passw", "center");
        managerController.sendEmail(request.getParameter("email"));

        response.sendRedirect(baseURL + "ManagerServlet?get=all");
    }
}
