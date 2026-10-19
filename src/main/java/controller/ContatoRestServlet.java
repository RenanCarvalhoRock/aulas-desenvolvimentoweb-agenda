package controller;

import java.io.IOException;
import java.util.Optional;

import com.google.gson.Gson;

import dao.contatoDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.contato;

@WebServlet("/api/contatos/*") 
public class ContatoRestServlet extends HttpServlet {
    Gson gson = new Gson();

    // This servlet is currently empty and serves as a placeholder for future RESTful API implementations related to "contato".
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        var pathInfo = request.getPathInfo();
        if(pathInfo == null || pathInfo.equals("/")){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(gson.toJson(contatoDAO.listar()));
            return;
        }
        var id = pathInfo.substring(1);
        var contato = Optional.ofNullable(contatoDAO.buscarPorId(id));

        if(contato.isPresent()){
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write(gson.toJson(contato.get()));
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("{\"error\": \"Contato not found\"}");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            var novoContato = gson.fromJson(request.getReader(),  contato.class);
            contatoDAO.adicionar(novoContato);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(gson.toJson(novoContato));
            return;
        }catch(Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            try {
                response.getWriter().write("{\"error\": \"Erro ao adicionar contato\"}");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response){
        var pathInfo = request.getPathInfo();
        var id = pathInfo.substring(1);
        var contato = Optional.ofNullable(contatoDAO.buscarPorId(id));
        if(contato.isPresent()){
            contatoDAO.remover(contato.get());
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            try {
                response.getWriter().write("{\"error\": \"Contato não encontrado\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        var contatoAtualizado = gson.fromJson(request.getReader(),  contato.class);
        var pathInfo = request.getPathInfo();
        var id = pathInfo.substring(1);
        contatoAtualizado.setId(id);
        contatoDAO.atualizar(contatoAtualizado);
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(gson.toJson(contatoAtualizado));
        return;
    }

}

