package com.onlinebank.Servlet;

import com.onlinebank.Models.Produit;
import com.onlinebank.Models.Prospect;
import com.onlinebank.Models.ProspectProduit;
import com.onlinebank.Utils.Database;
import com.onlinebank.Utils.Filter;
import com.onlinebank.Utils.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            /*Requête pour selectionné toute les produits en bdd*/
            Produit produitenbdd = new Produit();
            ArrayList<String> fields = new ArrayList<>();
            fields.add("*");
            List<Produit> listProduitEnBDD =  Database.select(produitenbdd,fields);

            /*Tableau de nom de produit à injecter dans la request*/
            ArrayList<String> nomProduit = new ArrayList<>();

            /*Requête pour selectionné tout les produit qu'un prospect a déjà*/
            ProspectProduit jointure = new ProspectProduit();
            ArrayList filtre = new ArrayList();
            filtre.add(Filter.add("=","id_prospect", idprospect));
            List<ProspectProduit> listProspectProduit = Database.select(jointure,fields,filtre);

            /*Pour chaque produit en BDD*/
            for (Produit produitbdd: listProduitEnBDD){
                if (!listProspectProduit.isEmpty()){
                    System.out.println("Le client a des produits");
                    for (ProspectProduit jointureproduitclient: listProspectProduit){
                        /*Récupération de l'id de ce produit*/
                        int idproduit = jointureproduitclient.getId_produit();

                        /*Recherche dans la table produit le nom du contrat pour ce produit*/
                        Produit produitclient = new Produit();
                        ArrayList filtre2 = new ArrayList();
                        filtre2.add(Filter.add("=","id",idproduit));
                        List<Produit> produitduclient = Database.select(produitclient,fields,filtre2);

                        for (Produit produititem: produitduclient){
                            if (!produititem.getId().equals(produitbdd.getId())){
                                /*A FAIRE : insertion de l'algo d'Ahmed ici*/
                                nomProduit.add(produititem.getNom());
                            }
                        }
                    }
                } else {
                    System.out.println("Le prospect n'a aucun produit");
                    nomProduit.add(produitbdd.getNom());
                }
            }

            /*Ajout du tableau de nom de produit dans la request*/
            request.setAttribute("TableauProduit",nomProduit);
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (session.getAttribute("role").equals("user")){
            response.sendRedirect(request.getContextPath()+"/accueil");
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }
}
