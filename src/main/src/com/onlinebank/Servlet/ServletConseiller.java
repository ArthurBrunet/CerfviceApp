package com.onlinebank.Servlet;

import com.onlinebank.Models.Produit;
import com.onlinebank.Models.Prospect;
import com.onlinebank.Models.Compte;
import com.onlinebank.Models.ProspectProduit;
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

@WebServlet(name = "ServletConseiller")
public class ServletConseiller extends HttpServlet {


    private static String url = "/vues/conseiller.jsp";

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
            ArrayList<String> field = new ArrayList<String>();
            ArrayList filtres = new ArrayList();
            Prospect prospect = new Prospect();
            field.add("*");
            filtres.add(Filter.add("=","bloquepub",false));
            List<Prospect> i = Database.select(prospect,field,filtres);

            request.setAttribute("user",i);


            for (Prospect resultProspect: i)
            {
                String index = resultProspect.getId().toString();
                ArrayList<String> field2 = new ArrayList<String>();
                ArrayList filtres2 = new ArrayList();
                Compte user = new Compte();
                field2.add("email");
                filtres2.add(Filter.add("=","id_prospect",resultProspect.getId()));
                List<Compte> c = Database.select(user,field2,filtres2);


                for (Compte resultCompte: c)
                {
                    request.setAttribute(index + "email",resultCompte.getEmail());
                }


                ProspectProduit jointure = new ProspectProduit();
                ArrayList<String> fields = new ArrayList<>();
                fields.add("*");
                ArrayList tableau = new ArrayList();
                tableau.add(Filter.add("=","id_prospect",resultProspect.getId()));
                List<ProspectProduit> listprospectproduit = Database.select(jointure,fields,tableau);


                for (ProspectProduit pp :listprospectproduit) {
                    int idproduit = pp.getId_produit();
                    Produit produit = new Produit();
                    ArrayList filter4 = new ArrayList();
                    filter4.add(Filter.add("=","id",idproduit));
                    List<Produit> listProduit = Database.select(produit,fields,filter4);
                    int count = 0;
                    for (Produit d: listProduit)
                    {

                        request.setAttribute(index + "produit" + count,d.getNom());
                        count++;
                    }
                }
            }


            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }else if (session.getAttribute("role").equals("user")){
            response.sendRedirect(request.getContextPath()+"/accueil");
        }else{
            response.sendRedirect(request.getContextPath()+"/login");
        }
    }
}
