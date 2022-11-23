package JavaPaths.Models;

import java.math.BigDecimal;

public class Produto {
    private Integer codigo;
    private String nome;
    private BigDecimal preço;
    private Integer quantidade;

    public Produto(Integer codigo, String nome, BigDecimal preço, Integer quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preço = preço;
        this.quantidade = quantidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreço() {
        return preço;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreço(BigDecimal preço) {
        this.preço = preço;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
