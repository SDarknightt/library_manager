<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<html>
<head>
  <style>
    body {
      background-color: #D2D2D2;
      font-family: Arial, sans-serif;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    .form-container {
      width: 300px;
      padding: 20px;
      background-color: #ffffff;
      border: 1px solid #dddddd;
      border-radius: 5px;
    }

    h2 {
      text-align: center;
    }

    form {
      display: flex;
      flex-direction: column;
    }

    label {
      margin-bottom: 5px;
    }

    input[type="text"],
    input[type="password"] {
      padding: 5px;
      margin-bottom: 10px;
      border-radius: 3px;
      border: 1px solid #cccccc;
    }

    button[type="submit"] {
      padding: 10px 15px;
      background-color: #4CAF50;
      color: #ffffff;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    button[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-md-4 col-md-offset-4">
      <h2 class="text-center">Reservar Livro</h2>
      <form method="POST" action="reservacontroller">

        <c:if test="${not empty clientes}">
          <div class="form-group">
            <label for="cliente">Cliente</label>
            <select id="cliente" name="idcliente" class="form-control">
              <option value="">Selecione um cliente</option>
              <c:forEach items="${clientes}" var="cliente">
                <option value="${cliente.getId()}">${cliente.getNome()}</option>
              </c:forEach>
            </select>
          </div>
        </c:if>

        <c:if test="${not empty livros}">
          <div class="form-group">
            <label for="livro">Livro</label>
            <select id="livro" name="idlivro" class="form-control">
              <option value="">Selecione um livro</option>
              <c:forEach items="${livros}" var="livro">
                <option value="${livro.getId()}">${livro.getNome()}</option>
              </c:forEach>
            </select>
          </div>
        </c:if>

        <input type="hidden" name="acao" value="reservarlivro">
        <br>
        <button type="submit" class="btn btn-primary">Reservar</button>
      </form>

      <a href="reservas.jsp">Voltar</a>
    </div>
  </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</body>
</html>
