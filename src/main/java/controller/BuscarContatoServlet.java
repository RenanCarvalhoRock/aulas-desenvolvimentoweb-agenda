package controller;

import java.io.IOException;

import dao.contatoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/buscar-contato")
public class BuscarContatoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");

        if (nome != null && !nome.isBlank()) {
            request.setAttribute("contatos", contatoDAO.buscarPorNome(nome));
            request.setAttribute("termo", nome);
            request.setAttribute("buscou", true);
        }

        request.getRequestDispatcher("buscar-contato.jsp").forward(request, response);
    }
}
