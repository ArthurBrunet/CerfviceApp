package com.onlinebank.Servlet;

import com.onlinebank.Models.Compte;
import com.onlinebank.Utils.Database;
import com.onlinebank.Utils.Filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {


    private static String url = "/vues/login.jsp";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "motdepasse";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<String> errors = new ArrayList<String>();
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("*");

        ArrayList filter = new ArrayList();




        if (CHAMP_EMAIL != null) {

            filter.add(Filter.add("=","email",CHAMP_EMAIL));
            Compte User = new Compte();
            List<Compte> i = Database.select(User,fields,filter);


            for (Compte result: i){
                if (result.getEmail() != null){
                    if (CHAMP_PASS == result.getMotdepasse()){
                        String email = request.getParameter("email");
                        HttpSession session = request.getSession();

                        session.setAttribute(result.getEmail(), email);

                    }else{
                        errors.add("Email ou Mot de passe incorrect");
                    }
                }else{
                    errors.add("Email ou Mot de passe incorrect");
                }
            }
        }else {
            errors.add("Veuillez renseignez un email");
        }

        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher(url).forward(request, response);

    }
}
