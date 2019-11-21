package com.onlinebank.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletContact")
public class ServletContact extends HttpServlet {


    private static String url = "/vues/contact.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {

            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }

}
