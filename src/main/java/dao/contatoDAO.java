package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.DatabaseConnect;
import model.contato;

public class contatoDAO {
    public static List<contato> listar() {
        var query = "SELECT * FROM contatos";
        List<contato> contatos = new ArrayList<>();
        try (Connection connection = DatabaseConnect.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                var c = contato.builder()
                        .id(resultSet.getString("id"))
                        .nome(resultSet.getString("nome"))
                        .telefone(resultSet.getString("telefone"))
                        .email(resultSet.getString("email"))
                        .build();
                contatos.add(c);
            }
            return contatos;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar contatos", e);
        }
    }

    public static contato buscarPorId(String id) {
        var query = "SELECT * FROM contatos WHERE id = ?";
        try (Connection connection = DatabaseConnect.getConnection();
                PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

            statement.setString(1, id);

            if (resultSet.next()) {
                var c = contato.builder()
                        .id(resultSet.getString("id"))
                        .nome(resultSet.getString("nome"))
                        .telefone(resultSet.getString("telefone"))
                        .email(resultSet.getString("email"))
                        .build();
                return c;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar contato por ID", e);
        }
    }

    public static void atualizar(contato contatoAtualizado) {
        var query = "UPDATE contatos SET nome = ?, telefone = ?, email = ? WHERE id = ?";
        try (Connection connection = DatabaseConnect.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, contatoAtualizado.getNome());
            statement.setString(2, contatoAtualizado.getTelefone());
            statement.setString(3, contatoAtualizado.getEmail());
            statement.setString(4, contatoAtualizado.getId());

            statement.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar contato", e);
        }
    }

    public static void remover(contato contatoAtualizado) {
        var query = "DELETE FROM contatos WHERE id = ?";
        try (Connection connection = DatabaseConnect.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, contatoAtualizado.getId());    
            statement.executeUpdate(query);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover contato", e);
        }
    }

    public static void adicionar(contato novoContato) {
        var query = "INSERT INTO contatos (nome, telefone, email) VALUES(?,?,?)";
        try (Connection connection = DatabaseConnect.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)){

            statement.setString(1, novoContato.getNome());
            statement.setString(2, novoContato.getTelefone());
            statement.setString(3, novoContato.getEmail());
            statement.executeUpdate(query);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao adicionar contato", e);
        }
    }
}
