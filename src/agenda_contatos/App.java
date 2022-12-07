package agenda_contatos;

import agenda_contatos.Models.Contato;
import agenda_contatos.Views.Agenda;

import java.util.ArrayList;
import java.util.List;

public class App {
    static List<Contato> contatos;

    public static void main(String[] args) {
        contatos = new ArrayList<>();
        Agenda.main(contatos);
    }
}
