<!DOCTYPE html>
<html>
<head>
    <title>Clientes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .navbar {
            background-color: #333333;
            padding: 10px;
        }

        .navbar ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
        }

        .navbar ul li {
            margin: 0 10px;
        }

        .navbar ul li a {
            text-decoration: none;
            color: #ffffff;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        .navbar ul li a:hover {
            color: #45a049;
        }

        .options-container {
            display: flex;
            justify-content: center;
            margin-top: 30px;
        }

        .option {
            width: 200px;
            height: 200px;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 20px;
            transition: background-color 0.3s ease;
        }

        .option a {
            text-decoration: none;
            color: #333333;
            font-size: 20px;
            font-weight: bold;
        }

        .option:hover {
            background-color: #f2f2f2;
        }

        .option:hover a {
            color: #45a049;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <ul>
        <li><a href="livros.jsp">Livros</a></li>
        <li><a href="reservas.jsp">Reservas</a></li>
        <li><a href="clientes.jsp">Clientes</a></li>
        <li><a href="index.jsp">Sair</a></li>
    </ul>
</nav>
<h1 style="text-align: center">Biblioteca</h1>
<div class="options-container">

    <div class="option">
        <a href="livros.jsp">Livros</a>
    </div>
    <div class="option">
        <a href="reservas.jsp">Reservas</a>
    </div>
    <div class="option">
        <a href="clientes.jsp">Clientes</a>
    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>


