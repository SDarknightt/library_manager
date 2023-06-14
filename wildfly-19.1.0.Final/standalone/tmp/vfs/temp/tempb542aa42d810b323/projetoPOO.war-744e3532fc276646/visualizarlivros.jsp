<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
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

        .table-container {
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th, table td {
            padding: 8px;
            border: 1px solid #dddddd;
            text-align: left;
        }

        table th {
            background-color: #f2f2f2;
        }

        table tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>

    <div class="navbar">
        <ul>
            <li><a href="livros.jsp">Livros</a></li>
            <li><a href="reservas.jsp">Reservas</a></li>
            <li><a href="clientes.jsp">Clientes</a></li>
            <li><a href="livros.jsp">Voltar</a></li>
        </ul>
    </div>

    <h1 style="text-align: center">Visualizar Livros</h1>
    <div class="options-container">
        <c:if test="${not empty livros}">
            <table>
                <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>Gênero</th>
                </thead>
                <tbody>
                <c:forEach items="${livros}" var="livro">
                    <tr>
                        <td>${livro.getId()}</td>
                        <td>${livro.getNome()}</td>
                        <td>${livro.getGenero()}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

</body>
</html>
