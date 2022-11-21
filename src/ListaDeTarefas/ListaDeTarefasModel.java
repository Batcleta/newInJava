package ListaDeTarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeTarefasModel {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList();


        boolean rodando = true;

        while (rodando) {
            System.out.println("====== LISTA DE OPÇÕES ======");
            System.out.println("[1] Cadastrar usuário");
            System.out.println("[2] Listar todos os usuários cadastrados");
            System.out.println("[3] Procurar usuário por email");
            System.out.println("[4] Atualizar dados de um usuário");
            System.out.println("[5] Remover usuário");
            System.out.println("[6] Sair");
            System.out.print("Digite a opção desejada: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1": {
                    Usuario usuario = cadastrarUsuario();
                    usuarios.add(usuario);
                    break;
                }
                case "2":
                    listarUsuarios(usuarios);
                    break;

                case "3":
                    pesquisarPorEmail(usuarios);
                    break;

                case "4":
                    atualizarCadastro(usuarios);
                    break;

                case "5":
                    deletarCadastro(usuarios);
                    break;

                case "6": {
                    System.out.println(" ====== OBRIGADO, VOLTE SEMPRE ======");
                    rodando = false;
                    break;
                }

                default:
                    System.out.println(" ====== Opção inválida ======");
            }
        }


    }


    private static Usuario cadastrarUsuario() {
        System.out.println(" ====== CADASTRO DE USUARIO ======");

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.print("Digite uma senha: ");
        String senha = sc.nextLine();

        Usuario u = new Usuario();
        u.setEmail(email);
        u.setSenha(senha);
        u.setNome(nome);

        return u;
    }

    private static void listarUsuarios(ArrayList<Usuario> usuarios) {
        System.out.println(" ====== USUARIOS CADASTRADOS ======");

        if(usuarios.size() == 0){
            System.out.println("Nenhum usuário cadastrado");
            return;
        }

        System.out.println("");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario uTemp = usuarios.get(i);
            System.out.println("Usuário: " + i);
            System.out.println("\tEmail: " + uTemp.getEmail());
            System.out.println("\tSenha: " + uTemp.getSenha());
            System.out.println("");
        }
        System.out.println("");
    }

    private static void pesquisarPorEmail(ArrayList<Usuario> usuarios) {
        System.out.println(" ====== PROCURAR USUARIO POR EMAIL ======");
        System.out.println("Digite o email do usuario");

        String email = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario uTemp = usuarios.get(i);

            if (email.equals(uTemp.getEmail().trim())) {
                encontrado = true;
                System.out.println("Usuário encontrado");
                System.out.println("\tEmail: " + uTemp.getEmail());
                System.out.println("\tSenha: " + uTemp.getSenha());
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Usuário não encontrado");
        }
    }

    private static void atualizarCadastro(ArrayList<Usuario> usuarios) {
        System.out.println(" ====== ATUALIZAR USUARIO ======");

        if(usuarios.size() == 0){
            System.out.println("Nenhum usuário cadastrado");
            return;
        }

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario uTemp = usuarios.get(i);
            System.out.println("ID: " + i + " - EMAIL: " + uTemp.getEmail());
        }

        System.out.println("Digite o id do usuário que deseja atualizar");
        int opcao = sc.nextInt();

        sc.nextLine();
        System.out.println("Digite o novo email");
        String email = sc.nextLine();

        System.out.println("Digite a nova senha");
        String senha = sc.nextLine();

        Usuario uTemp = usuarios.get(opcao);
        uTemp.setEmail(email);
        uTemp.setSenha(senha);
    }

    private static void deletarCadastro(ArrayList<Usuario> usuarios) {
        System.out.println(" ====== REMOVER USUARIO ======");

        if(usuarios.size() == 0){
            System.out.println("Nenhum usuário cadastrado");
            return;
        }

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario uTemp = usuarios.get(i);
            System.out.println("ID: " + i + " - EMAIL: " + uTemp.getEmail());
        }

        System.out.println("Digite o id do usuário que deseja atualizar");
        int opcao = sc.nextInt();
        sc.nextLine();

        boolean isInvalid;
        boolean confirmacao = false;

        do {
            isInvalid = false;
            System.out.println("Deseja realmente deletar o usuario? s = sim, n = não");
            String confirma = sc.nextLine();
            System.out.println(confirma);

            if(confirma.equalsIgnoreCase("s") && confirma.equalsIgnoreCase("n")){
                System.out.println("Opção incorreta");
                isInvalid = true;
                continue;
            }

            if(confirma.equalsIgnoreCase("s")){
                confirmacao = true;
            }

        }while(isInvalid);

        if(confirmacao){
            usuarios.remove(opcao);
            System.out.println("Cadastro removido com sucesso!");
        }

    }

}
