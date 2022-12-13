package JavaPaths;

import JavaPaths.views.Produtos;
import JavaPaths.views.Vendas;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Path db = Paths.get("src/JavaPaths/database/db");

    public static void main(String[] args) {

        System.out.print("== BEM VINDO AO BILOLA PDV == \n\n");

        boolean rodando = true;
        while (rodando) {

            System.out.println("[1] Gerenciar produtos");
            System.out.println("[2] Vender");
            System.out.println("[3] Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();
            System.out.print("\n\n");

            switch (opcao) {
                case "1":
                    Produtos.main(db);
                    break;
                case "2":
                    Vendas.main(db);
                    break;
                case "3":
                    System.out.println("---> Obrigado por utilizar o Bilolog PDV");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.print("\n\n");
            }

        }
    }
}
