<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<div class="wrapper fadeInDown">
    <div id="formContentte">
        <form action="" method="POST">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="identifiantconnexion">
                            <h1>Ajout d'un produit</h1>
                            <h2 class="text-center goldpolice">Informations</h2>
                            <hr class="gold">
                            <div class="row">
                                <div class="col">
                                    <label for="nom">Nom</label>
                                </div>
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="Nom" id="nom" name="nom">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="description">Description</label>
                                </div>
                                <div class="col">
                                    <input type="text" class="form-controler" placeholder="Description" id="description" name="description">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="minage">Age Minimum</label>
                                </div>
                                <div class="col">
                                    <input type="number" class="form-controle" placeholder="age minimum" id="minage" name="minage">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="maxage">Age Maximum</label>
                                </div>
                                <div class="col">
                                    <input type="number" class="form-controle" placeholder="age maximum" id="maxage" name="maxage">
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
                                        <option value="SANSEMPLOI">SANS EMPLOI</option>
                                        <option value="Interimaire">Intérimaire</option>
                                        <option value="RETRAITE">Retraité</option>
                                        <option value="ETUDIANT">Etudiant</option>

                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                    <div class="col">
                                        <label for="revenumin">Revenu Minimum</label>
                                    </div>
                                    <div class="col">
                                        <input type="number" class="form-controle" placeholder="Revenu Minimum" id="revenumin" name="revenumin">
                                    </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <label for="revenumax">Revenu Maximum</label>
                                </div>
                                <div class="col">
                                    <input type="number" class="form-controle" placeholder="Revenu Maximum" id="revenumax" name="revenumax">
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