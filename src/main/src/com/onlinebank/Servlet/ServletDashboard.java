package com.onlinebank.Servlet;

import com.onlinebank.Models.Prospect;
import com.onlinebank.Utils.Database;
import com.onlinebank.Utils.Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletDashboard")
public class ServletDashboard extends HttpServlet {


    private static String url = "/vues/dashboard.jsp";



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("role").equals("admin")) {
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (session.getAttribute("role").equals("user")){
            response.sendRedirect(request.getContextPath()+"/accueil");
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("role").equals("admin")) {


            ArrayList<String> fields = new ArrayList<String>();
            ArrayList filters = new ArrayList();
            fields.add("*");
            filters.add(Filter.add("=","active","true"));
            Prospect User = new Prospect();
            List<Prospect> i = Database.select(User,fields,filters);

            request.setAttribute("user",i);



            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (session.getAttribute("role").equals("user")){
            response.sendRedirect(request.getContextPath()+"/accueil");
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }
}
