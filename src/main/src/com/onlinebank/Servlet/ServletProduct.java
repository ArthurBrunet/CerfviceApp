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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletProduct")
public class ServletProduct extends HttpServlet {

    private static String url = "/vues/product.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Produit produit = new Produit();
        Timestamp date=  new Timestamp(System.currentTimeMillis());
//        if (session.getAttribute("role").equals("conseiller") || session.getAttribute("role").equals("admin")) {
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            String minage = request.getParameter("minage");
            String maxage = request.getParameter("maxage");
            String siuationpro = request.getParameter("situationpro");
            String revenumin = request.getParameter("revenumin");
            String revenumax = request.getParameter("revenumax");

        /*Creation d'un Produit*/
        produit
                .setNom(nom)
                .setDescription(description)
                .setCreated_at(Timestamp.valueOf(LocalDateTime.now()))
                .setUpdated_at(Timestamp.valueOf(LocalDateTime.now()))
                .setSituationprofessionnel(siuationpro);

            if (!minage.isEmpty()){
                int minageParse = Integer.parseInt(minage);
                produit.setMinage(minageParse);
            }else {
                produit.setMinage(null);
            }

            if (!maxage.isEmpty()){
                int maxageParse = Integer.parseInt(maxage);
                produit.setMaxage(maxageParse);
            }else {
                produit.setMaxage(null);
            }

            if (!revenumin.isEmpty()) {
                int revenuminParse = Integer.parseInt(revenumin);
                produit.setRevenumin(revenuminParse);
            }else {
                produit.setRevenumin(null);
            }

            if (!revenumax.isEmpty()){
                int revenumaxParse = Integer.parseInt(revenumax);
                produit.setRevenumax(revenumaxParse);
            }else {
                produit.setRevenumax(null);
            }

            Database.insert(produit);

            this.getServletContext().getRequestDispatcher(url).forward(request, response);
//        }else if (session.getAttribute("role").equals("user")){
//            response.sendRedirect(request.getContextPath()+"/accueil");
//        }else{
//            response.sendRedirect(request.getContextPath()+"/login");
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> fields = new ArrayList<>();
        fields.add("*");
        Produit produitss = new Produit();
        List<Produit> listproduits = Database.select(produitss,fields);
        System.out.println(listproduits);
        HttpSession session = request.getSession();

//        if (session.getAttribute("role").equals("conseiller") || session.getAttribute("role").equals("admin")) {
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
//        }else if (session.getAttribute("role").equals("user")){
//            response.sendRedirect(request.getContextPath()+"/accueil");
//        }else{
//            response.sendRedirect(request.getContextPath()+"/login");
//        }
    }
}
