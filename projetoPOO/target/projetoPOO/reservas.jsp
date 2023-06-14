<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-color: rgba(210, 210, 210, 0.8);
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .navbar {
            width: 100%;
            background-color: #333333;
            padding: 10px;
            display: flex;
            justify-content: center;
        }

        .navbar ul {
            list-style-type: none;
            padding: 0;
        }

        .navbar ul li {
            display: inline-block;
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
        }

        .option a {
            text-decoration: none;
            color: #333333;
            font-size: 20px;
            font-weight: bold;
            transition: color 0.3s ease;
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
<div class="navbar">
    <ul>
        <li><a href="livros.jsp">Livros</a></li>
        <li><a href="reservas.jsp">Reservas</a></li>
        <li><a href="clientes.jsp">Clientes</a></li>
        <li><a href="principal.jsp">Voltar</a></li>
    </ul>
</div>
<h1 style="text-align: center">Reservas</h1>
<div class="options-container">
    <div class="option">
        <a href="reservarlivro.jsp">Reservar</a>
    </div>
    <div class="option">
        <a href="cancelarreserva.jsp">Devolver</a>
    </div>
    <div class="option">
        <a href="direcionareserva.jsp">Visualizar</a>
    </div>
</div>
</body>
</html>
