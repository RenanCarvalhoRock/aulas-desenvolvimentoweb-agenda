package controller;

import java.io.IOException;

import dao.contatoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.contato;

@WebServlet("/excluir-contato")
public class ExcluirContatoServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        contato removerContato = contato.builder().id(request.getParameter("id")).build();
        
        contatoDAO.remover(removerContato);
        response.sendRedirect(request.getContextPath() + "/agenda");
    }
}
