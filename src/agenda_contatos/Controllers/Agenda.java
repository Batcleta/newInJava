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

        System.out.println("Digite o nome do contato");

        return
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
