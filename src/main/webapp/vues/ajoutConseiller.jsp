<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: rhorew
  Date: 20/11/2019
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%
    if (request.getAttribute("TableauProduit") != null){
        ArrayList<String> tableauProduit = (ArrayList<String>) request.getAttribute("TableauProduit");

%>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Icon -->
        <div class="fadeIn first">
            <img src="https://image.flaticon.com/icons/svg/1159/1159633.svg" id="icon" alt="User Icon" />
        </div>
        <form action="" method="post" accept-charset="ISO-8859-1">
            <h1>Ajout d'un produit</h1>
            <div class="col-sm-12">
                <select name="nomproduitajouter" id="nomproduitajouter" name="nomproduitajouter">
                        <%
        for (String nom: tableauProduit){
%>
                    <option value="<% out.print(nom);%>"><% out.print(nom);%></option>
                        <% } %>
                </select>
                <input type="hidden" value="<% out.print(request.getAttribute("idprospect"));%>" name="idprospect" id="idprospect">
                <button type="submit" class="fadeIn second btn btn-secondary">Ajouter</button>
            </div>
        </form>
    </div>
</div>
<%
    }
%>

<%@ include file="footer.jsp"%>
