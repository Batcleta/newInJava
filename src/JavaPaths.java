import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


class ProdutoFile {
    private String codigo;
    private String nome;
    private String preco;
    private String Quantidade;

    public ProdutoFile(String codigo, String nome, String preco, String quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        Quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String quantidade) {
        Quantidade = quantidade;
    }
}

class DataService {
    private Path db;

    public DataService(Path db) {
        this.db = db;
    }

    public List<String> lerArquivo() {
        List<String> Produtos = List.of("");

        try {
            Produtos = Files.readAllLines(db);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Produtos;
    }

    public void escreverArquivo(List<String> data) {

        data.add("Etiqueta térmica 80x80&200&999");
        data.add("Etiqueta térmica 80x60&200&999");
        try {
            Files.write(db, data);
            System.out.println("Dados gravados com sucesso");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

public class JavaPaths {
    static ArrayList<ProdutoFile> Produtos = new ArrayList();

    public static void main(String[] args) {
        boolean rodando = true;
        Path db = criarDataBase();
        DataService data = new DataService(db);

        for (String produtos : data.lerArquivo()) {
            String[] produto = produtos.split("&");

            ProdutoFile novoProduto = new ProdutoFile("0001", produto[0], produto[1], produto[2]);
            Produtos.add(novoProduto);
        }

        for (int i = 0; i < Produtos.size(); i++) {
            ProdutoFile pTemp = Produtos.get(i);
            System.out.println("Código: " + pTemp.getCodigo() + " - Produto: " + pTemp.getNome() + " - Preço: " + pTemp.getPreco() + " - Quantidade: " + pTemp.getQuantidade());
        }
//        DataService escrever = new DataService(db);
//        escrever.escreverArquivo(data.lerArquivo());


    }

    private static Path criarDataBase() {
        Path createdFile = Path.of("");
        try {
            Path diretorio = criarDiretorio();
            createdFile = Paths.get(diretorio + "\\DataBase.txt");

            if (Files.exists(createdFile)) {
//                System.out.println("Arquivo ja existe");
            } else {
                createdFile = Files.createFile(createdFile);
                System.out.println("Arquivo criado em: " + createdFile.toString());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return createdFile;
    }

    private static Path criarDiretorio() {
        Path createdPath = Paths.get("C:\\Users\\Usuario\\IdeaProjects\\untitled1\\src\\db");
        try {

            if (Files.exists(createdPath)) {
//                System.out.println("Diretório ja existe");
            } else {
                createdPath = Files.createDirectory(createdPath);
                System.out.println("Diretório criado em: " + createdPath.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return createdPath;
    }
}
