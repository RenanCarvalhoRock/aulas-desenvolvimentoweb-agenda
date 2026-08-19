<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <html lang="pt-BR">

        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
        </head>

        <body class="text-left mt-5">
            <div class="container mt-4">
                <h2>Agenda de Contatos</h2>
                <table class="table table-striped mt-3">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Telefone</th>
                            <th>E-mail</th>
                            <th>Opções</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" items="${contatos}">
                            <tr>
                                <td>${c.id}</td>
                                <td>${c.nome}</td>
                                <td>${c.telefone}</td>
                                <td>${c.email}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/editar-contato?id=${c.id}" class="btn btn-sm btn-warning">Editar</a>
                                    <a href="${pageContext.request.contextPath}/excluir-contato?id=${c.id}" class="btn btn-sm btn-danger">Excluir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
                crossorigin="anonymous"></script>
        </body>

        </html>