
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>



<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Visualizar Reservas</title>
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

        .devolver-button {
            cursor: pointer;
        }
    </style>
</head>
<body>
<nav class="navbar">
    <ul>
        <li><a href="livros.jsp">Livros</a></li>
        <li><a href="reservas.jsp">Reservas</a></li>
        <li><a href="clientes.jsp">Clientes</a></li>
        <li><a href="livros.jsp">Voltar</a></li>
    </ul>
</nav>
<h1 style="text-align: center">Visualizar Livros</h1>
<div class="table-container">
    <table class="table">
        <tbody>
        <c:if test="${not empty livros}">
            <table>
                <thead>
                <th>ID</th>
                <th>Nome</th>
                <th>Gênero</th>
                <th></th>
                </thead>
                <tbody>
                <c:forEach items="${livros}" var="livro">
                    <tr>
                        <td>${livro.getId()}</td>
                        <td>${livro.getNome()}</td>
                        <td>${livro.getGenero()}</td>
                        <td>
                            <form method="POST" action="livrocontroller">
                                <input type="hidden" name="idlivro" value="${livro.getId()}" />
                                <input type="hidden" name="acao" value="deletarlivro" />
                                <button type="submit" class="btn btn-danger devolver-button">Deletar</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        </tbody>
    </table>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
