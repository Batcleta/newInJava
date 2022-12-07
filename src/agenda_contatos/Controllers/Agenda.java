package agenda_contatos.Controllers;

import agenda_contatos.Models.Contato;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    List<Contato> contatos = new ArrayList<>();


    public void cadastrar(Contato contato){
        contatos.add(contato);
    }

    public List<Contato> listarTodos(int start, int quantidade){
        return contatos;
    }

    public Contato pesquisarPorNome(String nome){
        boolean encontrado = false;

        for (int i = 0; i < contatos.size(); i++) {
            Contato cTemp = contatos.get(i);

            if (nome.equals(cTemp.getNome().trim())) {
                encontrado = true;
                return cTemp;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado");
        }


    }

    public void editar(){
        Contato contato = pesquisarPorNome("");
        System.out.println("Cadastro editado com sucesso");
    }

    public void excluir(){
        Contato contato = pesquisarPorNome("");
        System.out.println("Cadastro excluido com sucesso");

    }
}
