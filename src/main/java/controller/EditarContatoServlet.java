package controller;

import java.io.IOException;

import dao.contatoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.contato;

@WebServlet("/editar-contato")
public class EditarContatoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idContato = request.getParameter("id");
        contato contato = contatoDAO.buscarPorId(idContato);
        request.setAttribute("contato", contato);
        request.getRequestDispatcher("editar-contato.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        contato contatoAtualizado = 
        contato.builder()
        .id(request.getParameter("id"))
        .nome(request.getParameter("nome"))
        .telefone(request.getParameter("telefone"))
        .email(request.getParameter("email"))
        .build();

        contatoDAO.atualizar(contatoAtualizado);
        response.sendRedirect("agenda");
    }
}
