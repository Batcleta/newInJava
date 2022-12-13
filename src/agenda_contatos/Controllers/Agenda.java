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
        List<Contato> contatosEncontrados = new ArrayList();

        if (start < 0 || start > contatos.size()) start = 0;
        if (quantidade < 0) quantidade = 0;
        if (quantidade > contatos.size()) quantidade = contatos.size() - 1;
        if (start+quantidade > contatos.size()) quantidade = contatos.size() - 1;

        for (int i = start; i < start+quantidade; i++) {
            if(i == contatos.size()) {
                break;
            }
            contatosEncontrados.add(contatos.get(i));
        }
        return contatosEncontrados;

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
