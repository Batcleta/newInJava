package JavaPaths.Paginas;

import JavaPaths.Services.ProdDataService;
import JavaPaths.Services.VendDataService;

import java.nio.file.Path;
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
                        vendasDb.listarVendas();
                        break;
                    case "3":
                        vendasDb.ListarVendas();
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
