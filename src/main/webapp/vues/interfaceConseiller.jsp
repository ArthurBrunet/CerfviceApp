<%--
  Created by IntelliJ IDEA.
  User: rhorew
  Date: 20/11/2019
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

<a href="ajout?id=<%out.print(request.getParameter("id"));%>">AJOUTER UN PRODUIT</a>
<a href="updateconseiller?id=<%out.print(request.getParameter("id"));%>">MODIFICATION DU PROSPECT</a>

<%@ include file="footer.jsp"%>
