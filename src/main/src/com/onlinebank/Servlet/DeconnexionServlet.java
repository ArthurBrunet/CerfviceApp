package com.onlinebank.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeconnexionServlet")
public class DeconnexionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();

        /* Redirection vers le Site du Zéro ! */
        response.sendRedirect( request.getContextPath()+"/" );
    }
}
