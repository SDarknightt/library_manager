<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <div class="mb-md-5 mt-md-4 pb-5">
                            <h2 class="fw-bold mb-2 text-uppercase">Alterar Reserva</h2>
                            <p class="text-white-50 mb-5">Selecione outro livro!</p>

                            <form method="POST" action="reservacontroller">

                                    <c:if test="${not empty livros }">
                                        <div class="form-group">
                                            <label for="livro">Reserva</label>
                                            <select id="livro" name="idlivro" class="form-control" >
                                                <option>Altere o livro</option>
                                                <c:forEach items="${livros}" var="livro">
                                                    <option value="${livro.getId()}"> ${livro.getNome()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </c:if>
                                <h1>${editareserva.getIdreserva}</h1>

                                <input type="hidden" name="idreserva" value="31">
                                <input type="hidden" name="acao" value="editarreserva">
                                <button class="btn btn-outline-light btn-lg px-5" type="submit">Editar</button>
                                <div>
                                    <a href="reservas.jsp" class="text-white-50 fw-bold">Voltar</a>
                                </div>
                            </form>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>



