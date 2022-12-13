package agenda.model;

import agenda.enums.TipoContato;

import java.util.List;

public class Contato {
    private String nome;
    private String sobrenome;

    private TipoContato tipo;

    private List<Telefone> telefones;
    private List<Endereco> enderecos;

}
