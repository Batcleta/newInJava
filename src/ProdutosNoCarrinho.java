
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//models
class Produto {
    private String codigo;
    private String name;
    private BigDecimal preço;

    public Produto(String codigo, String name, BigDecimal preço) {
        this.codigo = codigo;
        this.name = name;
        this.preço = preço;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPreço() {
        return preço;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreço(BigDecimal preço) {
        this.preço = preço;
    }
}

class ProdutoCarrinho extends Produto {
    private int quantidade;
    private BigDecimal preçoTotal;

    public ProdutoCarrinho(String codigo, String name, BigDecimal preço, int quantidade, BigDecimal preçoTotal) {
        super(codigo, name, preço);
        this.quantidade = quantidade;
        this.preçoTotal = preçoTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreçoTotal() {
        return preçoTotal;
    }

    public void setPreçoTotal(BigDecimal preçoTotal) {
        this.preçoTotal = preçoTotal;
    }
}

class Carrinho {
    private String idCompra;
    private ArrayList<ProdutoCarrinho> produtosCarrinho = new ArrayList();
    private BigDecimal totalCompra;
    private boolean finalizado;
    private String desconto = "0";

    public Carrinho(String idCompra, ArrayList<ProdutoCarrinho> produtosCarrinho, BigDecimal totalCompra, boolean finalizado) {
        this.idCompra = idCompra;
        this.produtosCarrinho = produtosCarrinho;
        this.totalCompra = totalCompra;
        this.finalizado = finalizado;
    }

    public String getIdCompra() {
        return idCompra;
    }

    public ArrayList<ProdutoCarrinho> getProdutosCarrinho() {
        return produtosCarrinho;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public void setProdutosCarrinho(ArrayList<ProdutoCarrinho> produtosCarrinho) {
        this.produtosCarrinho = produtosCarrinho;
    }


    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getDesconto() {
        return desconto;
    }

    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }
}


//pages
class ProdutoPage {
    static Scanner sc = new Scanner(System.in);
    static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public static void main(ArrayList<Produto> produtos) {

        boolean rodando = true;

        do {
            System.out.println(" ==== CARRINHO DE COMPRAS =====");
            System.out.println("[1] Cadastrar Produtos");
            System.out.println("[2] Listar Produtos");
            System.out.println("[3] Listar Produtos por codigo");
            System.out.println("[4] Atualizar produto");
            System.out.println("[5] Deletar produto");
            System.out.println("[6] Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            System.out.print("\n\n");

            if (opcao.length() == 1) {

                switch (opcao) {
                    case "1":
                        cadastrarProduto(produtos);
                        break;
                    case "2":
                        listarProdutos(produtos);
                        break;
                    case "3":
                        listarProdutoPorCodigo(produtos);
                        break;
                    case "4":
                        atualizarProduto(produtos);
                        break;
                    case "5":
                        deletarProduto(produtos);
                        break;
                    case "6":
                        System.out.println("voltando...");
                        rodando = false;
                        break;
                    default:
                        System.out.println("Opção incorreta, escolha uma das opções a seguir!");
                }
            }
        } while (rodando);
    }

    private static void cadastrarProduto(ArrayList<Produto> produtos) {

        try {
            System.out.println("=== CADASTRO DE USUARIO ===");
            System.out.println("Informe um codigo de barras (opcional)");
            String codigo = sc.nextLine();

            System.out.println("Informe o nome do produto");
            String nome = sc.nextLine();
            System.out.println("Informe o preço de venda do produto");
            BigDecimal preço = sc.nextBigDecimal();

            if (codigo.length() == 0) {
                codigo = gerarCodigo(4);
            }

            Produto cadastro = new Produto(codigo, nome, preço);
            produtos.add(cadastro);

            System.out.print("Cadastro realizado com sucesso\n\n");
            sc.nextLine();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void listarProdutos(ArrayList<Produto> produtos) {

        System.out.println(" ====== PRODUTOS CADASTRADOS ======");

        if (produtos.size() == 0) {
            System.out.println("Nenhum produto cadastrado");
            return;
        }

        System.out.println("");
        for (int i = 0; i < produtos.size(); i++) {
            Produto uTemp = produtos.get(i);
            System.out.println("Produto: " + i);
            System.out.println("\tCodigo: " + uTemp.getCodigo());
            System.out.println("\tNome: " + uTemp.getName());
            System.out.println("\tPreço: " + nf.format(uTemp.getPreço()));
            System.out.println("");
        }
        System.out.println("");
    }

    private static void listarProdutoPorCodigo(ArrayList<Produto> produtos) {
        System.out.println(" ====== PROCURAR PRODUTO POR CODIGO ======");
        System.out.println("Digite o codigo do produto");
        String codigo = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Produto uTemp = produtos.get(i);

            if (codigo.equals(uTemp.getCodigo().trim())) {
                encontrado = true;
                System.out.println("Produto encontrado");
                System.out.println("\tCodigo: " + uTemp.getCodigo());
                System.out.println("\tNome: " + uTemp.getName());
                System.out.println("\tPreço: " + nf.format(uTemp.getPreço()));
                System.out.println("");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado");
        }
    }

    private static void atualizarProduto(ArrayList<Produto> produtos) {
        System.out.println(" ====== ATUALIZAR PRODUTO ======");

        try {
            if (produtos.size() == 0) {
                System.out.println("Nenhum produto cadastrado");
                return;
            }

            for (int i = 0; i < produtos.size(); i++) {
                Produto pTemp = produtos.get(i);
                System.out.println("ID: " + i + " - COD: " + pTemp.getCodigo() + " - NOME: " + pTemp.getName() + " - PREÇO: " + nf.format(pTemp.getPreço()));
            }

            System.out.println("Digite o ID do produto que deseja atualizar");
            int opcao = sc.nextInt();

            if (opcao > produtos.size() - 1) {
                System.out.println("Produto não existe");
                return;
            }

            sc.nextLine();
            System.out.println("Digite um novo nome ( caso deseje atualizar o nome )");
            String nome = sc.nextLine();

            System.out.println("Digite um novo preço ( caso deseje atualizar o preço )");
            BigDecimal preço = sc.nextBigDecimal();
            sc.nextLine();

            Produto uTemp = produtos.get(opcao);

            if (nome.length() > 0) {
                uTemp.setName(nome);
            }

            uTemp.setPreço(preço);


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void deletarProduto(ArrayList<Produto> produtos) {
        System.out.println(" ====== REMOVER USUARIO ======");

        try {
            if (produtos.size() == 0) {
                System.out.println("Nenhum produto cadastrado");
                return;
            }

            for (int i = 0; i < produtos.size(); i++) {
                Produto pTemp = produtos.get(i);
                System.out.println("ID: " + i + " - COD: " + pTemp.getCodigo() + " - NOME: " + pTemp.getName() + " - PREÇO: " + nf.format(pTemp.getPreço()));
            }

            System.out.println("Digite o ID do produto que deseja deletar");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao > produtos.size() - 1) {
                System.out.println("Produto não existe");
                return;
            }

            System.out.println("Deseja realmente deletar o produto? [1] sim, [2] não");
            System.out.print("escolha uma opção: ");
            String confirma = sc.nextLine();
            System.out.println(confirma);

            switch (confirma) {
                case "1":
                    produtos.remove(opcao);
                    System.out.print("Produto removido com sucesso!\n\n");
                    break;
                case "2":
                    System.out.println("Voltando ao menu principal");
                    break;
                default:
                    System.out.println("Opção incorreta, voltaondo ao menu principal");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String gerarCodigo(int max) {
        int[] concatenador = new int[max];
        String gerador = "";

        int teste = 0;

        for (int i = 0; i < max; i++) {
            int aleatorio = (int) (Math.random() * max);
            concatenador[i] = aleatorio;
        }

        gerador = Arrays.stream(concatenador).mapToObj(String::valueOf).reduce((a, b) -> a.concat(b)).get();

        return gerador;
    }
}

class CarrinhoPage {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Carrinho> carrinhos = new ArrayList();
    static NumberFormat nf = NumberFormat.getCurrencyInstance();

    public static void main(ArrayList<Produto> produtos) {

        boolean rodando = true;

        do {
            System.out.println(" ==== CARRINHO DE COMPRAS =====");
            System.out.println("[1] Novo carrinho de compras");
            System.out.println("[2] Listar Carrinhos");
            System.out.println("[3] Listar Carrinhos por idCompra");
            System.out.println("[4] Listar Carrinhos por status");
            System.out.println("[5] Atualizar Carrinho");
            System.out.println("[6] Finalizar Compra");
            System.out.println("[7] Deletar Carrinho");
            System.out.println("[8] Voltar");

            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            System.out.print("\n\n");

            if (opcao.length() == 1) {

                switch (opcao) {
                    case "1":
                        criarCarrinho(produtos);
                        break;
                    case "2":
                        listarCarrinhos();
                        break;
                    case "3":
                        listarCarrinhosPorNumeroCompra();
                        break;
                    case "4":
                        listarCarrinhosPorStatus();
                        break;
                    case "5":
                        atualizarCarrinho(produtos);
                        break;
                    case "6":
                        finalizarCompra();
                        break;
                    case "7":
                        deletarCarrinho();
                        break;
                    case "8":
                        System.out.println("voltando...");
                        rodando = false;
                        break;
                    default:
                        System.out.println("Opção incorreta, escolha uma das opções a seguir!");
                }
            }
        } while (rodando);
    }

    private static void criarCarrinho(ArrayList<Produto> produtos) {

        ArrayList<ProdutoCarrinho> produtosCarrinho = new ArrayList();

        try {
            System.out.println("=== CARRINHO DE COMPRAS ===");
            System.out.println("------> Produtos");

            adicionarProdutos(produtosCarrinho, produtos);

            String idCompra = gerarNumeroCompra(4);
            BigDecimal totalDaCompra = new BigDecimal(0);


            for (int i = 0; i < produtosCarrinho.size(); i++) {
                ProdutoCarrinho pCTemp = produtosCarrinho.get(i);
                totalDaCompra = totalDaCompra.add(pCTemp.getPreçoTotal());
            }

            //Gerar Carrinho

            Carrinho novoCadastro = new Carrinho(idCompra, produtosCarrinho, totalDaCompra, false);
            carrinhos.add(novoCadastro);

            System.out.print("Cadastro realizado com sucesso\n\n");


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void adicionarProdutos(ArrayList<ProdutoCarrinho> produtosCarrinho, ArrayList<Produto> produtos) {
        boolean anotherProduct;


        do {
            anotherProduct = false;
            try {
                for (int i = 0; i < produtos.size(); i++) {
                    Produto pTemp = produtos.get(i);
                    System.out.println("ID: " + i + " - COD: " + pTemp.getCodigo() + " - NOME: " + pTemp.getName() + " - PREÇO: " + nf.format(pTemp.getPreço()));
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
                for (int i = 0; i < produtosCarrinho.size(); i++) {

                    ProdutoCarrinho pCTemp = produtosCarrinho.get(i);
                    if (uTemp.getCodigo().equals(pCTemp.getCodigo())) {
                        pCTemp.setQuantidade(pCTemp.getQuantidade() + quantidade);
                        pCTemp.setPreçoTotal(pCTemp.getPreçoTotal().add(total));
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    ProdutoCarrinho novoProduto = new ProdutoCarrinho(uTemp.getCodigo(), uTemp.getName(), uTemp.getPreço(), quantidade, total);
                    produtosCarrinho.add(novoProduto);
                }

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

    private static void listarCarrinhos() {
        System.out.println(" ====== CARRINHOS CRIADOS ======");

        if (carrinhos.size() == 0) {
            System.out.print("Nenhum carrinho criado\n\n");
            return;
        }

        System.out.println("");
        for (int i = 0; i < carrinhos.size(); i++) {

            Carrinho uTemp = carrinhos.get(i);

            System.out.println("-- > Carrinho: " + uTemp.getIdCompra());
            String status = uTemp.isFinalizado() ? "Finalizado" : "Em aberto";
            System.out.println("\tStatus: " + status);
            System.out.println("\tProdutos: ");

            for (int j = 0; j < uTemp.getProdutosCarrinho().size(); j++) {

                ProdutoCarrinho pCTemp = uTemp.getProdutosCarrinho().get(j);

                System.out.println("\t\tCodigo: " + pCTemp.getCodigo());
                System.out.println("\t\tNome: " + pCTemp.getName());
                System.out.println("\t\tPreço Unitário: " + pCTemp.getPreço());
                System.out.println("\t\tQuantidade: " + pCTemp.getQuantidade());
                System.out.println("\t\tPreço Total: " + nf.format(pCTemp.getPreçoTotal()));
                System.out.println("");
            }
            if (uTemp.isFinalizado() && uTemp.getDesconto().length() > 0) {
                System.out.println("\tDesconto: " + uTemp.getDesconto());
            }
            System.out.println("\tTotal: " + nf.format(uTemp.getTotalCompra()));
            System.out.println("");
        }
        System.out.println("");
    }

    private static void listarCarrinhosPorNumeroCompra() {

        System.out.println(" ====== PROCURAR CARRINHO POR IDCOMPRA ======");

        try {

            System.out.println("Digite o Numero da compra");
            String idCompra = sc.nextLine();

            boolean encontrado = false;
            for (int i = 0; i < carrinhos.size(); i++) {
                Carrinho uTemp = carrinhos.get(i);

                if (idCompra.equals(uTemp.getIdCompra())) {
                    encontrado = true;

                    System.out.println("-- > Carrinho: " + uTemp.getIdCompra());
                    String status = uTemp.isFinalizado() ? "Finalizado" : "Em aberto";
                    System.out.println("\tStatus: " + status);
                    System.out.println("\tProdutos: ");

                    for (int j = 0; j < uTemp.getProdutosCarrinho().size(); j++) {

                        ProdutoCarrinho pCTemp = uTemp.getProdutosCarrinho().get(j);

                        System.out.println("\t\tCodigo: " + pCTemp.getCodigo());
                        System.out.println("\t\tNome: " + pCTemp.getName());
                        System.out.println("\t\tPreço Unitário: " + pCTemp.getPreço());
                        System.out.println("\t\tQuantidade: " + pCTemp.getQuantidade());
                        System.out.println("\t\tPreço Total: " + nf.format(pCTemp.getPreçoTotal()));
                        System.out.println("");
                    }
                    if (uTemp.isFinalizado() && uTemp.getDesconto().length() > 0) {
                        System.out.println("\tDesconto: " + uTemp.getDesconto());
                    }
                    System.out.println("\tTotal: " + nf.format(uTemp.getTotalCompra()));
                    System.out.println("");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Carrinho não encontrado");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void listarCarrinhosPorStatus() {

        System.out.println(" ====== PROCURAR CARRINHO POR IDCOMPRA ======");

        try {

            System.out.println("Informe o ststus desejado");
            System.out.println("[1] Em aberto");
            System.out.println("[2] Finalizado");
            String statusCompra = sc.nextLine();

            if (!statusCompra.equals("1") && !statusCompra.equals("2")) {
                System.out.println("Opção inválida");
                System.out.print("\n\n");
                return;
            }

            boolean status = statusCompra.equals("2");

            boolean encontrado = false;
            for (int i = 0; i < carrinhos.size(); i++) {
                Carrinho uTemp = carrinhos.get(i);

                if (status == uTemp.isFinalizado()) {
                    encontrado = true;

                    System.out.println("-- > Carrinho: " + uTemp.getIdCompra());
                    System.out.println("\tStatus: " + status);
                    System.out.println("\tProdutos: ");

                    for (int j = 0; j < uTemp.getProdutosCarrinho().size(); j++) {

                        ProdutoCarrinho pCTemp = uTemp.getProdutosCarrinho().get(j);

                        System.out.println("\t\tCodigo: " + pCTemp.getCodigo());
                        System.out.println("\t\tNome: " + pCTemp.getName());
                        System.out.println("\t\tPreço Unitário: " + pCTemp.getPreço());
                        System.out.println("\t\tQuantidade: " + pCTemp.getQuantidade());
                        System.out.println("\t\tPreço Total: " + nf.format(pCTemp.getPreçoTotal()));
                        System.out.println("");
                    }

                    if (uTemp.isFinalizado() && uTemp.getDesconto().length() > 0) {
                        System.out.println("\tDesconto: " + uTemp.getDesconto());
                    }
                    System.out.println("\tTotal: " + nf.format(uTemp.getTotalCompra()));
                    System.out.println("");
                }
            }

            if (!encontrado) {
                System.out.println("Produtos(s) não encontrado(s)");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void atualizarCarrinho(ArrayList<Produto> produtos) {

        ArrayList<ProdutoCarrinho> produtosCarrinho = new ArrayList();

        boolean rodando = true;
        while (rodando) {

            try {

                System.out.println("Digite o Numero da compra");
                String idCompra = sc.nextLine();

                boolean encontrado = false;
                for (int i = 0; i < carrinhos.size(); i++) {
                    Carrinho uTemp = carrinhos.get(i);

                    if (idCompra.equals(uTemp.getIdCompra())) {
                        encontrado = true;

                        if (uTemp.isFinalizado() == true) {
                            System.out.println("Não é possivel alterar este carrinho pois a comnpra ja foi finalizada");
                            return;
                        }

                        System.out.println(" ATUALIZAR CARRINHO ");
                        System.out.println("[1] Adicionar um novo produto");
                        System.out.println("[2] Editar produto existente");
                        System.out.println("[3] Finalizar compra");
                        System.out.println("[4] Voltar");
                        System.out.print("Escolher uma opção: ");
                        String opcao = sc.nextLine();

                        System.out.print("\n\n");

                        produtosCarrinho = uTemp.getProdutosCarrinho();

                        switch (opcao) {
                            case "1":
                                //mostrar produtos
                                adicionarProdutos(produtosCarrinho, produtos);
                                uTemp.setProdutosCarrinho(produtosCarrinho);

                                BigDecimal totalDaCompra = new BigDecimal(0);

                                for (int j = 0; j < produtosCarrinho.size(); j++) {
                                    ProdutoCarrinho pCTemp = produtosCarrinho.get(j);
                                    totalDaCompra = totalDaCompra.add(pCTemp.getPreçoTotal());
                                }

                                uTemp.setTotalCompra(totalDaCompra);

                                System.out.println("Produto adicionado com sucesso");
                                rodando = false;
                                System.out.print("\n\n");
                                break;
                            case "2":
                                for (int j = 0; j < produtosCarrinho.size(); j++) {
                                    ProdutoCarrinho pCTemp = produtosCarrinho.get(j);
                                    System.out.println("\t\tId: " + j);
                                    System.out.println("\t\tCodigo: " + pCTemp.getCodigo());
                                    System.out.println("\t\tNome: " + pCTemp.getName());
                                    System.out.println("\t\tPreço Unitário: " + pCTemp.getPreço());
                                    System.out.println("\t\tQuantidade: " + pCTemp.getQuantidade());
                                    System.out.println("\t\tPreço Total: " + nf.format(pCTemp.getPreçoTotal()));
                                    System.out.println("");
                                }

                                System.out.println("Digite o ID do produto que deseja editar");
                                int produto = sc.nextInt();

                                if (produto > produtosCarrinho.size() - 1) {
                                    System.out.println("Produto não existe");
                                    return;
                                }

                                System.out.println("Digite a nova quantidade");
                                int quantidade = sc.nextInt();

                                ProdutoCarrinho pCTemp = produtosCarrinho.get(produto);

                                pCTemp.setQuantidade(quantidade);
                                pCTemp.setPreçoTotal(pCTemp.getPreço().multiply(BigDecimal.valueOf(quantidade)));

                                totalDaCompra = new BigDecimal(0);

                                for (int j = 0; j < produtosCarrinho.size(); j++) {
                                    ProdutoCarrinho pCArrayTemp = produtosCarrinho.get(j);
                                    totalDaCompra = totalDaCompra.add(pCArrayTemp.getPreçoTotal());
                                }

                                uTemp.setTotalCompra(totalDaCompra);

                                sc.nextLine();
                                System.out.println("Produto atualizado com sucesso");
                                rodando = false;
                                System.out.print("\n\n");

                                break;
                            case "3":
                                uTemp.setFinalizado(true);
                                System.out.println("Compra realizada com sucesso");
                                rodando = false;
                                System.out.print("\n\n");
                                break;
                            case "4":
                                System.out.println("voldando...");
                                rodando = false;
                                break;
                            default:
                                System.out.println("Opção inválida");
                                rodando = false;
                        }

                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Carrinho não encontrado");
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    private static void finalizarCompra() {

        System.out.println(" ====== FINALIZAR CARRINHO POR IDCOMPRA ======");

        try {

            System.out.println("Digite o Numero da compra");
            String idCompra = sc.nextLine();

            boolean encontrado = false;
            for (int i = 0; i < carrinhos.size(); i++) {
                Carrinho uTemp = carrinhos.get(i);

                if (idCompra.equals(uTemp.getIdCompra())) {
                    encontrado = true;
                    uTemp.setFinalizado(true);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Carrinho não encontrado");
            } else {
                System.out.println("Parabéns por finalizar sua compra");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void deletarCarrinho() {

        System.out.println(" ====== FINALIZAR CARRINHO POR IDCOMPRA ======");

        try {

            System.out.println("Digite o Numero da compra");
            String idCompra = sc.nextLine();

            boolean encontrado = false;
            for (int i = 0; i < carrinhos.size(); i++) {
                Carrinho uTemp = carrinhos.get(i);

                if (idCompra.equals(uTemp.getIdCompra())) {
                    encontrado = true;

                    System.out.println(" Tem certeza que deseja deleter o carrinho?");
                    System.out.println("[1] Sim");
                    System.out.println("[2] Finalziar compra com 20% de desconto");

                    System.out.print("Escolha uma opção: ");
                    String opcao = sc.nextLine();

                    System.out.print("\n\n");


                    switch (opcao) {
                        case "1":
                            carrinhos.remove(i);
                            System.out.println("Carrinho deletado com sucesso");
                            break;
                        case "2":
                            BigDecimal totalComDesconto = uTemp.getTotalCompra().multiply(BigDecimal.valueOf(1 - 0.2));
                            uTemp.setTotalCompra(totalComDesconto);
                            uTemp.setDesconto("20%");
                            uTemp.setFinalizado(true);
                            break;
                        default:
                            System.out.println("Opção incorreta");
                    }

                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Carrinho não encontrado");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String gerarNumeroCompra(int max) {
        int[] concatenador = new int[max];
        String gerador = "";

        int teste = 0;

        for (int i = 0; i < max; i++) {
            int aleatorio = (int) (Math.random() * max);
            concatenador[i] = aleatorio;
        }

        gerador = Arrays.stream(concatenador).mapToObj(String::valueOf).reduce((a, b) -> a.concat(b)).get();

        return gerador;
    }
}


public class ProdutosNoCarrinho {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList();

    public static void main() {

        boolean rodando = true;
        while (rodando) {

            System.out.println(" ==== ACRRINHO DE COMPRAS =====");
            System.out.println("[1] Gerenciar produtos");
            System.out.println("[2] carrinho de compras");
            System.out.println("[3] Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            System.out.print("\n\n");

            switch (opcao) {
                case "1":
                    ProdutoPage.main(produtos);
                    break;
                case "2":
                    CarrinhoPage.main(produtos);
                    break;
                case "3":
                    System.out.println("Não se esqueça de voltar e adquirir o seu produto");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida");

            }

        }

    }
}


