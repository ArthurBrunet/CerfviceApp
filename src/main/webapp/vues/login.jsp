<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<%  if (session.getAttribute("role") == null)
{ %>

<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="https://image.flaticon.com/icons/svg/17/17004.svg" id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <form action="" method="post" accept-charset="ISO-8859-1">
            <%
            if (request.getAttribute("error") != null){
                ArrayList error = (ArrayList) request.getAttribute("error");
                %>
            <h2 class="error-champs">
+                <%out.print(error.get(0));%>
            </h2>
            <%
                }
            %>
          
            <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email">
            <input type="password" id="password" class="fadeIn third" name="motdepasse" placeholder="Mot de passe">
            <button type="submit" class="fadeIn fourth btn btn-secondary modifier">Se connecter</button>
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="<% out.print(request.getContextPath());%>/register">Inscription</a>
        </div>

    </div>
</div>

<% }else{
    response.sendRedirect(request.getContextPath()+"/accueil");
}%>

<%@ include file="footer.jsp"%>