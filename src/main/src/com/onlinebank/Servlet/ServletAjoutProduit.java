package com.onlinebank.Servlet;

import com.onlinebank.Models.Produit;
import com.onlinebank.Models.ProspectProduit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletAjoutProduit")
public class ServletAjoutProduit extends HttpServlet{
    private static String url = "/vues/ajoutConseiller.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role").equals("conseiller")) {

            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (session.getAttribute("role").equals("user")){
            response.sendRedirect(request.getContextPath()+"/accueil");
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role").equals("conseiller")) {
            /*Récupération de l'id du prospect*/
            int idprospect = Integer.parseInt(request.getParameter("id"));
            /* Requête afin de savoir quel contrat a ce prospect */
            ProspectProduit jointure = new ProspectProduit();
            ArrayList<String> fields = new ArrayList<>();
            fields.add("*");



            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (session.getAttribute("role").equals("user")){
            response.sendRedirect(request.getContextPath()+"/accueil");
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }
}
