package ListaDeTarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class HomePage {
    private static Scanner sc = new Scanner(System.in);

    public static void main(Usuario usuarioLogado) {

        boolean rodando = true;
        while (rodando) {

            System.out.println("[1] Mostrar tarefas");
            System.out.println("[2] Mostrar tarefas finalizadas");
            System.out.println("[3] Mostrar tarefas não finalizadas");
            System.out.println("[4] Adicionar nova tarefas ");
            System.out.println("[5] Finalizar tarefas ");
            System.out.println("[6] Remover tarefas ");
            System.out.println("[7] Logout ");

            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    mostrarTarefas(usuarioLogado, null);
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    System.out.println("Fazendo logout...");
                    rodando = false;
                    break;
                default:
                    System.out.println("==== Opção inválida ====");
            }

        }


    }

    private static void mostrarTarefas(Usuario usuarioLogado, Object o) {
    }
}
