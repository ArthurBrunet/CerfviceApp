package com.onlinebank.Servlet;

import com.onlinebank.Models.Compte;
import com.onlinebank.Models.Prospect;
import com.onlinebank.Utils.Database;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.onlinebank.Utils.Verification;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "ServletRegister")
public class ServletRegister extends HttpServlet {
    private static final String VUE = "/vues/register.jsp";

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
        String livretjeune= request.getParameter("verifLj");
        String CompteCourant= request.getParameter("verifCcp");
        String livretA= request.getParameter("verifLa");
        String pel= request.getParameter("verifPel");
        String assuranceVie= request.getParameter("verifAv");
        String creditetudiant= request.getParameter("verifCe");
        String creditconsommation= request.getParameter("verifCc");
        String creditimmobilier= request.getParameter("verifCi");
        String creditautomobile= request.getParameter("verifCa");

        String ATT_ERREURS = "erreurs";
        String ATT_RESULTAT = "resultat";


        String valider = request.getParameter("valider");
        Boolean testNotif = true;

        int revenuParse;
        revenuParse = Integer.parseInt(revenu);
        int depenseReguliereParse;
        depenseReguliereParse = Integer.parseInt(depensereguliere);
        int enfantParse;
        enfantParse = Integer.parseInt(enfants);
        boolean validerParse;
        validerParse = Boolean.parseBoolean(valider);
        int ancienneteLogementParse;
        ancienneteLogementParse = Integer.parseInt(anciennetelogement);
        Integer ancienneteProParse;
        ancienneteProParse = Integer.parseInt(anciennete);

        String resultat;
        Map<String, String> erreurs = new HashMap<String, String>();

        /*Verification des champs de formulaire*/
        Verification verification = new Verification();

        //Vérification mail
        try {
            verification.validationEmail(email);
        } catch (Exception e) {
            erreurs.put( email, e.getMessage() );
        }

        //Verification mdp
        try{
            verification.validationMotsDePasse(password,confirm_password);
        } catch (Exception e) {
            erreurs.put(password, e.getMessage());
        }

        // Vérification Nom
        try{
            verification.validationNom(name);
        } catch (Exception e){
            erreurs.put(name, e.getMessage());
        }

        // Vérification Prénom
        try{
            verification.validationPrenom(firstname);
        } catch (Exception e){
            erreurs.put(firstname, e.getMessage());
        }

        // Vérification Telephone
        try{
            verification.validationtel(telephone);
        } catch (Exception e){
            erreurs.put(telephone, e.getMessage());
        }

        //Verification situation
        try {
            verification.validationsituation(situation);
        } catch (Exception e){
            erreurs.put(situation, e.getMessage());
        }
        //Champs enfants
        try {
            verification.validationEnfant(enfantParse);
        } catch (Exception e){
            erreurs.put(enfants, e.getMessage());
        }

        //Champs situation pro
        try{
            verification.validationsituationpro(situationpro);
        } catch (Exception e){
            erreurs.put(situationpro, e.getMessage());
        }

        //Champs type habitat
        try{
            verification.validationTypeHabitat(typehabitat);
        } catch (Exception e){
            erreurs.put(typehabitat, e.getMessage());
        }

        //Champs situation Logement
        try{
            verification.validationSituationLogement(situationlogement);
        } catch (Exception e){
            erreurs.put(situationlogement, e.getMessage());
        }

        //Champ anciennete logement
        try{
            verification.validationAnciennetelogement(ancienneteLogementParse);
        } catch (Exception e){
            erreurs.put(anciennetelogement, e.getMessage());
        }

        boolean boolLivretJeune = verification.transformStringtoBool(livretjeune);
        boolean boolCompteCourant = verification.transformStringtoBool(CompteCourant);
        boolean boolLivretA = verification.transformStringtoBool(livretA);
        boolean boolPel = verification.transformStringtoBool(pel);
        boolean boolAssuranceVie = verification.transformStringtoBool(assuranceVie);
        boolean boolCreditetudiant = verification.transformStringtoBool(creditetudiant);
        boolean boolCreditConsommation = verification.transformStringtoBool(creditconsommation);
        boolean boolcreditImmobilier = verification.transformStringtoBool(creditimmobilier);
        boolean boolCreditAutomobile = verification.transformStringtoBool(creditautomobile);

        System.out.println(erreurs);
        if (erreurs.isEmpty()){
            resultat="Succès de l'inscriptions";
        /*Création de l'objet à envoyé en BDD*/
            Prospect user = new Prospect();
            Compte Compte = new Compte();


            Timestamp date = new Timestamp(System.currentTimeMillis());
            /*Création d'un Prospect*/
            user
                .setNom(name)
                .setPrenom(firstname)
                .setAge(age)
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
                .setUpdated_at(null)
                .setVerifLj(boolLivretJeune)
                .setVerifCcp(boolCompteCourant)
                .setVerifLa(boolLivretA)
                .setVerifPel(boolPel)
                .setVerifAv(boolAssuranceVie)
                .setVerifCe(boolCreditetudiant)
                .setVerifCc(boolCreditConsommation)
                .setVerifCi(boolcreditImmobilier)
                .setVerifCa(boolCreditAutomobile);

            /*Envois en BDD*/
            Integer id = Database.insert(user);

            String pw_hash = BCrypt.hashpw(password,BCrypt.gensalt());
            /*Création d'un compte*/
            Compte
                    .setEmail(email)
                    .setMotdepasse(pw_hash)
                    .setToken(generateRandomString())
                    .setId_prospect(id)
                    .setCreated_at(date)
                    .setRole("user");
            Database.insert(Compte);
        }else {
            resultat = "Echec de l'inscription.";
        }
        request.setAttribute(ATT_ERREURS, erreurs);
        request.setAttribute(ATT_RESULTAT, resultat);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VUE).forward(request,response);
    }

    private String generateRandomString(){
        String foo = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] charArray = foo.toCharArray();
        int $length = 255;
        String randomString = "";
        int $i;
        Random r = new Random();
        for ($i = 0; $i < $length; $i++) {
            int n = r.nextInt(52);
            randomString += charArray[n];
        }
        return randomString;
    }
}
