package com.onlinebank.Utils;

import com.onlinebank.Servlet.ServletRegister;

import java.rmi.server.ExportException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Verification extends ServletRegister {

     /**
     * Valide l'adresse mail saisie.
     */
     public void validationEmail(String email) throws Exception {
        if ( email != null && email.trim().length() != 0 ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        }
    }

    /**
     * Valide les mots de passe saisis.
     */
    public void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
        if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.trim().length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    /**
     * Valide le nom d'utilisateur saisi.
     */
    public void validationNom( String nom ) throws Exception {
        if ( nom != null && nom.trim().length() < 3 ) {
            throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
        }
    }

    /**
     * Valide le prenom d'utilisateur saisi.
     */
    public void validationPrenom( String prenom) throws Exception {
        if ( prenom != null && prenom.trim().length() < 3 ) {
            throw new Exception("Le prenom de l'utilisateur doit contenir au moins 3 caractères");
        }
    }

    /*Validation qu'il s'agit bien d'un numero de telephone*/
    public void validationtel(String telephone) throws Exception {
        if(!telephone.matches("(\\+[0-9][0-9][0-9]( [0-9][0-9])+)|([0-9]+)")){
            throw new Exception("Merci de saisir un telephone valide.");
        }
    }

    /*Validation d'un champs vide ou non*/
    public void validationVide(String champs) throws Exception{
        if ( champs != null){
            throw new Exception("Le champs est vide");
        }
    }
    /*Validation enfant*/
    public void validationEnfant(int enfant) throws Exception{
        if (enfant < 0){
            throw new Exception("Impossible d'avoir moins de 0 enfant");
        }
    }

    public void validationsituation(String situation) throws Exception {
        if (!situation.equals("celibataire") && !situation.equals("veuf") && !situation.equals("En couple") && !situation.equals("Etudiant")){
            throw new Exception("Veuillez choisir une situation proposée");
        }
    }

    public void validationsituationpro(String situation) throws Exception {
        if (!situation.equals("CDD") && !situation.equals("CDI") && !situation.equals("Intérimaire") && !situation.equals("Entrepreneur")){
            throw new Exception("Veuillez choisir une situation proposée");
        }
    }

    public void validationage(int age) throws Exception{
        if (age == Integer.parseInt(null)) {
            throw new Exception("Veuillez remplir ce champs");
        }
    }

    public void validationTypeHabitat(String typehabitat) throws Exception{
        if (!typehabitat.equals("Maison") && !typehabitat.equals("Appartement")){
            throw new Exception("Veuillez choisir une situation proposée");
        }
    }

    public void validationSituationLogement(String situationLogement) throws Exception{
        if (!situationLogement.equals("Locataire") && !situationLogement.equals("Proprietaire")){
            throw new Exception("Veuillez choisir une situation proposée");
        }
    }

    public void validationAnciennetelogement(int anciennete) throws Exception{
        if (anciennete <= 0 ){
            throw new Exception("Veuillez saisir un champs correct au formulaire");
        }
        if (anciennete >= 20 ){
            throw new Exception("Veuillez saisir un champs correct au formulaire");
        }
    }
    public void validationDate(String date) throws Exception {
        if (date.isEmpty()){
            throw new Exception("Veuillez saisir une date");
        }
    }
    public String findAge (String birthday) {
        String[] values = birthday.split("-", 0);
        return values[2] + "-" + values[1] + "-" + values[0];
    }
}
