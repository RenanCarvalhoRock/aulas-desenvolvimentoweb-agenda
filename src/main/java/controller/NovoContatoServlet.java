package controller;

import java.io.IOException;

import dao.contatoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.contato;

@WebServlet("/novo-contato")
public class NovoContatoServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        var novoContato = contato.builder()
        .nome(request.getParameter("nome"))
        .telefone(request.getParameter("telefone"))
        .email(request.getParameter("email"))
        .build();

        contatoDAO.adicionar(novoContato);
    }

}
