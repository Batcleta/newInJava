package ListaDeTarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private static Scanner sc = new Scanner(System.in);
    public static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList();

        boolean rodando = true;
        while (rodando) {

            //menu +input do usuário
            System.out.println("===== Bem vindo ao Bilolog!! =====");
            System.out.println("");
            System.out.println("[1] Fazer Cadastro");
            System.out.println("[2] Fazer Login");
            System.out.println("[3] Sair");
            System.out.println("");
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            //processamento das informações

            switch (opcao) {
                case "1":
                    fazerCadastro(usuarios);
                    break;
                case "2":
                    fazerLogin(usuarios);
                    break;
                case "3":
                    System.out.println("Obrigado, volte sempre");
                    rodando = false;
                    break;
                default:
                    System.out.println("==== Opção inválida ====");
            }

        }
    }

    private static void fazerLogin(ArrayList<Usuario> usuarios) {
        System.out.println("==== FAZENDO LOGIN ====");

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        boolean loginRealizado = false;

        for (Usuario u : usuarios) {
            String uEmail = u.getEmail();
            String uSenha = u.getSenha();

            boolean emailConfere = email.equalsIgnoreCase(uEmail);
            boolean senhaConfere = senha.equals(uSenha);

            if (emailConfere && senhaConfere) {
                // Login realizado com sucesso
                loginRealizado = true;
                usuarioLogado = u;
                break;
            }
        }
        // caso o login não seja realizado
        if (!loginRealizado) {
            System.out.println("-------> Login ou senha incorretos");
        } else {
            System.out.println("");
            System.out.println("-------> Bem vindo: " + usuarioLogado.getNome());
            System.out.println("");
            HomePage.main(usuarioLogado);
        }
    }

    private static void fazerCadastro(ArrayList<Usuario> usuarios) {
        System.out.println(" ====== CADASTRO DE USUARIO ======");

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.print("Digite uma senha: ");
        String senha = sc.nextLine();


        for (Usuario u : usuarios) {
            String uEmail = u.getEmail();

            boolean emailConfere = email.equalsIgnoreCase(uEmail);

            if (emailConfere) {
                // Usuário já cadastrado na base de dados
                System.out.println("Usuário já cadastrado para o email informado");
                return;
            }
        }

        Usuario u = new Usuario();
        u.setEmail(email);
        u.setSenha(senha);
        u.setNome(nome);

        usuarios.add(u);

        System.out.println(" ------> Usuário cadastrado com sucesso! ");
        System.out.println("");

    }


}
