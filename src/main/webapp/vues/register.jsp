<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>

<div class="wrapper fadeInDown">
    <div id="formContentte">
        <form action="register" method="POST" accept-charset="ISO-8859-1">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="identifiantconnexion">
                            <h2 class="text-center goldpolice">Identifiant de connexion</h2>
                            <hr class="gold">
                            <div class="row">
                                <div class="col">
                                    <label for="email">Adresse email</label>
                                </div>
                                <div class="col">
                                    <input type="email" class="form-control" placeholder="error@mail.com" id="email" name="email">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="password">Mot de passe</label>
                                </div>
                                <div class="col">
                                    <input type="password" class="form-controler" placeholder="*******" id="password" name="password">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="confirm_password">Confirmation mot de passe</label>
                                </div>
                                <div class="col">
                                    <input type="password" class="form-controle" placeholder="*******" id="confirm_password" name="confirm_password">
                                </div>
                            </div>
                        </div>
                        <div class="infoperso">
                            <h2 class="text-center goldpolice">Information personnel</h2>
                            <hr class="gold">
                            <div class="row">
                                <div class="col">
                                    <label for="name">Nom:</label>
                                </div>
                                <div>
                                    <input type="text" id="name" class="form-control" name="name" placeholder="Bono">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="firstname">Prénom:</label>
                                </div>
                                <div>
                                    <input type="text" id="firstname" class="form-control" name="firstname" placeholder="Jean">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <div class="row">
                                        <div class="col">
                                            <label for="telephone">Téléphone:</label>
                                        </div>
                                        <div class="col">
                                            <input type="tel" id="telephone" class="form-control" name="telephone" placeholder="+33 X XX XX XX XX">
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col">
                                            <label for="age">Age</label>
                                        </div>
                                        <div class="col">
                                            <input type="date" class="form-control" id="age" name="age" placeholder="36">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col">
                                    <div class="row">
                                        <div class="col">
                                            <label for="situation">Situation familiale:</label>
                                        </div>
                                        <div class="col">
                                            <select name="situation" id="situation" class="custom-select border">
                                                <option value="celibataire">Célibataire</option>
                                                <option value="couple">En couple</option>
                                                <option value="veuve">Veuve/Veuf</option>
                                                <option value="etudiant">Etudiant</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="row">
                                        <div class="col">
                                            <label for="enfants">Enfant(s) à charge:</label>
                                        </div>
                                        <div class="col">
                                            <select name="enfants" id="enfants" class="custom-select border">
                                                <option value="0">0</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="col-sm2 verticalhr"></div>
                    <div class="col">
                        <div class="inforevenu">
                            <h2 class="text-center goldpolice">Informations revenus</h2>
                            <hr class="gold">
                            <div class="row">
                                <div class="col">
                                    <label for="situationpro">Situation professionnel</label>
                                </div>
                                <div class="col">
                                    <select name="situationpro" id="situationpro" class="custom-select border">
                                        <option value="CDD">CDD</option>
                                        <option value="CDI">CDI</option>
                                        <option value="Interimaire">Intérimaire</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="revenu">Revenu :</label>
                                </div>
                                <div class="col">
                                    <input type="number" name="revenu" id="revenu" class="custom-select border">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="anciennete">Ancienneté professionel :</label>
                                </div>
                                <div class="col">
                                    <select name="anciennete" id="anciennete" class="custom-select border">
                                        <option value="1">0 à 2 ans</option>
                                        <option value="2">2 à 5 ans</option>
                                        <option value="3">5 à 10 ans</option>
                                        <option value="3">+ de 10 ans</option>

                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="depensereguliere">Dépense regulière :</label>
                                </div>
                                <div class="col">
                                    <select name="depensereguliere" id="depensereguliere" class="custom-select border">
                                        <option value="1">- 500 euros / mois</option>
                                        <option value="2">Entre 500 et 1000 mois</option>
                                        <option value="3">Entre 1000 et 2000 mois</option>
                                        <option value="3">+ 2000 euros / mois</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="infologement">
                            <h2 class="text-center goldpolice">Informations logement</h2>
                            <hr class="gold">
                            <div class="row">
                                <div class="col">
                                    <label for="departement">Département</label>
                                </div>
                                <div class="col">
                                    <select name="departement" id="departement" class="custom-select border">
                                        <option value="1">Seine Maritime</option>
                                        <option value="2">Paris</option>
                                        <option value="3">Savoie</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col"><label for="typehabitat">Type d'habitat :</label></div>
                                <div class="col">
                                    <select name="typehabitat" id="typehabitat" class="custom-select border">
                                        <option value="Maison">Maison</option>
                                        <option value="Appartement">Appartement</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col"><label for="situationlogement">Situation logement :</label></div>
                                <div class="col">
                                    <select name="situationlogement" id="situationlogement" class="custom-select border">
                                        <option value="Locataire">Locataire</option>
                                        <option value="Proprietaire">Propriétaire</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col"><label for="anciennetelogement">Ancienneté logement</label></div>
                                <div class="col">
                                    <select name="anciennetelogement" id="anciennetelogement" class="custom-select border">
                                        <option value="1">Inférieur à 1 ans</option>
                                        <option value="2"> 1 ans</option>
                                        <option value="3">Entre 1 et 2 ans</option>
                                        <option value="4">Entre 2 et 5 ans</option>
                                        <option value="5">Entre 5 et 10 ans</option>
                                        <option value="6">Supérieur à 10 ans</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <h2 class="text-center goldpolice">Informations compte ?</h2>
                        <hr class="gold">
                        <div class="row">
                            <div class="col"><label for="verifLj">Possession d'un livret jeune ?</label></div>
                            <input type="checkbox" name="verifLj" id="verifLj" class="col">
                        </div>
                        <div class="row">
                            <div class="col"><label for="verifCcp">Possession d'un compte courant ?</label></div>
                            <input type="checkbox" name="verifCcp" id="verifCcp" class="col">
                        </div>
                        <div class="row">
                            <div class="col"><label for="verifLa">Possession d'un livret A ?</label></div>
                            <input type="checkbox" name="verifLa" id="verifLa" class="col">
                        </div>
                        <div class="row">
                            <div class="col"><label for="verifPel">Possession d'un plan d'épargne logement ?</label></div>
                            <input type="checkbox" name="verifPel" id="verifPel" class="col">
                        </div>
                        <div class="row">
                            <div class="col"><label for="verifAv">Possession d'une assurance vie ?</label></div>
                            <input type="checkbox" name="verifAv" id="verifAv" class="col">
                        </div>
                        <div class="row">
                            <div class="col"><label for="verifCe">Possession d'un crédit etudiant ?</label></div>
                            <input type="checkbox" name="verifCe" id="verifCe" class="col">
                        </div>
                        <div class="row">
                            <div class="col"><label for="verifCc">Possession d'un crédit consommation ?</label></div>
                            <input type="checkbox" name="verifCc" id="verifCc" class="col">
                        </div>
                        <div class="row">
                            <div class="col"><label for="verifCi">Possession d'un crédit immobilier ?</label></div>
                            <input type="checkbox" name="verifCi" id="verifCi" class="col">
                        </div>
                        <div class="row">
                            <div class="col"><label for="verifCa">Possession d'un crédit automobile ?</label></div>
                            <input type="checkbox" name="verifCa" id="verifCa" class="col">
                        </div>
                        <% if (session.getAttribute("role") != null){
                            %>
                        <div class="row">
                            <div class="col"><label for="role">Role</label></div>
                            <select name="role" id="role" class="custom-select border">
                                <option value="user">User</option>
                                <option value="conseiller">Conseiller</option>
                                <option value="admin">Admin</option>
                            </select>
                        </div>
                        <%
                        }%>



                    </div>
                    <div class="col">

                    </div>
                </div>

                <div class="centerBTN">
                    <button type="submit" class="button btn-primary btn btn-secondary">Valider</button>
                </div>
            </div>

        </form>
    </div>
</div>
<%@ include file="footer.jsp"%>