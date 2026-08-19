<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
  <html lang="pt-BR">

  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
  </head>

  <body class="text-left mt-5">

    <h1>Novo Contato</h1>
    <form action="${pageContext.request.contextPath}/novo-contato" method="post">
        <div class="mb-3">
            <label for="nome" class="form-label">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" required>
        </div>
        <div class="mb-3">
            <label for="telefone" class="form-label">Telefone</label>
            <input type="text" class="form-control" id="telefone" name="telefone" required>
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <a href="${pageContext.request.contextPath}/agenda" type="submit" class="btn btn-primary btn-lg mt-3">Salvar</a>
        <a href="${pageContext.request.contextPath}/agenda" type="submit" class="btn btn-outline-secondary btn-lg mt-3">Cancelar</a>
    </form>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
      crossorigin="anonymous"></script>
  </body>

  </html>