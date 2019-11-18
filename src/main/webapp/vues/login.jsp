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
        <form action="" method="post">
            <%
                if (request.getAttribute("error") != null){
                    ArrayList error = (ArrayList) request.getAttribute("error");
            %>
            <h2>
                <%out.print(error.get(0));%>
            </h2>
            <%
                }
            %>
            <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email">
            <input type="text" id="password" class="fadeIn third" name="motdepasse" placeholder="Mot de passe">
            <input type="submit" class="fadeIn fourth" value="Se connecter">
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="#">Mot de passe oublié ?</a>
        </div>

    </div>
</div>

<% }else{
    response.sendRedirect(request.getContextPath()+"/accueil");
}%>

<%@ include file="footer.jsp"%>