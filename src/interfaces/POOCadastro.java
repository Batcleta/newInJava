package interfaces;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Endereço {
    private String tipo_endereço;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private String pais;

    public Endereço(String tipo_endereço, String cep, String logradouro, String numero, String complemento, String bairro, String municipio, String uf, String pais) {
        this.tipo_endereço = tipo_endereço;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
        this.pais = pais;
    }

    public String getTipo_endereço() {
        return tipo_endereço;
    }

    public void setTipo_endereço(String tipo_endereço) {
        this.tipo_endereço = tipo_endereço;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
class Contato {
    private String nome_contato;
    private enum tipos_contato {celular, telefone_fixo};

    private tipos_contato tipo_contato;
    private String ddi;
    private String ddd;
    private String numero_contato;

    public Contato(String nome_contato, tipos_contato tipo_contato, String ddi, String ddd, String numero_contato) {
        this.nome_contato = nome_contato;
        this.tipo_contato = tipo_contato;
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero_contato = numero_contato;
    }

    public String getNome_contato() {
        return nome_contato;
    }

    public void setNome_contato(String nome_contato) {
        this.nome_contato = nome_contato;
    }

    public tipos_contato getTipo_contato() {
        return tipo_contato;
    }

    public void setTipo_contato(tipos_contato tipo_contato) {
        this.tipo_contato = tipo_contato;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero_contato() {
        return numero_contato;
    }

    public void setNumero_contato(String numero_contato) {
        this.numero_contato = numero_contato;
    }
}
abstract class Documento {
    List<String> documentos;
}

class PessoaFisica extends  Documento {
    private String rg;
    private String cpf;
}

class PessoaJuridica extends  Documento{
    private String cnpj;
    private String ie;
    private String im;
}
class Cadastro {

    private String nome_juridico;
    private Documento doc_p_fisica;
    private String sexo;
    private enum tipos_contato {pessoa_fisica, pessoa_juridica};
    private enum status_cadastro {ativo ,inativo, pendente, bloqueado};

    private tipos_contato tipo_contato;
    private status_cadastro status;

    private List<Endereço> enderecos = new ArrayList();
    private List<Contato> contatos = new ArrayList();
    private List<String> emails = new ArrayList();

    public Cadastro(String nome_juridico, PessoaFisica doc_p_fisica, PessoaJuridica doc_p_juridica, String sexo, tipos_contato tipo_contato, status_cadastro status, List<Endereço> enderecos, List<Contato> contatos, List<String> emails) {
        this.nome_juridico = nome_juridico;
        this.doc_p_fisica = doc_p_fisica;
//        this.doc_p_juridica = doc_p_juridica;
        this.sexo = sexo;
        this.tipo_contato = tipo_contato;
        this.status = status;
        this.enderecos = enderecos;
        this.contatos = contatos;
        this.emails = emails;
    }

    public String getNome_juridico() {
        return nome_juridico;
    }

    public void setNome_juridico(String nome_juridico) {
        this.nome_juridico = nome_juridico;
    }

//    public PessoaFisica getDoc_p_fisica() {
//        return doc_p_fisica;
//    }

    public void setDoc_p_fisica(PessoaFisica doc_p_fisica) {
        this.doc_p_fisica = doc_p_fisica;
    }

//    public PessoaJuridica getDoc_p_juridica() {
//        return doc_p_juridica;
//    }

//    public void setDoc_p_juridica(PessoaJuridica doc_p_juridica) {
//        this.doc_p_juridica = doc_p_juridica;
//    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public tipos_contato getTipo_contato() {
        return tipo_contato;
    }

    public void setTipo_contato(tipos_contato tipo_contato) {
        this.tipo_contato = tipo_contato;
    }

    public status_cadastro getStatus() {
        return status;
    }

    public void setStatus(status_cadastro status) {
        this.status = status;
    }

    public List<Endereço> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereço> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
class CadastroDataService implements ICadastro{
    private static Path db;

    @Override
    public void cadastrarContato(List<Cadastro> cadastro) {
        List<Endereço> endereços = new ArrayList();
        List<Contato> contatos = new ArrayList();
        List<String> emails = new ArrayList();

//        Cadastro novoCadastro = new Cadastro();
//        contatos.add(novoCadastro);

    }

    @Override
    public void listarCOntato() {

    }
}

public class POOCadastro {
    private static Scanner sc = new Scanner(System.in);
    private static List<Cadastro> cadastro = new ArrayList();


    public static void main(String[] args) {

        System.out.print("== BEM VINDO AO BILOLA PDV == \n\n");

        boolean rodando = true;
        while (rodando) {

            System.out.println("[1] Cadastro de contato");
            System.out.println("[2] Listar contatos");
            System.out.println("[3] Sair");
            System.out.print("Escolha uma opção: ");

            String opcao = sc.nextLine();
            System.out.print("\n\n");

            switch (opcao) {
                case "1":
                    new CadastroDataService().cadastrarContato(cadastro);
                    break;
                case "2":

                    break;
                case "3":
                    System.out.println("---> Obrigado por utilizar o Bilola Cadastros");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida");
                    System.out.print("\n\n");
            }

        }

    }
}