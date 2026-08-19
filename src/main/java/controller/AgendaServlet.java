package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.contatoDAO;

@WebServlet("/agenda")
public class AgendaServlet extends HttpServlet {

        protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException {
                request.setAttribute("contatos", contatoDAO.listar());
                request.getRequestDispatcher("agenda.jsp").forward(request, response);
        }
}
