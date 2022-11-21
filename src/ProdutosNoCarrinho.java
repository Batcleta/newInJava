//Crie um programa que simule uma lista(carrinho) de compras. O programa deve receber produtos, quantidade e seus
// respectivos preços. Ao receber todos os produtos, o programa deve imprimir todos os produtos, quantidade, os preços
// informados e o preço total dos produtos no carrinho.


import java.util.ArrayList;
import java.util.Scanner;

//models
interface IProduto {
    String codigo = "";
    String name = "";
    String preço = "";

    String getCodigo();

    String getName();

    String getPreço();

}

class Produto implements IProduto {
    private String codigo;
    private String name;
    private String preço;

    public Produto(String codigo, String name, String preço) {
        this.codigo = codigo;
        this.name = name;
        this.preço = preço;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public String getPreço() {
        return preço;
    }

}

//pages
class Produtos {
    public static void main(ArrayList<Produto> produtos) {
        //info
    }
}

class Carrinho {
    public static void main(ArrayList<Produto> produtos) {
//info
    }
}


public class ProdutosNoCarrinho {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList();

    public static void main(String[] args) {

        boolean rodando = true;
        while (rodando) {

            System.out.println(" ==== ACRRINHO DE COMPRAS =====");
            System.out.println("[1] Gerenciar produtos");
            System.out.println("[2] carrinho de compras");
            System.out.println("Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    Produtos.main(produtos);
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Opção inválida");

            }

        }

    }
}
