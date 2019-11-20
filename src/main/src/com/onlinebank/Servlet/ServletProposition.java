package com.onlinebank.Servlet;

import com.onlinebank.Models.Compte;
import com.onlinebank.Models.Produit;
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
import java.util.*;

import com.onlinebank.Utils.Filter;
import com.onlinebank.Utils.Utils;
import com.onlinebank.Utils.Verification;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "ServletProposition")
public class ServletProposition extends HttpServlet {
    private static final String VUE = "vues/accueil.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VUE).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        récupere les informations des produits proposé
        ArrayList<String> produit = new ArrayList<String>();
        produit.add("*");
        Produit produits = new Produit();
        List<Produit> i = Database.select(produits,produit);

        for (Produit result: i) {
            System.out.println("test" + " " + result.getNom() + result.getMinage() + result.getMaxage());

//            Récupere les informations des prospects
            ArrayList<String> fields = new ArrayList<String>();
            fields.add("*");
            Prospect client = new Prospect();
            List<Prospect> listprospect = Database.select(client, fields);
            Utils utils = new Utils();

            for (Prospect c : listprospect) {
                Integer age = utils.findAge(c.getAge());
//            condition pour les 18 ans à 24 ans
                int cond_12_min = 12;
                int cond_17_max = 17;
//            condition pour les 18ans à 24ans
                int cond_18_min = 18;
                int cond_24_max = 24;
//            condition pour les 25ans à 27ans
                int cond_25_min = 25;
                int cond_27_max = 27;
//            condition pour les 28ans à 49ans
                int cond_28_min = 28;
                int cond_49_max = 49;
//            condition pour les plus de 50ans
                int cond_50_min = 50;

                // CONDITION POUR LES 12/17
                if (age >= cond_12_min && age <= cond_17_max) {
                    if (!c.getVerifCcp()) {
                        System.out.println("Proposition de compte courant 12/17");
                    }
                    if (!c.getVerifLj()) {
                        System.out.println("Proposition de livret jeune 12/17");
                    }
                    if (!c.getVerifLa()) {
                        System.out.println("Proposition de livret a 12/17");
                    }
                    if (!c.getVerifPel()) {
                        System.out.println("Proposition de PEL 12/17");
                    }
                }

                // CONDITION POUR LES 18/24 SANS EMPLOI
                if (age >= cond_18_min && age <= cond_24_max) {
                    if (c.getSituationprofessionnel().equals("Sans emploi")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant Se 18/24");
                        }
                        if (!c.getVerifLj()) {
                            System.out.println("Proposition de livret jeune  Se 18/24");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a Se 18/24");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL Se 18/24");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV Se 18/24");
                        }
                    }

                    // CONDITION POUR LES 18/24 ETUDIANT
                    if (c.getSituationprofessionnel().equals("Etudiant")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant e 18/24");
                        }
                        if (!c.getVerifLj()) {
                            System.out.println("Proposition de livret jeune e 18/24");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a e 18/24");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL e 18/24");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV e 18/24");
                        }
                        if (!c.getVerifCe()) {
                            System.out.println("Proposition de Ce e 18/24");
                        }
                    }

                    // CONDITION POUR LES 18/24 CDD/INTERIMAIRE
                    if (c.getSituationprofessionnel().equals("CDD") || c.getSituationprofessionnel().equals("Interimaire")) {
                        if (c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant dfdfgdfgdgef");
                        }

                        if (!c.getVerifLj()) {
                            System.out.println("Proposition de livret jeune cdd/int 18/24");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a cdd/int 18/24");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL cdd/int 18/24");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV cdd/int 18/24");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc cdd/int 18/24");
                        }
                    }

                    // CONDITION POUR LES 18/24 CDI
                    if (c.getSituationprofessionnel().equals("CDI")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant cdi 18/24");
                        }
                        if (!c.getVerifLj()) {
                            System.out.println("Proposition de livret jeune cdi 18/24");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a cdi 18/24");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL cdi 18/24");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV cdi 18/24");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc");
                        }
                        if (!c.getVerifCi() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ci cdi 18/24");
                        }
                        if (!c.getVerifCa() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ca cdi 18/24");
                        }
                    }
                }

                // CONDITION POUR LES 25/27 SANS EMPLOI
                if (age >= cond_25_min && age <= cond_27_max) {
                    if (c.getSituationprofessionnel().equals("Sans emploi")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant se 25/27");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a se 25/27");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL se 25/27");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV se 25/27");
                        }
                    }

                    // CONDITION POUR LES 25/27 ETUDIANT
                    if (c.getSituationprofessionnel().equals("Etudiant")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant e 25/27");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a e 25/27");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL e 25/27");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV e 25/27");
                        }
                        if (!c.getVerifCe()) {
                            System.out.println("Proposition de Ce e 25/27");
                        }
                    }

                    // CONDITION POUR LES 25/27 CDD/INTERIMAIRE
                    if (c.getSituationprofessionnel().equals("CDD") && c.getSituationprofessionnel().equals("Interimaire")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant cdd/int 25/27");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a cdd/int 25/27");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL cdd/int 25/27");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV cdd/int 25/27");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc cdd/int 25/27");
                        }
                    }

                    // CONDITION POUR LES 25/27 CDI
                    if (c.getSituationprofessionnel().equals("CDI")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant cdi 25/27");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a cdi 25/27");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL cdi 25/27");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV cdi 25/27");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc cdi 25/27");
                        }
                        if (!c.getVerifCi() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ci cdi 25/27");
                        }
                        if (!c.getVerifCa() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ca cdi 25/27");
                        }
                    }
                }

                // CONDITION POUR LES 28/49 SANS EMPLOI
                if (age >= cond_28_min && age <= cond_49_max) {
                    if (c.getSituationprofessionnel().equals("Sans emploi")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant se 28/49");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a se 28/49");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL se 28/49");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV se 28/49");
                        }
                    }

                    // CONDITION POUR LES 28/49 ETUDIANT
                    if (c.getSituationprofessionnel().equals("Etudiant")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant e 28/49");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a e 28/49");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL e 28/49");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV e 28/49");
                        }
                    }

                    // CONDITION POUR LES 28/49 CDD/INTERIMAIRE
                    if (c.getSituationprofessionnel().equals("CDD") && c.getSituationprofessionnel().equals("Interimaire")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant cdd/int 28/49");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a cdd/int 28/49");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL cdd/int 28/49");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV cdd/int 28/49");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc cdd/int 28/49");
                        }
                    }

                    // CONDITION POUR LES 28/49 CDI
                    if (c.getSituationprofessionnel().equals("CDI")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant cdi 28/49");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a cdi 28/49");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL cdi 28/49");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV cdi 28/49");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc cdi 28/49");
                        }
                        if (!c.getVerifCi() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ci cdi 28/49");
                        }
                        if (!c.getVerifCa() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ca cdi 28/49");
                        }
                    }
                }

                // CONDITION POUR LES 50+ SANS EMPLOI
                if (age >= cond_50_min) {
                    if (c.getSituationprofessionnel().equals("Sans emploi")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant se 50+");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a se 50+");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL se 50+");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV se 50+");
                        }
                    }

                    // CONDITION POUR LES 50+ ETUDIANT
                    if (c.getSituationprofessionnel().equals("Etudiant")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant e 50+");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a e 50+");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL e 50+");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV e 50+");
                        }
                    }

                    // CONDITION POUR LES 50+ CDD/INTERIMAIRE
                    if (c.getSituationprofessionnel().equals("CDD") && c.getSituationprofessionnel().equals("Interimaire")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant cdd/int 50+");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a cdd/int 50+");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL cdd/int 50+");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV cdd/int 50+");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc cdd/int 50+");
                        }
                    }

                    // CONDITION POUR LES 50+ CDI
                    if (c.getSituationprofessionnel().equals("CDI")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant cdi 50+");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a cdi 50+");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL cdi 50+");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV cdi 50+");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc cdi 50+");
                        }
                        if (!c.getVerifCi() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ci cdi 50+");
                        }
                        if (!c.getVerifCa() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ca cdi 50+");
                        }
                    }
                    // CONDITION POUR LES 50+ RETRAITES
                    if (c.getSituationprofessionnel().equals("Retraite")) {
                        if (!c.getVerifCcp()) {
                            System.out.println("Proposition de compte courant retraite 50+");
                        }
                        if (!c.getVerifLa()) {
                            System.out.println("Proposition de livret a retraite 50+");
                        }
                        if (!c.getVerifPel()) {
                            System.out.println("Proposition de PEL retraite 50+");
                        }
                        if (!c.getVerifAv()) {
                            System.out.println("Proposition de AV retraite 50+");
                        }
                        if (!c.getVerifCc() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Cc retraite 50+");
                        }
                        if (!c.getVerifCa() && c.getRevenu() >= result.getRevenumin()) {
                            System.out.println("Proposition de Ca retraite 50+");
                        }
                    }
                }
            }
        }
        request.getRequestDispatcher(VUE).forward(request,response);
    }
}