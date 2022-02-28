<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />



    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"/>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">




    <title>Home</title>


</head>
<body>


<style>

    @import url("https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700;800;900&display=swap");
    body,
    button {
        font-family: "Inter", sans-serif;
        background-repeat: no-repeat;
        background-image: url('https://togoagropoles.tg/wp-content/uploads/2021/07/appeldoffres-1024x512-1.png');
        background-size: cover;
    }
    :root {
        --offcanvas-width: 270px;
        --topNavbarHeight: 56px;
    }
    .sidebar-nav {
        width: var(--offcanvas-width);
    }
    .sidebar-link {
        display: flex;
        align-items: center;
    }
    .sidebar-link .right-icon {
        display: inline-flex;
    }
    .sidebar-link[aria-expanded="true"] .right-icon {
        transform: rotate(180deg);
    }
    @media (min-width: 992px) {
        body {
            overflow: auto !important;
        }
        main {
            margin-left: var(--offcanvas-width);
        }
        /* this is to remove the backdrop */
        .offcanvas-backdrop::before {
            display: none;
        }
        .sidebar-nav {
            -webkit-transform: none;
            transform: none;
            visibility: visible !important;
            height: calc(100% - var(--topNavbarHeight));
            top: var(--topNavbarHeight);
        }
    }

</style>


<!-- top navigation bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="offcanvas"
                data-bs-target="#sidebar"
                aria-controls="offcanvasExample"
        >
            <span class="navbar-toggler-icon" data-bs-target="#sidebar"></span>
        </button>
        <a
                class="navbar-brand me-auto ms-lg-0 ms-3 text-uppercase fw-bold"

        ><h4>APPELS D'OFFRES</h4></a
        >
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#topNavBar"
                aria-controls="topNavBar"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="topNavBar">
            <form class="d-flex ms-auto my-3 my-lg-0">
                <div class="input-group">

                </div>
            </form>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a
                            class="nav-link dropdown-toggle ms-2"
                            href="#"
                            role="button"
                            data-bs-toggle="dropdown"
                            aria-expanded="false"
                    >
                        <i class="bi bi-person-fill"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><a class="dropdown-item" href="dcnx">Deconnexion</a></li>

                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- top navigation bar -->


<!-- offcanvas -->
<div
        class="offcanvas offcanvas-start sidebar-nav bg-dark"
        tabindex="-1"
        id="sidebar"
>
    <div class="offcanvas-body p-0">
        <nav class="navbar-dark">
            <ul class="navbar-nav">
                <li>
                    <div class="text-muted small fw-bold text-uppercase px-3">
                        CORE
                    </div>
                </li>
                <li>
                    <a href="#" class="nav-link px-3 active">
                        <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="my-4"><hr class="dropdown-divider bg-light" /></li>
                <li>
                    <div class="text-muted small fw-bold text-uppercase px-3 mb-3">
                        Interface
                    </div>
                </li>
                <li>
                    <a
                            class="nav-link px-3 sidebar-link"
                            data-bs-toggle="collapse"
                            href="#layouts"
                    >
                        <span class="me-2"><i class="bi bi-layout-split"></i></span>
                        <span>Services</span>
                        <span class="ms-auto">
                  <span class="right-icon">
                    <i class="bi bi-chevron-down"></i>
                  </span>
                </span>
                    </a>
                    <div class="collapse" id="layouts">
                        <ul class="navbar-nav ps-3">
                            <li>
                                <a href="prof" class="nav-link px-3">
                      <span class="me-2"
                      ><i class="bi bi-speedometer2"></i
                      ></span>
                                    <span>Appels d'Offres en cours</span>
                                </a>
                            </li>
                            <li>
                                <a href="etud" class="nav-link px-3">
                      <span class="me-2"
                      ><i class="bi bi-speedometer2"></i
                      ></span>
                                    <span>Entit&eacutes</span>
                                </a>
                            </li>
                            <li>
                                <a href="flr" class="nav-link px-3">
                      <span class="me-2"
                      ><i class="bi bi-speedometer2"></i
                      ></span>
                                    <span>R&eacutep L&eacutegales</span>
                                </a>
                            </li>
<%--                            <li>--%>
<%--                                <a href="mat" class="nav-link px-3">--%>
<%--                      <span class="me-2"--%>
<%--                      ><i class="bi bi-speedometer2"></i--%>
<%--                      ></span>--%>
<%--                                    <span>Matieres</span>--%>
<%--                                </a>--%>
<%--                            </li>--%>

                        </ul>
                    </div>
                </li>

                <li class="my-4"><hr class="dropdown-divider bg-light" /></li>



            </ul>
        </nav>
    </div>
</div>
<!-- offcanvas -->

<!-- Optional JavaScript; choose one of the two! -->


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>



<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


</body>
</html>
