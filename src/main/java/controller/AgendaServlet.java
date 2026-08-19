package controller;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.contatoDAO;
import model.contato;

@WebServlet("/agenda")
public class AgendaServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws jakarta.servlet.ServletException, java.io.IOException {
                                List<contato> contatos = new ArrayList<>();
                contatos.add(
                        contato.builder()
                                .id(1)
                                .nome("João")
                                .telefone("123456789")
                                .email("joao@exemplo.com")
                                .build());
                contatos.add(
                        contato.builder()
                                .id(2)
                                .nome("Jose")
                                .telefone("123456780")
                                .email("jose@exemplo.com")
                                .build());
                request.setAttribute("contatos", contatos);
                request.getRequestDispatcher("agenda.jsp").forward(request, response);
        }
}
