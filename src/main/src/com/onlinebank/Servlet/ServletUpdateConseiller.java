package com.onlinebank.Servlet;

import com.onlinebank.Models.Compte;
import com.onlinebank.Models.Prospect;
import com.onlinebank.Utils.Database;
import com.onlinebank.Utils.Filter;
import com.onlinebank.Utils.Verification;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletUpdateConseiller")
public class ServletUpdateConseiller extends HttpServlet{
    private static String url = "/vues/updateProfilConseiller.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role").equals("conseiller") || session.getAttribute("role").equals("admin")) {

            int id = Integer.parseInt(request.getParameter("id"));
            ArrayList<String> field = new ArrayList<String>();
            ArrayList filtres = new ArrayList();
            Prospect prospect = new Prospect();
            field.add("*");
            filtres.add(Filter.add("=","id",id));
            List<Prospect> i = Database.select(prospect,field,filtres);

            request.setAttribute("user",i);
            for (Prospect resultProspect: i) {
                ArrayList<String> field2 = new ArrayList<String>();
                ArrayList filtres2 = new ArrayList();
                Compte compte = new Compte();
                field2.add("*");
                filtres2.add(Filter.add("=", "id_prospect", resultProspect.getId()));
                List<Compte> c = Database.select(compte, field2, filtres2);

                /* Récupération des champs du formulaire. */
                String email = request.getParameter("email");
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
                            .setCreated_at(resultProspect.getCreated_at())
                            .setUpdated_at(Timestamp.valueOf(LocalDateTime.now()))
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
                    Database.updateId(user,resultProspect.getId());
                    for (Compte resultCompte : c) {


                    /*Création d'un compte*/
                    Compte
                            .setEmail(email)
                            .setId_prospect(resultProspect.getId())
                            .setMotdepasse(resultCompte.getMotdepasse())
                            .setToken(resultCompte.getToken())
                            .setCreated_at(resultCompte.getCreated_at())
                            .setUpdated_at(Timestamp.valueOf(LocalDateTime.now()))
                            .setRole(resultCompte.getRole());
                        Database.updateId(Compte,resultCompte.getId());
                        request.setAttribute("email", resultCompte.getEmail());
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("role").equals("conseiller") || session.getAttribute("role").equals("admin")) {

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
                field2.add("*");
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
