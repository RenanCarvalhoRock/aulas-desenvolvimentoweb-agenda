<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <html lang="pt-BR">

        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body class="text-left mt-5">
            <div class="container mt-4">
                <h2>Buscar Contato</h2>

                <form action="${pageContext.request.contextPath}/buscar-contato" method="get" class="d-flex mb-3 mt-3" role="search">
                    <input type="text" class="form-control me-2" name="nome" value="${termo}"
                        placeholder="Digite parte do nome (ex: ana)" required>
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </form>

                <c:if test="${buscou}">
                    <c:choose>
                        <c:when test="${empty contatos}">
                            <div class="alert alert-warning">
                                Nenhum contato encontrado para "${termo}".
                            </div>
                        </c:when>
                        <c:otherwise>
                            <table class="table table-striped mt-3">
                                <thead class="table-dark">
                                    <tr>
                                        <th>ID</th>
                                        <th>Nome</th>
                                        <th>Telefone</th>
                                        <th>E-mail</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="c" items="${contatos}">
                                        <tr>
                                            <td>${c.id}</td>
                                            <td>${c.nome}</td>
                                            <td>${c.telefone}</td>
                                            <td>${c.email}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:otherwise>
                    </c:choose>
                </c:if>

                <a href="${pageContext.request.contextPath}/agenda" class="btn btn-outline-secondary mt-3">Voltar para a Agenda</a>
            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
                crossorigin="anonymous"></script>
        </body>

        </html>
