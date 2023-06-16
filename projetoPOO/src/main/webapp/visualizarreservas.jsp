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
    <li><a href="reservas.jsp">Voltar</a></li>
  </ul>
</nav>
<h1 style="text-align: center">Visualizar Reservas</h1>
<div class="table-container">
  <table class="table">
    <thead class="thead-light">
    <tr>
      <th>ID Cliente</th>
      <th>Cliente</th>
      <th>ID Livro</th>
      <th>Livro</th>
      <th>Ação</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reservas}" var="reserva">
      <tr>
        <td>${reserva.getClienteid()}</td>
        <td>${reserva.getNomecliente()}</td>
        <td>${reserva.getLivroid()}</td>
        <td>${reserva.getNomelivro()}</td>
        <td>
          <form method="POST" action="reservacontroller">
            <input type="hidden" name="idcliente" value="${reserva.getClienteid()}" />
            <input type="hidden" name="idlivro" value="${reserva.getLivroid()}" />
            <input type="hidden" name="acao" value="devolverlivro" />
            <button type="submit" class="btn btn-danger devolver-button">Devolver</button>
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
