<%@ page import="java.util.List" %>
<%@ page import="com.onlinebank.Models.Prospect" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<body class="body-dashboard">
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#"><img src="assets/img/logo_bank_gold_gold.png"></a>
    <input class="form-control form-control-dark" type="search" placeholder="Albert Denouvel..." aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Rechercher</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row row-dashboard">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    </div>
                    <li class="nav-item">
                        <a class="nav-link menu-cote" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                            <br/>Home OnlineBank
                        </a>
                    </li>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    </div>
                    <li class="nav-item menu-cote">
                        <a class="nav-link active" href="#1">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle></svg>
                            <br/> Mes clients<span class="sr-only">(actuel)</span>
                        </a>
                    </li>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    </div>
                    <li class="nav-item menu-cote">
                        <a class="nav-link" href="#2">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                            <br/> Produits
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>

            <div class="table-responsive" id="1">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Age</th>
                        <th>Email</th>
                        <th>Téléphone</th>
                        <th>Produit 1</th>
                        <th>Produit 2</th>
                        <th>Produit 3</th>
                        <th>Ses produits</th>
                        <th>En savoir plus</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% List<Prospect> c = (List<Prospect>) request.getAttribute("user");
                        for (Prospect result: c)
                        {
                            %><tr><%
                            %><td><% out.print(result.getNom()); %></td><%
                            %><td><% out.print(result.getPrenom()); %></td><%
                            %><td><% out.print(request.getAttribute(result.getId()+"email")); %></td><%
                            %><td><% out.print(result.getTelephone()); %></td><%
                            %><td><% if (request.getAttribute(result.getId()+"produit"+1) != null)
                    { out.print(request.getAttribute(result.getId()+"produit"+1)); }else{ out.print("Pas de produit"); }%></td><%
                            %><td><% if (request.getAttribute(result.getId()+"produit"+2) != null)
                    { out.print(request.getAttribute(result.getId()+"produit"+2)); }else{ out.print("Pas de produit"); }%></td><%
                            %><td><% if (request.getAttribute(result.getId()+"produit"+3) != null)
                    { out.print(request.getAttribute(result.getId()+"produit"+3)); }else{ out.print("Pas de produit"); }%></td><%
                            %><td><a href=""></a></td><%
                            %></tr><%
                        }
                    %>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sesProduits()">
                            Ses produits
                        </button></td>
                        <td><button type="button" class="btn btn-secondary" onclick="savoirPlus()">
                            En savoir plus
                        </button></td>
                    </tr>

                    </tbody>



                </table>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-end" id="2">
                        <li class="page-item disabled">
                            <a class="page-link" href="#" aria-label="Previous" tabindex="-1">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="page-item active"><a class="page-link" href="#">1<span class="sr-only">(current)</span>
                            </span></a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>



                <div class="table-responsive" id="1">
                    <table class="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Age</th>
                            <th>Email</th>
                            <th>Produit 1</th>
                            <th>Produit 2</th>
                            <th>Produit 3</th>
                            <th>Ses produits</th>
                            <th>En savoir plus</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1,001</td>
                            <td>Lorem</td>
                            <td>ipsum</td>
                            <td>dolor</td>
                            <td>sit</td>
                            <td>Lorem</td>
                            <td>ipsum</td>
                            <td><button type="button" class="btn btn-secondary" onclick="sesProduits()">
                                Ses produits
                            </button></td>
                            <td><button type="button" class="btn btn-secondary" onclick="savoirPlus()">
                                En savoir plus
                            </button></td>
                        </tr>

                        </tbody>


            </div>
            <div class="row">
                <div class="col-md-4">
                    <h2>Compte courant</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
                <div class="col-md-4">
                    <h2>Livret jeune</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
                <div class="col-md-4">
                    <h2>Livret A</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
                <div class="col-md-4">
                    <h2>PEL</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
                <div class="col-md-4">
                    <h2>Assurance vie</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
                <div class="col-md-4">
                    <h2>Crédit conso</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
                <div class="col-md-4">
                    <h2>Crédit immo</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
                <div class="col-md-4">
                    <h2>Crédit auto</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
                <div class="col-md-4">
                    <h2>Crédit étudiant</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <button type="button" class="btn btn-secondary modifier" onclick="modfierProduits()">
                        Modifier
                    </button>
                </div>
            </div>
        </main>
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item menu-cote">
                        <a class="nav-link" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" viewBox="0 0 24 24"><path d="M7.41 15.41L12 10.83l4.59 4.58L18 14l-6-6-6 6z"/><path d="M0 0h24v24H0z" fill="none"/></svg>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
<script>
        src="https://code.jquery.com/jquery-3.4.1.min.js"
</script>
<script>
    src="https://cdn.jsdelivr.net/npm/sweetalert2@9.1.5/dist/sweetalert2.all.min.js"
</script>
<script>
    function savoirPlus(){
        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: false
        })

        swalWithBootstrapButtons.fire({
            titleText: 'Amandine Pertout',
            html: 'Age: <b>23</b> </br> Situation familiale: <b>Veuf</b>' +
                ' </br> Revenu: <b>1700€</b> </br> Dépenses régulières: <b>2300€</b> </br> Situation professionnelle: <b>Chômage</b>' +
                ' </br> Téléphone: <b>02.54.38.89.27</b> </br> Enfants: <b>2</b> </br> Département : <b>Seine-Maritime</b>' +
                ' </br> Type Habitat : <b>HLM</b> </br> Situation de logement: <b>Locataire</b>' +
                ' </br> Ancienneté dans le logement: <b>3 ans</b> </br> Ancienneté professionnelle: <b>2 ans</b> </br> Notification : <b>Oui</b>' +
                ' </br> Bloque PUB : <b>Non</b> </br>',
            icon: 'info',
            showCancelButton: true,
            confirmButtonText: 'Modifier',
            cancelButtonText: 'Fermer',
            reverseButtons: true
        }).then((result) => {
            if (result.value) {
            Swal.mixin({
                input: 'text',
                confirmButtonText: 'Prochain &rarr;',
                showCancelButton: true,
                cancelButtonText: 'Fermer',
                progressSteps: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16']
            }).queue([
                'Nom: ',
                'Prénom: ',
                'Âge: ',
                'Situation familiale: ',
                'Revenu: ',
                'Dépenses régulières: ',
                'Situation professionnelle: ',
                'Téléphone: ',
                'Enfants: ',
                'Département: ',
                'Type habitat: ',
                'Situation de logement: ',
                'Ancienneté dans le logement: ',
                'Ancienneté professionnelle: ',
                'Notification: ',
                'BloquePUB: '
            ]).then((result) => {
                if (result.value) {
                Swal.fire({
                    title: 'Vous avez changé:',
                    html:
                        '<pre><code>' +
                        JSON.stringify(result.value) +
                        '</code></pre>',
                    confirmButtonText: 'Confirmer'
                })
            }
        })
        }
    })
    }
</script>
<script>
    function sesProduits() {
        Swal.fire({
                title: 'Produits clients: ',
                html: '<h4>Compte courant <input type="checkbox" id="Compte courant"  /></h4><p/>' +
            '<h4>Livret jeune <input type="checkbox" id="Livret jeune"  /></h4>'+
            '<h4>Livret A <input type="checkbox" id="Livret A"  /></h4><p/>' +
            '<h4>PEL <input type="checkbox" id="PEL"  /></h4><p/>' +
            '<h4>Assurance vie <input type="checkbox" id="Assurance vie"  /></h4>' +
            '<h4>Credit conso <input type="checkbox" id="Credit conso"  /></h4><p/>' +
            '<h4>Credit immo <input type="checkbox" id="Credit immo"  /></h4>' +
            '<h4>Credit auto <input type="checkbox" id="Credit auto"  /></h4>' +
            '<h4>Credit etudiant <input type="checkbox" id="Credit etudiant"  /></h4>',
        confirmButtonText: 'Confirmer',
            preConfirm: () => {
            var compcour = Swal.getPopup().querySelector('#compcour').checked
            var livjeu = Swal.getPopup().querySelector('#livjeu').checked
            var liva = Swal.getPopup().querySelector('#liva').checked
            var pel = Swal.getPopup().querySelector('#pel').checked
            var assuvie = Swal.getPopup().querySelector('#assuvie').checked
            var credcons = Swal.getPopup().querySelector('#credcons').checked
            var credimmo = Swal.getPopup().querySelector('#credimmo').checked
            var credauto = Swal.getPopup().querySelector('#credauto').checked
            var credetud = Swal.getPopup().querySelector('#credetud').checked
            console.log("Compte courant = " + compcour + " Livret jeune = " + livjeu + "Livret A = " + liva + " PEL = " + pel + "Assurance vie = " + assuvie + " Credit conso = " + credcons + "Credit immo = " + credimmo + " Credit auto = " + credauto + "Credit etudiant = " + credetud)


            return {
                compcour: compcour,
                livjeu: livjeu,
                liva: liva,
                pel: pel,
                assuvie: assuvie,
                credcons: credcons,
                credimmo: credimmo,
                credauto: credauto,
                credetud: credetud
            }
        }
    })
    .then((result) => {
            Prescrire.usoCompcour = result.value.compcour
            Prescrire.usoLivjeu = result.value.livjeu
            Prescrire.usoLiva = result.value.liva
            Prescrire.usoPel = result.value.pel
            Prescrire.usoAssuvie = result.value.assuvie
            Prescrire.usoCredcons = result.value.credcons
            Prescrire.usoCredimo = result.value.credimmo
            Prescrire.usoCredauto = result.value.credauto
            Prescrire.usoCredetud = result.value.credetud
            Swal.fire(`Compte courant?: ${result.value.compcour}\nLivret jeune?: ${result.value.livjeu}\nLivret A?: ${result.value.liva}\nPEL?: ${result.value.pel}\nAssurance vie?: ${result.value.assuvie}\nCrédit consommation?: ${result.value.credcons}\nCrédit immobilier?: ${result.value.credimmo}\nCrédit auto?: ${result.value.credauto}\nCrédit étudiant?: ${result.value.credetud}`)
        })
    }
</script>
<script>
    function modfierProduits(){
        (async () => {

            const { value: formValues } = await Swal.fire({
                title: 'Modifier',
                html:
                    '<input id="swal-input1" class="swal2-input">' +
                    '<input id="swal-input2" class="swal2-input">',
                focusConfirm: false,
                preConfirm: () => {
                return [
                    document.getElementById('swal-input1').value,
                    document.getElementById('swal-input2').value
                ]
            }
        })

        if (formValues) {
            Swal.fire(JSON.stringify(formValues))
        }

    })()
    }
</script>
</body>
<%@include file="footer.jsp"%>
