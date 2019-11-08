package com.onlinebank.Servlet;

import com.onlinebank.Models.Compte;
import com.onlinebank.Models.Prospect;
import com.onlinebank.Utils.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.onlinebank.Utils.Verification;

@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {
    private static final String VUE = "vues/register.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Récupération des champs du formulaire. */
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String name = request.getParameter("name");
        String firstname = request.getParameter("firstname");
        String telephone = request.getParameter("telephone");
        String age = request.getParameter("age");
        String situation = request.getParameter("situation");
        String enfants = request.getParameter("enfants");
        String situationpro = request.getParameter("situationpro");
        String revenu = request.getParameter("revenu");
        String anciennete = request.getParameter("anciennete");
        String depensereguliere = request.getParameter("depensereguliere");
        String departement = request.getParameter("departement");
        String typehabitat = request.getParameter("typehabitat");
        String situationlogement = request.getParameter("situationlogement");
        String anciennetelogement = request.getParameter("anciennetelogement");
//        String manipdonnees = request.getParameter("manipdonnees");
        String notification = request.getParameter("notification");
        String valider = request.getParameter("valider");


        Boolean testNotif = true;
        /*Transtypage String To Int*/
        int ageParse;
        ageParse = Integer.parseInt(age);
        int revenuParse;
        revenuParse = Integer.parseInt(revenu);
        int depenseReguliereParse;
        depenseReguliereParse = Integer.parseInt(depensereguliere);
        int enfantParse;
        enfantParse = Integer.parseInt(enfants);
        boolean notificationParse;
        notificationParse =Boolean.parseBoolean(notification);
        boolean validerParse;
        validerParse = Boolean.parseBoolean(valider);
        Integer ancienneteLogementParse;
        ancienneteLogementParse = Integer.parseInt(anciennetelogement);
        Integer ancienneteProParse;
        ancienneteProParse = Integer.parseInt(anciennete);

        /*Création de l'objet à envoyé en BDD*/
        Prospect test = new Prospect();
        Compte testCompte = new Compte();

        System.out.println("coucou");
        if (!validerParse){
            System.out.println("debug");
            System.out.println("Debug Anciennete logement" + ancienneteLogementParse);

            Timestamp date = new Timestamp(System.currentTimeMillis());
            /*Création d'un Prospect*/
            test
                .setNom(name)
                .setPrenom(firstname)
                .setAge(ageParse)
                .setSituationfamiliale(situation)
                .setRevenu(revenuParse)
                .setDepensereguliere(depenseReguliereParse)
                .setSituationprofessionnel(situationpro)
                .setTelephone(telephone)
                .setEnfants(enfantParse)
                .setDepartement(departement)
                .setTypehabitat(typehabitat)
                .setSituationlogement(situationlogement)
                .setAnciennetelogement(ancienneteLogementParse)
                .setAncienneteprofessionnel(ancienneteProParse)
                .setBloquepub(false)
                .setActive(true)
                .setCreated_at(date)
                .setUpdated_at(null);

            /*Envois en BDD*/
            Database.insert(test);
//
//            /*Création d'un compte*/
            testCompte
                    .setEmail(email);
        }

        request.getRequestDispatcher(VUE).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VUE).forward(request,response);
    }

//    /**
//     * Valide l'adresse mail saisie.
//     */
//    private void validationEmail( String email ) throws Exception {
//        if ( email != null && email.trim().length() != 0 ) {
//            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
//                throw new Exception( "Merci de saisir une adresse mail valide." );
//            }
//        } else {
//            throw new Exception( "Merci de saisir une adresse mail." );
//        }
//    }
//
//    /**
//     * Valide les mots de passe saisis.
//     */
//    private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
//        if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
//            if (!motDePasse.equals(confirmation)) {
//                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
//            } else if (motDePasse.trim().length() < 3) {
//                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
//            }
//        } else {
//            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
//        }
//    }
//
//    /**
//     * Valide le nom d'utilisateur saisi.
//     */
//    private void validationNom( String nom ) throws Exception {
//        if ( nom != null && nom.trim().length() < 3 ) {
//            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
//        }
//    }
//
//    /**
//     * Valide le prenom d'utilisateur saisi.
//     */
//    private void validationPrenom( String prenom) throws Exception {
//        if ( prenom != null && prenom.trim().length() < 3 ) {
//            throw new Exception("Le prenom de l'utilisateur doit contenir au moins 3 caractères");
//        }
//    }
//
//    /*Validation qu'il s'agit bien d'un numero de telephone*/
//    private void validationtel(String telephone) throws Exception {
//        if(!telephone.matches("(\\+[0-9][0-9][0-9]( [0-9][0-9])+)|([0-9]+)")){
//            throw new Exception("Merci de saisir un telephone valide.");
//        }
//    }
//
//    /*Validation d'un champs vide ou non*/
//    private void validationVide(String champs) throws Exception{
//        if ( champs != null){
//            throw new Exception("Le champs est vide");
//        }
//    }
//
//    private void validationsituation(String situation) throws Exception {
//    }
}
