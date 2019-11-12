package com.onlinebank.Servlet;

import com.onlinebank.Models.Compte;
import com.onlinebank.Utils.Database;
import com.onlinebank.Utils.Filter;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletLogin")
public class ServletLogin extends HttpServlet {


    private static String url = "/vues/login.jsp";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String CHAMP_EMAIL = request.getParameter("email");
        String CHAMP_PASS = request.getParameter("motdepasse");

        ArrayList<String> errors = new ArrayList<String>();
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("*");


        ArrayList filter = new ArrayList();




        if (!CHAMP_EMAIL.isEmpty()) {

            filter.add(Filter.add("=","email","'"+CHAMP_EMAIL+"'"));
            Compte User = new Compte();
            List<Compte> i = Database.select(User,fields,filter);

            if (!i.isEmpty()){
                for (Compte result: i){
                    if (result.getEmail() != null){
                        String mdp = result.getMotdepasse();
                        if (BCrypt.checkpw(CHAMP_PASS,mdp)){

                            String email = result.getEmail();
                            HttpSession session = request.getSession();

                            session.setAttribute("email", email);

                        }else{
                            errors.add("Email ou Mot de passe incorrect");
                        }
                    }
                }
            }else{
                errors.add("Email ou Mot de passe incorrect");
            }

        }else {
            errors.add("Veuillez renseignez un email");
            System.out.println("Veuillez renseignez un email");
        }

        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher(url).forward(request, response);

    }
}
