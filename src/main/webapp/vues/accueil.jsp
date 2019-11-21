<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 17350
  Date: 30/10/2019
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

    <nav class="navbar navbar-inverse">
        <form class="container-fluid" action="http://localhost:8080/OnlineBank_war_exploded/logout">
            <a class="navbar-brand" href="accueil">
                <img class="" src="assets/img/logo_bank_gold_biseau_noir.png">
            </a>
            <button type="submit" class="btn btn-secondary prap" href="logout">Déconnexion</button>
        </form>
    </nav>

    <title>Accueil</title>

    <div class="wrapper fadeInDown">
        <div id="formContennt">
                <div class="row justify-content-around">
                    <div class="col-4">
                        <h1 class="mb-4 text-center">Mes produits</h1>
                        <% if (request.getAttribute("TableauGlobal") !=null){
                            ArrayList<ArrayList> tableauGlobal = (ArrayList<ArrayList>) request.getAttribute("TableauGlobal");
                            for (ArrayList tableau:tableauGlobal){
                                %>
                        <div class="case" style="">
                            <p class="font-weight-bold text-uppercase"><% out.print(tableau.get(0)); %></p>
                            <p><% out.print(tableau.get(1)); %></p>
                        </div>
                        <% } } %>
                    </div>
                    <div class="col-4 brout">
                        <h1 class="mb-4 text-center">Mes offres</h1>
                        <%
                            if (request.getAttribute("arrayalgo") != null){
                            ArrayList<String> algo = (ArrayList<String>) request.getAttribute("arrayalgo");
                            if (!algo.get(0).isEmpty()){
                        %>
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col ">
                                        <% out.print(algo.get(0)); %><br/>
                                        <button type="button" class="btn btn-secondary" id="fittext3">Contactez-nous</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                            }if (algo.get(1) != null){
                        %>
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col ">
                                        <% out.print(algo.get(1)); %><br/>
                                        <button type="button" class="btn btn-secondary" id="fittext3">Contactez-nous</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                            }if (algo.get(2) != null){
                        %>
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col ">
                                        <% out.print(algo.get(2)); %><br/>
                                        <button type="button" class="btn btn-secondary" id="fittext3">Contactez-nous</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%
                                }
                            }
                        %>

                    </div>
                </div>
        </div>
    </div>
<%@ include file="footer.jsp"%>


