package JavaPaths.Services;

import JavaPaths.Models.Produto;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataService {

    private Path dbProduto;
    private Scanner sc = new Scanner(System.in);
    static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public DataService(String db) {
        this.dbProduto = Paths.get(db + "/produtos.txt");
    }

    public void CadastrarProduto() {
        try {
            criarArquivo();

            // Ler arquivo e adicionar valores a uma valiável List<String>
            List<String> produtos = Files.readAllLines(dbProduto, StandardCharsets.UTF_8);

            boolean newProd;

            do {
                newProd = false;

                // Produto: codigo - Nome - preço - quantidade
                System.out.print("== CADASTRO DE PRODUTOS ==\n");

                System.out.print("Digite o código do produto: ");
                String codigo = sc.nextLine();

                System.out.print("Digite o nome do produto: ");
                String nome = sc.nextLine();

                System.out.print("Digite o Preço do produto: ");
                String preço = sc.nextLine();

                System.out.print("Digite a quantidade do produto: ");
                String quantidade = sc.nextLine();


                // Pegar as entradas do usuário e concatenar na variavel lista anterior
                produtos.add(codigo + "&" + nome + "&" + preço + "&" + quantidade);


                System.out.println("Deseja cadastrar um novo produto?");
                System.out.println("[1] Sim");
                System.out.println("[2] Não");

                System.out.print("Escolha uma opção: ");
                String opcao = sc.nextLine();

                switch (opcao) {
                    case "1":
                        newProd = true;
                        break;
                    case "2":
                        break;
                    default:
                        System.out.print("Opção inválida\n");
                        newProd = true;
                }


            } while (newProd);

            // escrever os itens no arquivo
            Files.write(dbProduto, produtos);
            System.out.print("Dados gravados com sucesso\n\n");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    private void criarArquivo() {

        try {
            if (Files.exists(dbProduto)) {
                System.out.println("Arquivo ja existe");
            } else {
                dbProduto = Files.createFile(dbProduto);
                System.out.println("Arquivo criado em: " + dbProduto.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Produto> ListarProduto() {
        List<Produto> produtos = new ArrayList<Produto>();

        try {
            List<String> data = Files.readAllLines(dbProduto, StandardCharsets.UTF_8);

            for (int i = 0; i < data.size(); i++) {
                String[] dataTemp = data.get(i).split("&");
                BigDecimal preco = new BigDecimal(String.join(".", dataTemp[2].split(",")));
                Produto produtoFile = new Produto(Integer.parseInt(dataTemp[0]), dataTemp[1], preco, Integer.parseInt(dataTemp[3]));
                produtos.add(produtoFile);
            }

            System.out.print("\n\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return produtos;
    }

    public Produto ListarProdutoPorCodigo() {

        Produto produto = null;

        try {
            List<Produto> produtos = ListarProduto();

            System.out.println(" ====== PROCURAR PRODUTO POR CODIGO ======");
            System.out.println("Digite o codigo do produto");
            String codigo = sc.nextLine();

            boolean encontrado = false;
            for (int i = 0; i < produtos.size(); i++) {
                Produto prodTemp = produtos.get(i);

                if (codigo.equals(prodTemp.getCodigo().toString())) {
                    encontrado = true;
                    produto = produtos.get(i);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Produto não encontrado");
            }

        } catch (Exception ex) {
            System.out.println("Listar produtos: " + ex.getMessage());
        }

        return produto;
    }

    public void AtualizarProduto() {

        List<Produto> produtos = ListarProduto();
        List<String> produtosAtualizados = new ArrayList<String>();
        System.out.println("== ATUALIZAÇÂO DOS PRODUTOS ==");

        try {
            System.out.println("Digite o codigo do produto");
            String codigo = sc.nextLine();

            boolean encontrado = false;
            for (int i = 0; i < produtos.size(); i++) {
                Produto prodTemp = produtos.get(i);

                if (codigo.equals(prodTemp.getCodigo().toString())) {
                    encontrado = true;

                    boolean atualizar;

                    do {
                        atualizar = false;

                        System.out.println("O que deseja atualizar no produto?");
                        System.out.println("[1] Nome");
                        System.out.println("[2] Preço");
                        System.out.println("[3] Quantidade");
                        System.out.println("[4] Sair");

                        System.out.print("Escolha uma opção: ");
                        String opção = sc.nextLine();
                        System.out.print("\n");
                        switch (opção) {
                            case "1":

                                System.out.println("Digite o novo nome do produto");
                                String nome = sc.nextLine();

                                produtos.get(i).setNome(nome);
                                System.out.print("Nome do produto alterado com sucesso\n");

                                break;
                            case "2":
                                System.out.println("Digite o novo preço do produto");
                                BigDecimal preço = sc.nextBigDecimal();
                                sc.nextLine();

                                produtos.get(i).setPreço(preço);
                                System.out.print("Preço do produto alterado com sucesso\n");
                                break;
                            case "3":
                                System.out.println("Digite a nova quantidade do produto");
                                Integer quantidade = sc.nextInt();
                                sc.nextLine();

                                produtos.get(i).setQuantidade(quantidade);
                                System.out.print("Quantidade do produto alterada com sucesso\n");
                                break;
                            case "4":
                                break;
                            default:
                                System.out.println("Opção inválida");
                                atualizar = true;
                        }

                        System.out.println("Deseja alterar algo mais?");
                        System.out.println("[1] Sim");
                        System.out.println("[2] Não");

                        System.out.print("Escolha uma opção: ");
                        String opção2 = sc.nextLine();

                        switch (opção2) {
                            case "1":
                                atualizar = true;
                                break;
                            case "2":
                                // Atualizar na base de dados

                                for (int j = 0; j < produtos.size(); j++) {
                                    Produto attProdTemp = produtos.get(j);
                                    produtosAtualizados.add(attProdTemp.getCodigo().toString() + "&" + attProdTemp.getNome() + "&" + attProdTemp.getPreço().toString() + "&" + attProdTemp.getQuantidade().toString());
                                }

                                Files.write(dbProduto, produtosAtualizados);
                                System.out.print("Dados atualizados com sucesso\n\n");

                                break;
                            default:
                                System.out.print("Opção inválida\n");
                        }

                        System.out.print("\n");
                    } while (atualizar);

                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Produto não encontrado");
                return;
            }

        } catch (Exception e) {
            System.out.print("Atualizar produto: " + e.getMessage() + "\n\n");
        }
    }

    public void DeletarProduto() {

        try {
            List<Produto> produtos = ListarProduto();
            List<String> produtosAtualizados = new ArrayList<String>();

            System.out.println(" ====== DELETAR PRODUTO ======");
            System.out.println("Digite o codigo do produto");
            String codigo = sc.nextLine();

            boolean encontrado = false;
            for (int i = 0; i < produtos.size(); i++) {
                Produto prodTemp = produtos.get(i);

                if (codigo.equals(prodTemp.getCodigo().toString())) {
                    encontrado = true;

                    System.out.println("Código: " + prodTemp.getCodigo() + " - Nome: " + prodTemp.getNome());
                    System.out.print("\n");
                    System.out.println("Tem certeza que deseja deletar o produto?");
                    System.out.println("[1] Sim");
                    System.out.println("[2] Não");
                    System.out.print("Escolha uma opção: ");
                    String opção = sc.nextLine();

                    switch (opção) {
                        case "1":
                            produtos.remove(i);

                            for (int j = 0; j < produtos.size(); j++) {
                                Produto attProdTemp = produtos.get(j);
                                produtosAtualizados.add(attProdTemp.getCodigo().toString() + "&" + attProdTemp.getNome() + "&" + attProdTemp.getPreço().toString() + "&" + attProdTemp.getQuantidade().toString());
                            }

                            Files.write(dbProduto, produtosAtualizados);
                            System.out.print("Produto deletado com sucesso\n\n");

                            break;
                        case "2":
                        default:
                            System.out.println("Opção inválida");
                    }

                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Produto não encontrado");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
