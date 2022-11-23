package JavaPaths.Paginas;

import JavaPaths.Models.Produto;
import JavaPaths.Services.DataService;

import java.nio.file.Path;
import java.security.Provider;
import java.util.List;
import java.util.Scanner;

public class Produtos {
    private static Scanner sc = new Scanner(System.in);

     public static void main(Path db) {

         boolean rodando = true;

         while(rodando){

            try{
                System.out.println(" ==== GERENCIAR PRODUTOS =====");
                System.out.println("[1] Cadastrar Produtos");
                System.out.println("[2] Listar Produtos");
                System.out.println("[3] Listar Produtos por codigo");
                System.out.println("[4] Atualizar produto");
                System.out.println("[5] Deletar produto");
                System.out.println("[6] Voltar");

                System.out.print("Escolha uma opção: ");
                String opcao = sc.nextLine();
                System.out.print("\n\n");

                DataService produtosDb = new DataService(db.toString());


                switch (opcao){
                    case "1":
                        produtosDb.CadastrarProduto();
                        break;
                    case "2":
                        List<Produto> data = produtosDb.ListarProduto();

                        for (Produto produtos : data) {
                            System.out.println("Código: " + produtos.getCodigo() + " - Produto: " + produtos.getNome() + " - Preço: " + produtos.getPreço() + " - Quantidade: " + produtos.getQuantidade());
                        }
                        System.out.print("\n");

                        break;
                    case "3":
                        Produto produto = produtosDb.ListarProdutoPorCodigo();
                        System.out.println("Código: " + produto.getCodigo() + " - Produto: " + produto.getNome() + " - Preço: " + produto.getPreço() + " - Quantidade: " + produto.getQuantidade());
                        System.out.print("\n");
                        break;
                    case "4":
                        produtosDb.AtualizarProduto();
                        break;
                    case "5":
                        produtosDb.DeletarProduto();
                        break;
                    case "6":
                        System.out.println("---> Voltando...");
                        System.out.print("\n");
                        rodando = false;
                        break;
                    default:
                        System.out.println("Opção inválida");
                        System.out.print("\n");
                }
            }catch (Exception ex){
                ex.printStackTrace();
                ex.getMessage();
            }
         }

    }
}
