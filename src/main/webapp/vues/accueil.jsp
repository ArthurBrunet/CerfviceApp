<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 17350
  Date: 30/10/2019
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
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
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        ita fdem similique sint, suscipit ut vero. Iste, voluptatem.<br/>
                                        <button type="button" class="btn btn-secondary prap">Contactez-nous</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        ita fdem similique sint, suscipit ut vero. Iste, voluptatem.<br/>
                                        <button type="button" class="btn btn-secondary">Contactez-nous</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col ">
                                        ita fdem similique sint, suscipit ut vero. Iste, voluptatem.<br/>
                                        <button type="button" class="btn btn-secondary" id="fittext3">Contactez-nous</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>
<%@ include file="footer.jsp"%>


