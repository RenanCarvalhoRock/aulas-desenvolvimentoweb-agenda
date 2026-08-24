package dao;

import java.util.ArrayList;
import java.util.List;

import factory.DatabaseConnect;
import model.contato;

public class contatoDAO {
    private static List<contato> contatos = new ArrayList<>();

    public static List<contato> listar() {
        var query = "SELECT * FROM contatos";
        try{
            var connection = DatabaseConnect.getConnection();
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                var c = contato.builder()
                .id(resultSet.getString("id"))
                .nome(resultSet.getString("nome"))
                .telefone(resultSet.getString("telefone"))
                .email(resultSet.getString("email"))
                .build();
                contatos.add(c);
            }
            return contatos;
        }catch(Exception e){
            throw new RuntimeException("Erro ao listar contatos", e);
        }
    }

    public static contato buscarPorId(String id){
        var query = "SELECT * FROM contatos WHERE id = '" + id + "'";
        try{
            var connection = DatabaseConnect.getConnection();
            var statement = connection.createStatement();
            var resultSet = statement.executeQuery(query);

            if(resultSet.next()){
                var c = contato.builder()
                .id(resultSet.getString("id"))
                .nome(resultSet.getString("nome"))
                .telefone(resultSet.getString("telefone"))
                .email(resultSet.getString("email"))
                .build();
                return c;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new RuntimeException("Erro ao listar contatos", e);
        }
    }

    public static void atualizar(contato contatoAtualizado){
        var query = "UPDATE contatos SET nome = '" 
                        + contatoAtualizado.getNome() + "', telefone = '" + contatoAtualizado.getTelefone() + "', email = '" + contatoAtualizado.getEmail() + "' WHERE id = '" + contatoAtualizado.getId() + "'";
        try{
            var connection = DatabaseConnect.getConnection();
            var statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch(Exception e){
            throw new RuntimeException("Erro ao listar contatos", e);
        }
    }

    public static void remover(contato contatoAtualizado){
        var query = "DELETE FROM contatos WHERE "+
                    "id = '" + contatoAtualizado.getId() + "'";
        try{
            var connection = DatabaseConnect.getConnection();
            var statement = connection.createStatement();
            statement.executeUpdate(query);

        }catch(Exception e){
            throw new RuntimeException("Erro ao listar contatos", e);
        }
    }

    public static void adicionar(contato novoContato){
        var query = "INSERT INTO contatos (nome, telefone, email)"+
                     " VALUES ("+
                     "'" + novoContato.getNome() + "',"+
                     "'" + novoContato.getTelefone() + "', "+
                     "'" + novoContato.getEmail() + "')";
        try{
            var connection = DatabaseConnect.getConnection();
            var statement = connection.createStatement();
            statement.executeUpdate(query);

        }catch(Exception e){
            throw new RuntimeException("Erro ao listar contatos", e);
        }
    }
}
