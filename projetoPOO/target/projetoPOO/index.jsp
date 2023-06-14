<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-color: rgba(210, 210, 210, 0.8);
            font-family: Arial, sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .login-container {
            width: 300px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9);
            border: 1px solid #dddddd;
            border-radius: 10px;
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
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }

        .register-link {
            display: inline-block;
            margin-top: 10px;
            font-size: 14px;
            color: #333333;
            text-decoration: none;
            transition: color 0.3s ease;
        }

        .register-link:hover {
            color: #45a049;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>LOGIN</h2>
    <div>
        <form method="POST" action="usuariocontroller">
            <label for="login">Login:</label>
            <input type="text" name="login" id="login" required> <br />
            <label for="senha" >Senha:</label>
            <input type="password" id="senha" name="senha" required>
            <input type="hidden" name="acao" value="fazerlogin">
            <br />
            <br />
            <button type="submit">Entrar</button>
        </form>
        <a class="register-link" href="registrar.jsp">Cadastrar-se</a>
    </div>
</div>
</body>
</html>
