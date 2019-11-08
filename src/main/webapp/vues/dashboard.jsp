<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp"%>
<body>
<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#"><img src="assets/img/logo_bank_gold_gold.png"></a>
    <input class="form-control form-control-dark" type="text" placeholder="Albert Denouvel..." aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link rechercher" href="#">Rechercher</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
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
                        <a class="nav-link active" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle></svg>
                            <br/> Clients<span class="sr-only">(actuel)</span>
                        </a>
                    </li>
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    </div>
                    <li class="nav-item menu-cote">
                        <a class="nav-link" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                            <br/> Produits
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4"><div class="chartjs-size-monitor" style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>

            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Age</th>
                        <th>Situation familial</th>
                        <th>Situation profesionnelle</th>
                        <th>Département</th>
                        <th>Situation de logement</th>
                        <th>Publicité</th>
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
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                        En savoir plus
                    </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td>dolor</td>
                        <td>sit</td>
                        <td>1,001</td>
                        <td>Lorem</td>
                        <td>ipsum</td>
                        <td><button type="button" class="btn btn-secondary" onclick="sweetAlert()">
                            En savoir plus
                        </button></td>
                    </tr>

                    </tbody>
                </table>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-end">
                        <li class="page-item disabled">
                            <a class="page-link" href="#" tabindex="-1">Précédent</a>
                        </li>
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item">
                            <a class="page-link" href="#">Suivant</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </main>
    </div>
</div>
<script>
        src="https://code.jquery.com/jquery-3.4.1.min.js"
</script>
<script>
    src="https://cdn.jsdelivr.net/npm/sweetalert2@9.1.5/dist/sweetalert2.all.min.js"
</script>
<script>
    function sweetAlert(){
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
</body>
<%@include file="footer.jsp"%>
