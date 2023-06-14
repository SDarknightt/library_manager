<%--
  Created by IntelliJ IDEA.
  User: Professor
  Date: 19/05/2023
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<div class="form-container">
  <h2>Reservar Livro</h2>
  <div>
    <form method="POST" action="reservacontroller">
      <label for="cliente">ID do Cliente</label>
      <input type="text" id="cliente" name="idcliente" required><br />
      <label for="livro">ID do Livro</label>
      <input type="text" id="livro" name="idlivro" required><br />
      <input type="hidden"  name="acao" value="reservarlivro"><br />
      <br />
      <button type="submit">Reservar</button>
    </form>
    <a href="reservas.jsp">Voltar</a>
  </div>
</div>
</body>
</html>