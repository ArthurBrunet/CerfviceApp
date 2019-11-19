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

@WebServlet(name = "ServletProduct")
public class ServletProduct extends HttpServlet {
    private static final String VUE = "vues/product.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(VUE).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(VUE).forward(request,response);
    }
}