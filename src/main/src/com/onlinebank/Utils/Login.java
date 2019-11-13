package com.onlinebank.Utils;

import com.onlinebank.Models.Compte;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Login {

    public ArrayList loginApp(HttpServletRequest request, String CHAMP_EMAIL, String CHAMP_PASS){


        ArrayList<String> errors = new ArrayList<String>();
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("*");


        ArrayList filter = new ArrayList();




        if (!CHAMP_EMAIL.isEmpty() && !CHAMP_PASS.isEmpty()) {

            filter.add(Filter.add("=","email","'"+CHAMP_EMAIL+"'"));
            Compte User = new Compte();
            List<Compte> i = Database.select(User,fields,filter);

            if (!i.isEmpty()){
                for (Compte result: i){
                    if (result.getEmail() != null){
                        String mdp = result.getMotdepasse();
                        if (BCrypt.checkpw(CHAMP_PASS,mdp)){

                            String email = result.getEmail();
                            String role = result.getRole();
                            HttpSession session = request.getSession();

//                          AJOUT ATTRIBUT DANS LA SESSION
                            session.setAttribute("email", email);
                            session.setAttribute("role",role);

                            errors.add(role);

                        }else{
                            errors.add("Email ou Mot de passe incorrect");
                        }
                    }
                }
            }else{
                errors.add("Email ou Mot de passe incorrect");
            }

        }else {
            errors.add("Veuillez remplire les champs ");
        }



        if (errors.get(0).equals("admin"))
        {
            errors.add("/dashboard");

        }
        if (errors.get(0).equals("Conseiller")){

            errors.add("/dashboard");

        }
        if (errors.get(0).equals("user")){

            errors.add("/accueil");
        }


        return errors;
    }
}
