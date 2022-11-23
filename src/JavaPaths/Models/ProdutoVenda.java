package JavaPaths.Models;

import java.math.BigDecimal;

public class ProdutoVenda {

    private Integer codigo;
    private String nome;
    private BigDecimal preço;
    private Integer quantidade;
    private BigDecimal totalProdutos;

    public ProdutoVenda(Integer codigo, String nome, BigDecimal preço, Integer quantidade, BigDecimal totalProdutos) {
        this.codigo = codigo;
        this.nome = nome;
        this.preço = preço;
        this.quantidade = quantidade;
        this.totalProdutos = totalProdutos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreço() {
        return preço;
    }

    public void setPreço(BigDecimal preço) {
        this.preço = preço;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(BigDecimal totalProdutos) {
        this.totalProdutos = totalProdutos;
    }
}
