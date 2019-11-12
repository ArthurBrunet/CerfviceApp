<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <img src="https://image.flaticon.com/icons/svg/17/17004.svg" id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <form action="" method="post">
            <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email">
            <h2><% out.print(session.getAttribute("email")); %><h2>
            <input type="text" id="password" class="fadeIn third" name="motdepasse" placeholder="Mot de passe">
            <input type="submit" class="fadeIn fourth" value="Se connecter">
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="#">Mot de passe oublié ?</a>
        </div>

    </div>
</div>
<%@ include file="footer.jsp"%>