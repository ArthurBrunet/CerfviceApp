package com.onlinebank.Servlet;

import com.onlinebank.Models.Produit;
import com.onlinebank.Models.ProspectProduit;
import com.onlinebank.Utils.Algo;
import com.onlinebank.Utils.Database;
import com.onlinebank.Utils.Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAccueil")
public class ServletAccueil extends HttpServlet {


    private static String url = "/vues/accueil.jsp";


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
            //get l'id du prospect
            int idprospect= (int) session.getAttribute("idprospect");
            //Tableau Global
            ArrayList<ArrayList<String>> tableauGlobal = new ArrayList<>();


            /* Recuperation de la liste des produits pour attribué à l'id de ce prospect*/
            ProspectProduit jointure = new ProspectProduit();
            ArrayList<String> fields = new ArrayList<>();
            fields.add("*");
            ArrayList tableau = new ArrayList();
            tableau.add(Filter.add("=","id_prospect",idprospect));
            List<ProspectProduit> listprospectproduit = Database.select(jointure,fields,tableau);
            ArrayList<String> arrayAlgo;
            arrayAlgo = Algo.algo(idprospect);

            /*Pour chaque produit de la personne :*/
            for (ProspectProduit c:listprospectproduit) {
                /*Récupération des champs dans la base de donnée */
                int idproduit = c.getId_produit();
                Produit produit = new Produit();
                ArrayList filter = new ArrayList();
                filter.add(Filter.add("=","id",idproduit));
                List<Produit> listProduit = Database.select(produit,fields,filter);
                ArrayList<String> tableauInformations = new ArrayList<>();
                for (Produit d: listProduit)
                {
                    /*Création d'un tableau d'information à injecter dans le tableau global*/
                    tableauInformations.add(d.getNom());
                    tableauInformations.add(d.getDescription());
                    for (int i = 0; i < arrayAlgo.size(); i++) {
                        if (arrayAlgo.get(i) == d.getNom())
                        {
                            arrayAlgo.remove(i);

                        }
                    }

                }
                tableauGlobal.add(0,tableauInformations);
            }
            /*DEBUG CONSOLE affichage du tableau global*/
            for (ArrayList p:tableauGlobal){
                for (int i=0;i<p.size();i++){
                    System.out.println("["+tableauGlobal.indexOf(p)+"]"+"["+p.indexOf(p.get(i))+"] ="+ p.get(i));
                }
            }
            request.setAttribute("TableauGlobal",tableauGlobal);
            request.setAttribute("arrayalgo",arrayAlgo);
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }

}
