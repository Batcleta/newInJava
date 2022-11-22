package vendas;

import vendas.models.User;
import vendas.pages.HomePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Login {
    private static Scanner sc = new Scanner(System.in);
    private static vendas.models.User User;

    public static void main(String[] args) {

        ArrayList<vendas.models.User> users = new ArrayList();

        boolean rodando = true;
        while (rodando) {

            System.out.println("==== Bem vindo ao BilologPdv ====");
            System.out.println("[1] Cadastrar funcionario");
            System.out.println("[2] Fazer login");
            System.out.println("[3] Sair");

            System.out.print("Escolha uma opção: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    cadastrarFuncionario(users);
                    break;
                case "2":
                    fazerLogin(users);
                    break;
                case "3":
                    System.out.println("Obrigado por usar o BilologPDV. Até a próxima");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção incorreta, escolha uma das opções a seguir!");

            }

        }
    }

    private static void cadastrarFuncionario(ArrayList<vendas.models.User> users) {

        try {
            System.out.println("=== CADASTRO DE USUARIO ===");
            System.out.println("Informe o seu nome");
            String name = sc.nextLine();
            System.out.println("Informe seu email");
            String email = sc.nextLine();
            System.out.println("Informe um login");
            String login = sc.nextLine();
            System.out.println("Informe uma senha");
            String password = sc.nextLine();

            if (users.size() > 0) {

                for (int i = 0; i < users.size(); i++) {
                    vendas.models.User fTemp = users.get(i);

                    if (login.equals(fTemp.getLogin())) {
                        System.out.println("Login ja cadastrado na base de dados");
                        return;
                    }

                    if (email.equals(fTemp.getEmail())) {
                        System.out.println("Email ja cadastrado na base de dados");
                        return;
                    }

                }
            }

            String registration = gerarMatricula(9);
            vendas.models.User cadastro = new User();

            cadastro.funcionario(registration, name, email, login, password, "atendente");
            users.add(cadastro);

            System.out.println("Cadastro realizado com sucesso");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static void fazerLogin(ArrayList<vendas.models.User> users) {

        try {
            System.out.println("=== LOGIN ===");
            System.out.println("Informe um login");
            String login = sc.nextLine();
            System.out.println("Informe uma senha");
            String password = sc.nextLine();

            boolean userMatch = false;
            for (int i = 0; i < users.size() ; i++) {
                vendas.models.User fTemp = users.get(i);

                boolean loginMatch = login.equals(fTemp.getLogin());
                boolean passwordMatch = password.equals(fTemp.getPassword());

                if(loginMatch && passwordMatch){
                    User = fTemp;
                    userMatch = true;
                    break;
                }

            }

            if(!userMatch){
                System.out.println("Login ou senha incorretos, deseja tentar novamente?");
                System.out.println("[1] Sim");
                System.out.println("[2] Não");

                System.out.print("Escolha uma opção");
                String opcao = sc.nextLine();

                if(opcao.equals("1")) {
                    fazerLogin(users);
                }

            }else{
                System.out.println("Seja bem vindo " + User.getName());
                System.out.println("Redirecionando para a página principal...");
                HomePage.main(User);
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    private static String gerarMatricula(int max) {
        int[] concatenador = new int[max];
        String gerador = "";

        int teste = 0;

        for (int i = 0; i < max; i++) {
            int aleatorio = (int) (Math.random() * max);
            concatenador[i] = aleatorio;
        }

        gerador = Arrays.stream(concatenador).mapToObj(String::valueOf)
                .reduce((a, b) -> a.concat(b)).get();

        return gerador;
    }

}
