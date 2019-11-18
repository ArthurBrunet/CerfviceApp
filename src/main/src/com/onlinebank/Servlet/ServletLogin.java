package com.onlinebank.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import com.onlinebank.Utils.Login;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {


    private static String url = "/vues/login.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String CHAMP_EMAIL = request.getParameter("email");
        String CHAMP_PASS = request.getParameter("motdepasse");
        Login log = new Login();
        ArrayList error = log.loginApp(request,CHAMP_EMAIL,CHAMP_PASS);
        if (error.get(0).equals("user") ||error.get(0).equals("admin") ||error.get(0).equals("conseiller") )
        {
            System.out.println(error.get(0));
            response.sendRedirect(request.getContextPath()+(String)error.get(1));
        }else{
            request.setAttribute("error",error);
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        this.getServletContext().getRequestDispatcher(url).forward(request, response);



    }
}
