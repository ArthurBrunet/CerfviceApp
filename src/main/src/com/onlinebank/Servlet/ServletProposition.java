package com.onlinebank.Servlet;

import com.onlinebank.Models.Prospect;
import com.onlinebank.Utils.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import com.onlinebank.Utils.Utils;

@WebServlet(name = "ServletProposition")
public class ServletProposition extends HttpServlet {
    private static final String VUE = "vues/accueil.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VUE).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<String> fields = new ArrayList<String>();
        fields.add("*");
        Prospect client = new Prospect();
        List<Prospect> listprospect = Database.select(client,fields);
        Utils utils = new Utils();

      /*  ArrayList<String> produit = new ArrayList<String>();
        produit.add("*");
        Produit produi = new Produit();
        List<Produit> i = Database.select(produi,produit);
            for (Produit result: i)
            {
                System.out.println("test" + result.getNom());
            }
*/

        for(Prospect c:listprospect)
        {
            Integer age = utils.findAge(c.getAge());

            // CONDITION POUR LES 12/17
            if (age >= 12 && age <= 17) {
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
            if (age >= 18 && age <= 24) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
                        System.out.println("Proposition de Cc");
                    }
                    if (!c.getVerifCi() && c.getRevenu() >= 1521) {
                        System.out.println("Proposition de Ci cdi 18/24");
                    }
                    if (!c.getVerifCa() && c.getRevenu() >= 1521) {
                        System.out.println("Proposition de Ca cdi 18/24");
                    }
                }
            }

            // CONDITION POUR LES 25/27 SANS EMPLOI
            if (age >= 25 && age <= 27) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
                        System.out.println("Proposition de Cc cdi 25/27");
                    }
                    if (!c.getVerifCi() && c.getRevenu() >= 1521) {
                        System.out.println("Proposition de Ci cdi 25/27");
                    }
                    if (!c.getVerifCa() && c.getRevenu() >= 1521) {
                        System.out.println("Proposition de Ca cdi 25/27");
                    }
                }
            }

            // CONDITION POUR LES 28/49 SANS EMPLOI
            if (age >= 28 && age <= 49) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
                        System.out.println("Proposition de Cc cdi 28/49");
                    }
                    if (!c.getVerifCi() && c.getRevenu() >= 1521) {
                        System.out.println("Proposition de Ci cdi 28/49");
                    }
                    if (!c.getVerifCa() && c.getRevenu() >= 1521) {
                        System.out.println("Proposition de Ca cdi 28/49");
                    }
                }
            }

            // CONDITION POUR LES 50+ SANS EMPLOI
            if (age >= 50) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
                        System.out.println("Proposition de Cc cdi 50+");
                    }
                    if (!c.getVerifCi() && c.getRevenu() >= 1521) {
                        System.out.println("Proposition de Ci cdi 50+");
                    }
                    if (!c.getVerifCa() && c.getRevenu() >= 1521) {
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
                    if (!c.getVerifCc() && c.getRevenu() >= 800) {
                        System.out.println("Proposition de Cc retraite 50+");
                    }
                    if (!c.getVerifCa() && c.getRevenu() >= 1521) {
                        System.out.println("Proposition de Ca retraite 50+");
                    }
                }
            }
        }
        request.getRequestDispatcher(VUE).forward(request,response);
    }
}