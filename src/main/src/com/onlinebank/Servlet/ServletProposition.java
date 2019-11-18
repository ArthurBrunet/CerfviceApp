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
        //ArrayList<String> errors = new ArrayList<String>();
//        Compte compte = new Compte();
        //      ArrayList filterCompte = new ArrayList();
        //    filterCompte.add(Filter.add("=","id_prospect","26"));
        //  Database.select()

        ArrayList<String> fields = new ArrayList<String>();
        fields.add("*");
        Prospect client = new Prospect();
        List<Prospect> listprospect = Database.select(client,fields);
        Utils utils = new Utils();


        for(Prospect c:listprospect){
            Integer age = utils.findAge(c.getAge());
            System.out.println(age);
            String situationProfessionel = c.getSituationprofessionnel();
            System.out.println(situationProfessionel);


        }

        int i = 15;
        int j = 22;
        int k = 26;
        int l = 30;
        int m = 66;
        String verifSituationProSe = "Sans emploi";
        String verifSituationProEtudiant = "Etudiant";
        String verifSituationProCdd = "CDD";
        String verifSituationProInterimaire = "Interimaire";
        String verifSituationProCdi = "CDI";
        String verifSituationProRetraite = "Retraite";
        boolean verifLj = false;
        boolean verifCcp = false;
        boolean verifLa = false;
        boolean verifPel = false;
        boolean verifAv = false;
        boolean verifCe = false;
        boolean verifCc = false;
        boolean verifCi = false;
        boolean verifCa = false;
        int verifRevenuCc = 855;
        int verifRevenuCi = 1600;
        int verifRevenuCa = 1600;

        // CONDITION POUR LES 12/17
        if (i >= 12 && i <= 17) {
            if (verifCcp == false) {
                System.out.println("propo compte courant 12/17");
            }
            if (verifLj == false) {
                System.out.println("propo livret jeune 12/17");
            }
            if (verifLa == false) {
                System.out.println("propo livret a 12/17");
            }
            if (verifPel == false) {
                System.out.println("propo pel 12/17");
            }
        }

        // CONDITION POUR LES 18/24 SANS EMPLOI
        if (j >= 18 && j <= 24) {
            if (verifSituationProSe == "Sans emploi") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant Se 18/24");
                }
                if (verifLj == false) {
                    System.out.println("propo livret jeune  Se 18/24");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a Se 18/24");
                }
                if (verifPel == false) {
                    System.out.println("propo pel Se 18/24");
                }
                if (verifAv == false) {
                    System.out.println("propo AV Se 18/24");
                }
            }

            // CONDITION POUR LES 18/24 ETUDIANT
            if (verifSituationProEtudiant == "etudiant") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant e 18/24");
                }
                if (verifLj == false) {
                    System.out.println("propo livret jeune e 18/24");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a e 18/24");
                }
                if (verifPel == false) {
                    System.out.println("propo pel e 18/24");
                }
                if (verifAv == false) {
                    System.out.println("propo AV e 18/24");
                }
                if (verifCe == false) {
                    System.out.println("propo Ce e 18/24");
                }
            }

            // CONDITION POUR LES 18/24 CDD/INTERIMAIRE
            if (verifSituationProCdd == "CDD" && verifSituationProInterimaire == "Interimaire") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant");
                }
                if (verifLj == false) {
                    System.out.println("propo livret jeune cdd/int 18/24");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a cdd/int 18/24");
                }
                if (verifPel == false) {
                    System.out.println("propo pel cdd/int 18/24");
                }
                if (verifAv == false) {
                    System.out.println("propo AV cdd/int 18/24");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc cdd/int 18/24");
                }
            }

            // CONDITION POUR LES 18/24 CDI
            if (verifSituationProCdi == "CDI") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant cdi 18/24");
                }
                if (verifLj == false) {
                    System.out.println("propo livret jeune cdi 18/24");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a cdi 18/24");
                }
                if (verifPel == false) {
                    System.out.println("propo pel cdi 18/24");
                }
                if (verifAv == false) {
                    System.out.println("propo AV cdi 18/24");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc");
                }
                if (verifCi == false && verifRevenuCi >= 1521) {
                    System.out.println("propo Ci cdi 18/24");
                }
                if (verifCa == false && verifRevenuCa >= 1521) {
                    System.out.println("propo Ca cdi 18/24");
                }
            }
        }

        // CONDITION POUR LES 25/27 SANS EMPLOI
        if (k >= 25 && k <= 27) {
            if (verifSituationProSe == "Sans emploi") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant se 25/27");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a se 25/27");
                }
                if (verifPel == false) {
                    System.out.println("propo pel se 25/27");
                }
                if (verifAv == false) {
                    System.out.println("propo AV se 25/27");
                }
            }

            // CONDITION POUR LES 25/27 ETUDIANT
            if (verifSituationProEtudiant == "etudiant") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant e 25/27");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a e 25/27");
                }
                if (verifPel == false) {
                    System.out.println("propo pel e 25/27");
                }
                if (verifAv == false) {
                    System.out.println("propo AV e 25/27");
                }
                if (verifCe == false) {
                    System.out.println("propo Ce e 25/27");
                }
            }

            // CONDITION POUR LES 25/27 CDD/INTERIMAIRE
            if (verifSituationProCdd == "CDD" && verifSituationProInterimaire == "Interimaire") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant cdd/int 25/27");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a cdd/int 25/27");
                }
                if (verifPel == false) {
                    System.out.println("propo pel cdd/int 25/27");
                }
                if (verifAv == false) {
                    System.out.println("propo AV cdd/int 25/27");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc cdd/int 25/27");
                }
            }

            // CONDITION POUR LES 25/27 CDI
            if (verifSituationProCdi == "CDI") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant cdi 25/27");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a cdi 25/27");
                }
                if (verifPel == false) {
                    System.out.println("propo pel cdi 25/27");
                }
                if (verifAv == false) {
                    System.out.println("propo AV cdi 25/27");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc cdi 25/27");
                }
                if (verifCi == false && verifRevenuCi >= 1521) {
                    System.out.println("propo Ci cdi 25/27");
                }
                if (verifCa == false && verifRevenuCa >= 1521) {
                    System.out.println("propo Ca cdi 25/27");
                }
            }
        }

        // CONDITION POUR LES 28/49 SANS EMPLOI
        if (l >= 28 && l <= 49) {
            if (verifSituationProSe == "Sans emploi") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant se 28/49");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a se 28/49");
                }
                if (verifPel == false) {
                    System.out.println("propo pel se 28/49");
                }
                if (verifAv == false) {
                    System.out.println("propo AV se 28/49");
                }
            }

            // CONDITION POUR LES 28/49 ETUDIANT
            if (verifSituationProEtudiant == "etudiant") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant e 28/49");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a e 28/49");
                }
                if (verifPel == false) {
                    System.out.println("propo pel e 28/49");
                }
                if (verifAv == false) {
                    System.out.println("propo AV e 28/49");
                }
            }

            // CONDITION POUR LES 28/49 CDD/INTERIMAIRE
            if (verifSituationProCdd == "CDD" && verifSituationProInterimaire == "Interimaire") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant cdd/int 28/49");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a cdd/int 28/49");
                }
                if (verifPel == false) {
                    System.out.println("propo pel cdd/int 28/49");
                }
                if (verifAv == false) {
                    System.out.println("propo AV cdd/int 28/49");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc cdd/int 28/49");
                }
            }

            // CONDITION POUR LES 28/49 CDI
            if (verifSituationProCdi == "CDI") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant cdi 28/49");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a cdi 28/49");
                }
                if (verifPel == false) {
                    System.out.println("propo pel cdi 28/49");
                }
                if (verifAv == false) {
                    System.out.println("propo AV cdi 28/49");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc cdi 28/49");
                }
                if (verifCi == false && verifRevenuCi >= 1521) {
                    System.out.println("propo Ci cdi 28/49");
                }
                if (verifCa == false && verifRevenuCa >= 1521) {
                    System.out.println("propo Ca cdi 28/49");
                }
            }
        }

        // CONDITION POUR LES 50+ SANS EMPLOI
        if (m >= 50) {
            if (verifSituationProSe == "Sans emploi") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant se 50+");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a se 50+");
                }
                if (verifPel == false) {
                    System.out.println("propo pel se 50+");
                }
                if (verifAv == false) {
                    System.out.println("propo AV se 50+");
                }
            }

            // CONDITION POUR LES 50+ ETUDIANT
            if (verifSituationProEtudiant == "etudiant") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant e 50+");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a e 50+");
                }
                if (verifPel == false) {
                    System.out.println("propo pel e 50+");
                }
                if (verifAv == false) {
                    System.out.println("propo AV e 50+");
                }
            }

            // CONDITION POUR LES 50+ CDD/INTERIMAIRE
            if (verifSituationProCdd == "CDD" && verifSituationProInterimaire == "Interimaire") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant cdd/int 50+");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a cdd/int 50+");
                }
                if (verifPel == false) {
                    System.out.println("propo pel cdd/int 50+");
                }
                if (verifAv == false) {
                    System.out.println("propo AV cdd/int 50+");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc cdd/int 50+");
                }
            }

            // CONDITION POUR LES 50+ CDI
            if (verifSituationProCdi == "CDI") {
                if (verifCcp == false) {
                    System.out.println("propo compte courant cdi 50+");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a cdi 50+");
                }
                if (verifPel == false) {
                    System.out.println("propo pel cdi 50+");
                }
                if (verifAv == false) {
                    System.out.println("propo AV cdi 50+");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc cdi 50+");
                }
                if (verifCi == false && verifRevenuCi >= 1521) {
                    System.out.println("propo Ci cdi 50+");
                }
                if (verifCa == false && verifRevenuCa >= 1521) {
                    System.out.println("propo Ca cdi 50+");
                }
            }
            // CONDITION POUR LES 50+ RETRAITES
            if(verifSituationProRetraite == "Retraite"){
                if (verifCcp == false) {
                    System.out.println("propo compte courant retraite 50+");
                }
                if (verifLa == false) {
                    System.out.println("propo livret a retraite 50+");
                }
                if (verifPel == false) {
                    System.out.println("propo pel retraite 50+");
                }
                if (verifAv == false) {
                    System.out.println("propo AV retraite 50+");
                }
                if (verifCc == false && verifRevenuCc >= 800) {
                    System.out.println("propo Cc retraite 50+");
                }
                if (verifCa == false && verifRevenuCa >= 1521) {
                    System.out.println("propo Ca retraite 50+");
                }
            }
        }
        request.getRequestDispatcher(VUE).forward(request,response);
    }
}