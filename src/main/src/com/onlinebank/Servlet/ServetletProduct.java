package com.onlinebank.Servlet;

import com.onlinebank.Models.Produit;
import com.onlinebank.Utils.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

@WebServlet(name = "ServetletProduct")
public class ServetletProduct extends HttpServlet {

    private static String url = "/vues/ajoutproduit.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("role").equals("conseiller") || session.getAttribute("role").equals("admin")) {
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            String minage = request.getParameter("minage");
            String maxage = request.getParameter("maxage");
            String siuationpro = request.getParameter("situationpro");
            String revenumin = request.getParameter("revenumin");
            String revenumax = request.getParameter("revenumax");

            int minageParse = Integer.parseInt(minage);
            int maxageParse = Integer.parseInt(maxage);
            int revenuminParse = Integer.parseInt(revenumin);
            int revenumaxParse = Integer.parseInt(revenumax);

            Produit produit = new Produit();
            Timestamp date=  new Timestamp(System.currentTimeMillis());

            /*Creation d'un Produit*/
            produit
                    .setNom(nom)
                    .setDescription(description)
                    .setMinage(minageParse)
                    .setMaxage(maxageParse)
                    .setSituationprofessionnel(siuationpro)
                    .setRevenumin(revenuminParse)
                    .setRevenumax(revenumaxParse)
                    .setCreated_at(date)
                    .setUpdated_at(date);
            Database.insert(produit);

            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (session.getAttribute("role").equals("user")){
            response.sendRedirect(request.getContextPath()+"/accueil");
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("role").equals("conseiller") || session.getAttribute("role").equals("admin")) {
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (session.getAttribute("role").equals("user")){
            response.sendRedirect(request.getContextPath()+"/accueil");
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }
}
