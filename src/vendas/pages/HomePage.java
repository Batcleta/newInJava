package vendas.pages;

import vendas.models.User;

import java.util.Scanner;

public class HomePage {
    private static Scanner sc = new Scanner(System.in);

    public static void main(User User) {

        boolean rodando = true;
        while (rodando) {
            System.out.println(" ======= MENU PRINCIPAL =======");
            System.out.println("");
            System.out.println("[1] Fazer uma venda");
            System.out.println("[2] Gerenciar Produtos");
            System.out.println("[3] Gerenciar Estoque");
            System.out.println("[4] Colaboradores");
            System.out.println("[5] Sair");
            System.out.print("Escolha uma opção: ");
            String option = sc.nextLine();


            switch (option) {
                case "1":
                    POS.main(User);
                    break;
                case "2":
                    ProductsPage.main();
                    break;
                case "3":
                    InventoryPage.main();
                    break;
                case "4":
                    if (User.getAuthorization().equals("admin")) {
                        UserPage.main();
                    }else{
                        System.out.println("Você não tem autorização para acessar este endPoint");
                    }
                    break;
                case "5":
                    System.out.println("Deslogando...");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção incorreta, escolha uma das opções a seguir!");

            }
        }
    }
}
