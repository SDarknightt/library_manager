<!DOCTYPE html>
<html>
<head>
    <title>Clientes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<nav class="navbar navbar-expand-lg fixed-top bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="principal.jsp">Biblioteca</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="livros.jsp">Livros</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="reservas.jsp">Reservas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="clientes.jsp">Clientes</a>
                </li>
                <li class="nav-item">
                    <a  class="nav-link" href="index.jsp">Sair</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">
                        <h1>Biblioteca</h1>
                        <div class="row">
                            <div class="col-sm-4 mb-3 mb-sm-0">
                                <div class="card">
                                    <div class="card-body">
                                        <a href="livros.jsp" class="btn btn-info">Livros</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4 mb-3 mb-sm-0">
                                <div class="card">
                                    <div class="card-body">
                                        <a href="reservas.jsp" class="btn btn-info">Reservas</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-body">

                                        <a href="clientes.jsp" class="btn btn-info">Clientes</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
