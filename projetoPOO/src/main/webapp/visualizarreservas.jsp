<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
  <title>Visualizar Reservas</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
          <a class="nav-link active" href="reservas.jsp">Reservas</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="clientes.jsp">Clientes</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="reservas.jsp">Voltar</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<section class="vh-100 gradient-custom">
  <div class="container mt-5">
    <h1 class="text-center titulo">Reservas</h1>

    <table class="table table-striped table-bordered table-dark">
      <c:if test="${not empty reservas}">
        <thead class="thead-dark" style="border-radius: 1rem;">
        <tr>
          <th>Cliente</th>
          <th>Livro</th>
          <th>Devolver</th>
          <th>Editar</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${reservas}" var="reserva">
          <tr>
            <td>${reserva.getNomecliente()}</td>
            <td>${reserva.getNomelivro()}</td>
            <td>
              <form method="POST" action="reservacontroller">
                <input type="hidden" name="idcliente" value="${reserva.getClienteid()}" />
                <input type="hidden" name="idlivro" value="${reserva.getLivroid()}" />
                <input type="hidden" name="acao" value="devolverlivro" />
                <button type="submit" class="btn btn-secondary devolver-button">Devolver</button>
              </form>
            </td>
            <td>
              <form method="POST" action="reservacontroller">
                <input type="hidden" name="idreserva" value="${reserva.getIdreserva()}"/>
                <input type="hidden" name="acao" value="selecionareserva"/>
                <button type="submit" class="btn btn-info devolver-button">Editar</button>
              </form>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </c:if>
    </table>

  </div>
</section>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
