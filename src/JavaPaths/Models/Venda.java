package JavaPaths.Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Integer idCompra;
    private List<ProdutoVenda> produtoVendas = new ArrayList();
    private BigDecimal totalCompra;
    private String desconto = "0";

    public Venda(Integer idCompra, List<ProdutoVenda> produtoVendas, BigDecimal totalCompra, String desconto) {
        this.idCompra = idCompra;
        this.produtoVendas = produtoVendas;
        this.totalCompra = totalCompra;
        this.desconto = desconto;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public List<ProdutoVenda> getProdutoVendas() {
        return produtoVendas;
    }

    public void setProdutoVendas(List<ProdutoVenda> produtoVendas) {
        this.produtoVendas = produtoVendas;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }
}
