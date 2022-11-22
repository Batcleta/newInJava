package vendas.pages;

import java.util.Scanner;

public class ProductsPage {
    private static Scanner sc = new Scanner(System.in);

    public static void main() {
        boolean rodando = false;
        while (rodando) {
            System.out.println(" ===== PRODUTOS =====");
            System.out.println("");
            System.out.println("[1] Cadastrar produto");
            System.out.println("[2] Consultar produtos");
            System.out.println("[3] Consultar produtos por código de barras");
            System.out.println("[4] Consultar produtos por nome");
            System.out.println("[5] Consultar movimentações de estoque");
            System.out.println("[6] Atualizar produto");
            System.out.println("[7] Deletar produto");
            System.out.println("[8] voltar");

            System.out.print("Escolha uma opção: ");
            String option = sc.nextLine();


            switch (option) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção incorreta, escolha uma das opções a seguir!");

            }

        }
    }
}
