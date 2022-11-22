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

    public List<ProdutoFile> lerArquivo() {
        List<ProdutoFile> Produtos = null;

        try {
            List<String> data = Files.readAllLines(db);

            for (int i = 0; i < data.size(); i++) {
                String[] dataTemp = data.get(i).split("&");
                ProdutoFile produtoFile = new ProdutoFile(dataTemp[0], dataTemp[1], dataTemp[2], dataTemp[3]);
            }

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

    public static void main(String[] args) {
        boolean rodando = true;
        Path db = criarDataBase();
        DataService data = new DataService(db);

        for (String produtos : data.lerArquivo()) {
            System.out.println(produtos);

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
