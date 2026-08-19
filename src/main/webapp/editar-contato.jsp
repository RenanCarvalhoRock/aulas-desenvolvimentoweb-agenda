<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
  <html lang="pt-BR">

  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>

  <body class="text-center mt-5">

    <h1>Editar Contato</h1>
    <form action="${pageContext.request.contextPath}/editar-contato" method="post">
        <input type="hidden" name="id" value="${contato.id}">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nome" value="${contato.nome}" name="nome" required>
        </div>
        <div class="mb-3">
            <label for="telefone" class="form-label">Telefone</label>
            <input type="text" class="form-control" id="telefone" value="${contato.telefone}" name="telefone" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" value="${contato.email}" name="email" required>
        </div>
        <button type="submit" class="btn btn-primary">Salvar</button>
    </form>

    <img src="${pageContext.request.contextPath}/resources/img/agenda.png" alt="Agenda Icon" class="mb-3">
    <p class="text-muted">Organize seus contatos em um só lugar</p>
    <a href="${pageContext.request.contextPath}/agenda" class="btn btn-primary btn-lg mt-3">Acessar</a>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
      crossorigin="anonymous"></script>
  </body>

  </html>