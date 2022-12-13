package agenda_contatos.Controllers;

public class Pessoa {

    private String Nome;
    private int Idade;

    public Pessoa(String nome) {
        this.Nome = nome;
    }

    public Pessoa(String nome, int idade) {
        this(nome);
        this.Idade = idade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        Idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome='" + Nome + '\'' +
                ", Idade=" + Idade +
                '}';
    }
}
