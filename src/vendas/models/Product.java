package vendas.models;

import java.util.ArrayList;

public class Product {
    private String Cod;
    private String Name;
    private String Marca;
    private String Preço;

    ArrayList<Inventory> movimentacoes = new ArrayList();

    public void Produto(String cod, String name, String marca, String preço) {
        this.Cod = cod;
        this.Name = name;
        this.Marca = marca;
        this.Preço = preço;
    }

    public ArrayList<Inventory> getMovimentacoes() {
        return movimentacoes;
    }
}
