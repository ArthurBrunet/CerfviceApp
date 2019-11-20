<%--
  Created by IntelliJ IDEA.
  User: 17350
  Date: 30/10/2019
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

    <nav class="navbar navbar-inverse">
        <form class="container-fluid" action="http://localhost:8080/OnlineBank_war_exploded/logout" style="margin-bottom: auto">
            <a class="navbar-brand" href="accueil">
                <img class="" src="assets/img/logo_bank_gold_biseau_noir.png">
            </a>
            <a class="navbar-brand" href="accueil" style="color:#d9b01c; font-size: 50px;">ONLINE BANK</a>
            <button type="submit" class="btn btn-secondary prap" href="logout">Déconnexion</button>
        </form>
    </nav>

    <title>Accueil</title>
    <div class="wrapper fadeInDown">
        <div id="formContennt">
                <div class="row justify-content-around">
                    <div class="col-4">
                        <h1 class="mb-4 text-center">Mes produits</h1>
                        <div class="case" style="">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum debitis dolorem, eligendi ex expedita facilis ipsa ipsam labore molestiae molestias nisi nobis quidem similique sint, suscipit ut vero. Iste, voluptatem.
                        </div>
                        <div class="case">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum debitis dolorem, eligendi ex expedita facilis ipsa ipsam labore molestiae molestias nisi nobis quidem similique sint, suscipit ut vero. Iste, voluptatem.
                        </div>
                        <div class="case">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cum debitis dolorem, eligendi ex expedita facilis ipsa ipsam labore molestiae molestias nisi nobis quidem similique sint, suscipit ut vero. Iste, voluptatem.
                        </div>
                    </div>
                    <div class="col-4 brout">
                        <h1 class="mb-4 text-center">Mes offres</h1>
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        ita fdem similique sint, suscipit ut vero. Iste, voluptatem.<br/>
                                        <a href="contact">
                                            <button type="button" class="btn btn-secondary" id="fittext3">Contactez-nous</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                        ita fdem similique sint, suscipit ut vero. Iste, voluptatem.<br/>
                                        <a href="contact">
                                            <button type="button" class="btn btn-secondary" id="fittext3">Contactez-nous</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="case">
                            <div class="container">
                                <div class="row">
                                    <div class="col ">
                                        ita fdem similique sint, suscipit ut vero. Iste, voluptatem.<br/>
                                        <a href="contact">
                                        <button type="button" class="btn btn-secondary" id="fittext3">Contactez-nous</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </div>
<%@ include file="footer.jsp"%>


