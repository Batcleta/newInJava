package agenda_contatos.Controllers;
import agenda_contatos.Models.Contato;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    List<Contato> contatos = new ArrayList<>();
    public void cadastrar(Contato contato){
        contatos.add(contato);
        System.out.println("Cadastro adicionado com sucesso");
    }

    public List<Contato> listarTodos(int start, int quantidade){
        return contatos;
    }

    public Contato pesquisarPorNome(String nome){

        System.out.println("Digite o nome do contato");

        return
    }

    public List<Contato> pesquisarPorNome(String nome){
        List<Contato> contatosEncontrados = new ArrayList();
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getFullName().contains(nome)) {
                contatosEncontrados.add(contatos.get(i));
            }
        }
        return contatosEncontrados;
    }

    public void excluir(Contato contato){
        contatos.remove(contato);
        System.out.println("Cadastro excluido com sucesso");

    }
}
