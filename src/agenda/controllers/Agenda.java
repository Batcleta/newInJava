package agenda.controllers;

import java.util.ArrayList;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionar(Contato contato) {
        contatos.add(contato);
    }

    public void excluir(Contato contatos) {
        contatos.remove(contato);
    }

    public List<Contato> pesquisarPorEmails(String nome) {
        List<Contato> contatosEncontrados = new ArrayList();
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().contains(email)) {
                contatosEncontrados.add(contatos.get(i));
            }
        }
        return contatosEncontrados;
    }

    public List<Contato> pesquisarPorEmails(String email) {
        List<Contato> contatosEncontrados = new ArrayList();
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getEmail().contains(email)) {
                contatosEncontrados.add(contatos.get(i));
            }
        }
        return contatosEncontrados;
    }

    public List<Contato> listar(int start, int quantidade) {

        if (start < 0 || start > contatos.size()) start = 0;
        if (quantidade < 0) quantidade = 0;
        if (quantidade > contatos.size()) quantidade = contatos.size() - 1;
        if (start+quantidade > contatos.size()) quantidade = contatos.size() - 1;

        List<Contato> contatosEncontrados = new ArrayList();

        for (int i = start; i < start+quantidade; i++) {
            if(i == contatos.size()) {
                                break;
            }

        }


    }


}
