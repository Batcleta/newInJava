package JavaPaths.Services;

import JavaPaths.Models.Produto;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VendDataService {
    private Path db;
    private Path prodDb;
    private Path vendDb;
    private Scanner sc = new Scanner(System.in);

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

            boolean newProd;


            newProd = false;

            // codigoVenda & totalCompra & desconto & { codProd | nome | preço | quantidade }


            Integer codigoVenda = gerarNumeroCompra(5);
            


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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

    public void listarVendas() {
    }

    public void ListarVendas() {
    }

    public void cancelarVenda() {
    }
}
