package dao;

import java.util.ArrayList;
import java.util.List;

import model.contato;

public class contatoDAO {
    private static List<contato> contatos = new ArrayList<>();
    static{
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
    }

    public static List<contato> listar() {
        return contatos;
    }

    public static contato buscarPorId(int id){
        for (contato c : contatos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public static void atualizar(contato contatoAtualizado){
        for (contato c : contatos){
            if(c.getId()==contatoAtualizado.getId()){
                c.setNome(contatoAtualizado.getNome());
                c.setTelefone(contatoAtualizado.getTelefone());
                c.setEmail(contatoAtualizado.getEmail());
                break;
            }
        }
    }

    public static void remover(contato contatoAtualizado){
        for (contato c : contatos){
            if(c.getId()==contatoAtualizado.getId()){
                contatos.remove(c);
                break;
            }
        }
    }
}
