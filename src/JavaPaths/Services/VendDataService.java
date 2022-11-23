package JavaPaths.Services;

import JavaPaths.Models.Produto;
import JavaPaths.Models.ProdutoVenda;
import JavaPaths.Models.Venda;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VendDataService {
    private Path db;
    private Path prodDb;
    private Path vendDb;
    private final Scanner sc = new Scanner(System.in);
    private final NumberFormat nf = NumberFormat.getCurrencyInstance();

    public VendDataService(String db) {
        this.prodDb = Paths.get(db + "/produtos.txt");
        this.vendDb = Paths.get(db + "/vendas.txt");
        this.db = Paths.get(db);
    }

    public void gerarNovaVenda() {

        try {
            criarArquivo();

            // Ler arquivo e adicionar valores a uma valiável List<String>
            List<String> vendas = Files.readAllLines(vendDb, StandardCharsets.UTF_8);
            List<Produto> produtos = new ProdDataService(db.toString()).ListarProduto();
            List<ProdutoVenda> produtoVendas = new ArrayList();
            List<Venda> vendasCarrinho = new ArrayList();

            boolean newProd;

            // codigoVenda & totalCompra & desconto & { codProd | nome | preço | quantidade }

            Integer codigoVenda = gerarNumeroCompra(5);
            BigDecimal totalDaCompra = new BigDecimal(0);
            String desconto = "0";

            adicionarProdutos(produtoVendas, produtos);

            for (int i = 0; i < produtoVendas.size(); i++) {
                ProdutoVenda pCTemp = produtoVendas.get(i);
                totalDaCompra = totalDaCompra.add(pCTemp.getTotalProdutos());
            }

            //Gerar Carrinho

            Venda novoCadastro = new Venda(codigoVenda, produtoVendas, totalDaCompra, desconto);
            vendasCarrinho.add(novoCadastro);

            for (int i = 0; i < vendasCarrinho.size(); i++) {
                Venda vendTemp = vendasCarrinho.get(i);

                String produtosVendaString = "";

                for (int j = 0; j < vendTemp.getProdutoVendas().size(); j++) {
                    List<ProdutoVenda> pvTemp = vendTemp.getProdutoVendas();
                    ProdutoVenda produto = pvTemp.get(j);

                    //Integer codigo, String nome, BigDecimal preço, int quantidade, BigDecimal totalProdutos
                    produtosVendaString = produtosVendaString += "{ " + produto.getCodigo().toString() +
                            "@" + produto.getNome() +
                            "@" + produto.getPreço().toString() +
                            "@" + produto.getQuantidade().toString() +
                            "@" + produto.getTotalProdutos().toString() +
                            " }#";
                }

                vendas.add(vendTemp.getIdCompra() + "&" + vendTemp.getTotalCompra() + "&" + vendTemp.getDesconto() + "&" + produtosVendaString);

            }

            // escrever os itens no arquivo
            Files.write(vendDb, vendas);
            System.out.print("Dados gravados com sucesso\n\n");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void adicionarProdutos(List<ProdutoVenda> produtosVenda, List<Produto> produtos) {
        boolean anotherProduct;


        do {
            anotherProduct = false;
            try {
                for (int i = 0; i < produtos.size(); i++) {
                    Produto pTemp = produtos.get(i);
                    System.out.println("ID: " + i + " - COD: " + pTemp.getCodigo() + " - NOME: " + pTemp.getNome() + " - PREÇO: " + nf.format(pTemp.getPreço()));
                }

                System.out.println("Digite o ID do produto que deseja colocar no carrinho");
                int opcao = sc.nextInt();

                if (opcao > produtos.size() - 1) {
                    System.out.println("Produto não existe");
                    return;
                }

                System.out.println("Digite a quantidade que deseja deste produto");
                int quantidade = sc.nextInt();
                sc.nextLine();

                Produto uTemp = produtos.get(opcao);
                BigDecimal total = uTemp.getPreço().multiply(BigDecimal.valueOf(quantidade));

                boolean encontrado = false;
                for (int i = 0; i < produtosVenda.size(); i++) {

                    ProdutoVenda pCTemp = produtosVenda.get(i);
                    if (uTemp.getCodigo().equals(pCTemp.getCodigo())) {
                        pCTemp.setQuantidade(pCTemp.getQuantidade() + quantidade);
                        pCTemp.setTotalProdutos(pCTemp.getTotalProdutos().add(total));
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    ProdutoVenda novoProduto = new ProdutoVenda(uTemp.getCodigo(), uTemp.getNome(), uTemp.getPreço(), quantidade, total);
                    produtosVenda.add(novoProduto);
                }

                uTemp.setEstoque(uTemp.getEstoque() - quantidade);

                System.out.println("Deseja inserir um novo produto?");
                System.out.println("[1] sim");
                System.out.println("[2] Não");
                System.out.print("Escolher uma opção: ");
                String escolha = sc.nextLine();


                switch (escolha) {
                    case "1":
                        anotherProduct = true;
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println("Opção inválida");
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                anotherProduct = true;
            }
        } while (anotherProduct);
    }

    private void criarArquivo() {

        try {
            if (Files.exists(vendDb)) {
                System.out.println("Arquivo ja existe");
            } else {
                vendDb = Files.createFile(vendDb);
                System.out.println("Arquivo criado em: " + vendDb.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int gerarNumeroCompra(int max) {
        int[] concatenador = new int[max];
        int gerador = 0;


        for (int i = 0; i < max; i++) {
            int aleatorio = (int) (Math.random() * max);
            concatenador[i] = aleatorio;
        }

        gerador = Integer.parseInt(Arrays.stream(concatenador).mapToObj(String::valueOf).reduce((a, b) -> a.concat(b)).get());

        return gerador;
    }

    public List<Venda> listarVendas() {

        //Falta tirar do estoque de produto original
        List<Venda> vendas = new ArrayList<Venda>();
        List<ProdutoVenda> produtos = new ArrayList<>();

        try {
            List<String> data = Files.readAllLines(vendDb, StandardCharsets.UTF_8);

            for (int i = 0; i < data.size(); i++) {
                String[] dataTemp = data.get(i).split("&");
                BigDecimal totalCompra = new BigDecimal(String.join(".", dataTemp[1].split(",")));

                String[] prodDataTemp = dataTemp[3].split("#");

                for (int j = 0; j < prodDataTemp.length; j++) {
                    String[] splitedProd = prodDataTemp[j].split("@");

                    //Integer codigo, String nome, BigDecimal preço, int quantidade, BigDecimal totalProdutos
                    Integer codProduto = Integer.parseInt(splitedProd[0].substring(2));
                    String nome = splitedProd[1];
                    BigDecimal preço = new BigDecimal(splitedProd[2]);
                    Integer quantidade = Integer.parseInt(splitedProd[3]);
                    BigDecimal totalProdutos = new BigDecimal(splitedProd[4].substring(0, splitedProd[4].length() - 1).trim());

                    ProdutoVenda produtoVendaList = new ProdutoVenda(codProduto, nome, preço, quantidade, totalProdutos);
                    produtos.add(produtoVendaList);
                }

                // Integer idCompra, List<ProdutoVenda> produtoVendas, BigDecimal totalCompra, String desconto
                Venda produtoFile = new Venda(Integer.parseInt(dataTemp[0]), produtos, totalCompra, dataTemp[2]);
                vendas.add(produtoFile);
            }

            System.out.print("\n\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return vendas;

    }

    public void ListarVendasPorCodigo() {
    }

    public void cancelarVenda() {
    }
}
