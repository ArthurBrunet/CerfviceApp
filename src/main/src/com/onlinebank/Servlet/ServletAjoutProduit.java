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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAjoutProduit")
public class ServletAjoutProduit extends HttpServlet{
    private static String url = "/vues/ajoutConseiller.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role").equals("conseiller")) {
            /*Récupération du produit à injecter au client*/
            String produit = request.getParameter("nomproduitajouter");
            System.out.println("DEBUG TEST PARSEINT");
            System.out.println("ID PROSPECT : "+request.getParameter("idprospect"));
            int idprospect = Integer.parseInt(request.getParameter("idprospect"));

            ProspectProduit jointure = new ProspectProduit();
            Timestamp date = new Timestamp(System.currentTimeMillis());

            Produit produitenbdd = new Produit();
            ArrayList<String> fields = new ArrayList<>();
            fields.add("*");
            ArrayList filtre3 = new ArrayList();
            filtre3.add(Filter.add("=","nom","'"+produit+"'"));
            List<Produit> nomProduit = Database.select(produitenbdd, fields, filtre3);

            for (Produit nomproduit: nomProduit){
                jointure
                        .setId_produit(nomproduit.getId())
                        .setCreated_at(date)
                        .setUpdated_at(date)
                        .setId_prospect(idprospect);

                Database.insert(jointure);
            }
            response.sendRedirect(request.getContextPath()+"/dashboardconseiller");
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
            if (!(request.getParameter("id") == null)) {
                int idprospect = Integer.parseInt(request.getParameter("id"));


                /*Requête pour selectionné toute les produits en bdd*/
                Produit produitenbdd = new Produit();
                ArrayList<String> fields = new ArrayList<>();
                fields.add("*");
                List<Produit> listProduitEnBDD = Database.select(produitenbdd, fields);

                /*Tableau de nom de produit à injecter dans la request*/
                ArrayList<String> nomProduit = new ArrayList<>();

                /*Requête pour selectionné tout les produit qu'un prospect a déjà*/
                ProspectProduit jointure = new ProspectProduit();
                ArrayList filtre = new ArrayList();
                filtre.add(Filter.add("=", "id_prospect", idprospect));
                List<ProspectProduit> listProspectProduit = Database.select(jointure, fields, filtre);

                /*Pour chaque produit en BDD*/
                for (Produit produitbdd : listProduitEnBDD) {
                    if (!listProspectProduit.isEmpty()) {
                        for (ProspectProduit jointureproduitclient : listProspectProduit) {
                            System.out.println("Le client à le produit: " + jointureproduitclient.getId_produit());
                            /*Récupération de l'id de ce produit*/
                            int idproduit = jointureproduitclient.getId_produit();

                            /*Recherche dans la table produit le nom du contrat pour ce produit*/
                            Produit produitclient = new Produit();
                            ArrayList filtre2 = new ArrayList();
                            filtre2.add(Filter.add("=", "id", idproduit));
                            List<Produit> produitduclient = Database.select(produitclient, fields, filtre2);

                            for (Produit produititem : produitduclient) {
                                System.out.println("PRODUIT ITEM : " + produititem.getId());
                                System.out.println("PRODUIT BDD : " + produitenbdd.getId());
                                if (produititem.getId() == produitbdd.getId()) {
                                    System.out.println("LES PRODUITS SONT LES MÊMES");
                                }else {
                                    System.out.println("LES PRODUITS NE SONT PAS LES MÊMES");
                                    /*A FAIRE : insertion de l'algo d'Ahmed ici*/
                                    System.out.println("AJOUT DE NOM DU PRODUIT" + produitbdd.getNom());
                                    nomProduit.add(produitbdd.getNom());
                                }
                            }
                        }
                    } else {
                        System.out.println("Le prospect n'a aucun produit");
                        nomProduit.add(produitbdd.getNom());
                    }
                    System.out.println("DEBUG GENERAL PRODUIT BDD ID :"+produitbdd.getId());
                }

                /*Ajout du tableau de nom de produit dans la request*/
                request.setAttribute("TableauProduit", nomProduit);
                /*Ajout de l'id du prospect dans la request*/
                request.setAttribute("idprospect",idprospect);
                this.getServletContext().getRequestDispatcher(url).forward(request, response);
            } else if (session.getAttribute("role").equals("user")) {
                response.sendRedirect(request.getContextPath() + "/accueil");
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }
    }
}
