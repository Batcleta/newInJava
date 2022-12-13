package JavaPaths.views;

import JavaPaths.Models.ProdutoVenda;
import JavaPaths.Models.Venda;
import JavaPaths.Services.VendDataService;

import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Vendas {
    private static Scanner sc = new Scanner(System.in);
    public static void main(Path db) {
        boolean rodando = true;

        do {
            System.out.println(" ==== CARRINHO DE COMPRAS =====");
            System.out.println("[1] Nova venda");
            System.out.println("[2] Listar vendas");
            System.out.println("[3] Listar vendas por idCompra");
            System.out.println("[4] Cancelar venda");
            System.out.println("[5] Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();
            System.out.print("\n");

            VendDataService vendasDb = new VendDataService(db.toString());

            if (opcao.length() == 1) {

                switch (opcao) {
                    case "1":
                        vendasDb.gerarNovaVenda();
                        break;
                    case "2":
                        List<Venda> data = vendasDb.listarVendas();

                        for (int i = 0; i < data.size(); i++) {
                            Venda venda = data.get(i);

                            System.out.println("Venda: " + venda.getIdCompra());
                            System.out.print("Produto ----->\n");
                            for (int j = 0; j < venda.getProdutoVendas().size(); j++) {
                                System.out.println("");
                                ProdutoVenda prodVendTemp = venda.getProdutoVendas().get(j);
                                System.out.println("\t\tCodigo: " + prodVendTemp.getCodigo());
                                System.out.println("\t\tNome: " + prodVendTemp.getNome());
                                System.out.println("\t\tPreço Unitário: " + prodVendTemp.getPreço());
                                System.out.println("\t\tQuantidade: " + prodVendTemp.getQuantidade());
                                System.out.println("\t\tPreço Total: " + prodVendTemp.getTotalProdutos());
                                System.out.println("");
                            }

                            System.out.println("Desconto: " + venda.getDesconto());
                            System.out.println("Total: " + venda.getTotalCompra());
                            System.out.print("\n\n");
                        }

                        break;
                    case "3":
                        vendasDb.ListarVendasPorCodigo();
                        break;
                    case "4":
                        vendasDb.cancelarVenda();
                        break;
                    case "5":
                        System.out.println("voltando...");
                        rodando = false;
                        break;
                    default:
                        System.out.println("Opção incorreta, escolha uma das opções a seguir!");
                }
            }
        } while (rodando);
    }
}
