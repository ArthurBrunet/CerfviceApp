package com.onlinebank.Servlet;

import com.onlinebank.Models.Compte;
import com.onlinebank.Models.Prospect;
import com.onlinebank.Utils.Database;
import com.onlinebank.Utils.Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletUpdateConseiller")
public class ServletUpdateConseiller extends HttpServlet{
    private static String url = "/vues/updateProfilConseiller.jsp";

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
            filtres.add(Filter.add("=","id",request.getParameter("id")));
            List<Prospect> i = Database.select(prospect,field,filtres);

            request.setAttribute("user",i);
            for (Prospect resultProspect: i) {
                ArrayList<String> field2 = new ArrayList<String>();
                ArrayList filtres2 = new ArrayList();
                Compte user = new Compte();
                field2.add("email");
                filtres2.add(Filter.add("=", "id_prospect", resultProspect.getId()));
                List<Compte> c = Database.select(user, field2, filtres2);
                for (Compte resultCompte : c) {
                    request.setAttribute("email", resultCompte.getEmail());
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
