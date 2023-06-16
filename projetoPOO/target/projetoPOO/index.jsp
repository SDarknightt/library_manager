<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .login-container {
            width: 400px;
            padding: 40px;
            background-color: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333333;
            margin-bottom: 30px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 10px;
            color: #555555;
        }

        input[type="text"],
        input[type="password"] {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #cccccc;
        }

        button[type="submit"] {
            padding: 12px 20px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        .register-link {
            display: block;
            margin-top: 20px;
            font-size: 14px;
            color: #555555;
            text-align: center;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .register-link:hover {
            color: #007bff;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>LOGIN</h2>
    <form method="POST" action="usuariocontroller">
        <label for="login">Login:</label>
        <input type="text" name="login" id="login" required>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>
        <input type="hidden" name="acao" value="fazerlogin">
        <button type="submit">Entrar</button>
    </form>
    <a class="register-link" href="registrar.jsp">Cadastrar-se</a>
</div>
</body>
</html>
