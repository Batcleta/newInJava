package agenda_contatos.Views;

import agenda_contatos.Enums.TipoContato;
import agenda_contatos.Enums.TipoEndereco;
import agenda_contatos.Enums.TipoTelefone;
import agenda_contatos.Helpers.Errors.InvalidParams;
import agenda_contatos.Helpers.Errors.NotNullable;
import agenda_contatos.Helpers.Input;
import agenda_contatos.Models.Contato;
import agenda_contatos.Models.Endereco;
import agenda_contatos.Models.Telefone;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    static Input input = new Input();

    public static void main(List<Contato> contatos) {
        System.out.println("===== Bem vindo!! =====");

        boolean isWorking = true;

        while (isWorking) {
            System.out.println("");
            System.out.println("[1] Cadastrar contato");
            System.out.println("[2] Listar contatos");
            System.out.println("[3] Listar contato por nome");
            System.out.println("[4] Editar contato");
            System.out.println("[5] Excluir contato");
            System.out.println("[0] Sair");
            System.out.println("");

            System.out.print("Escolha uma opção: ");

            switch (input.string()) {
                case "1":
                    cadastrarContato();
                    break;
                case "2":
                    listarContatos();
                    break;
                case "3":
                    listarContatoPorNome();

                    break;
                case "4":
                    editarContato();
                    break;
                case "5":
                    excluirContato();
                    break;

                case "0":
                    System.out.println("Obrigado, volte sempre");
                    isWorking = false;
                    break;
                default:
                    System.out.print("==== Opção inválida ====\n");
            }
        }
    }

    private static void excluirContato() {

        boolean isInvalid;
        do {
            isInvalid = false;
            try {

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;
            }
        } while (isInvalid);
    }

    private static void editarContato() {
        boolean isInvalid;
        do {
            isInvalid = false;
            try {

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;
            }
        } while (isInvalid);
    }

    private static void listarContatoPorNome() {
        boolean isInvalid;
        do {
            isInvalid = false;
            try {
                System.out.println("Digite o nome do contato");
                String nome = input.string();

                if (nome == null) throw new NotNullable(nome, "é um campo obrigatório");
                new agenda_contatos.Controllers.Agenda().pesquisarPorNome(nome);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;
            }
        } while (isInvalid);
    }

    private static void listarContatos() {
        boolean isInvalid;
        int requestPool = 0;
        do {
            isInvalid = false;

            if (requestPool >= 3) {
                break;
            }

            try {
                List<Contato> contatosEncontrados = new agenda_contatos.Controllers.Agenda().listarTodos(1, 20);

                for (int i = 0; i < contatosEncontrados.size(); i++) {
                    //apenas nome para teste
                    System.out.println(contatosEncontrados.get(i).getNome());
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                requestPool += 1;
                isInvalid = true;
            }
        } while (isInvalid);
    }

    private static void cadastrarContato() {

        List<Telefone> telefones = new ArrayList<>();
        List<Endereco> enderecos = new ArrayList<>();
        System.out.println(" ====== CADASTRO DE CONTATO ======");

        boolean isInvalid;
        do {
            isInvalid = false;
            try {

                System.out.println("Informe o tipo do contato");

                for (TipoContato tipo : TipoContato.values()) {
                    System.out.printf("-> [%s] %s\n", tipo.ordinal(), tipo.name());
                }

                System.out.print("Escolha uma opção: ");
                String tipoOp = input.string();

                System.out.print("\n");

                boolean validType = false;
                TipoContato tipoContato = TipoContato.Pessoal;

                for (TipoContato tipo : TipoContato.values()) {
                    if (tipoOp.equals(Integer.toString(tipo.ordinal()))) {
                        tipoContato = tipo;
                        validType = true;
                    }
                }

                if (!validType) {
                    System.out.print("Por favor informe informe apenas o numero das opções abaixo\n");
                    isInvalid = true;
                    continue;
                }

                System.out.print("Digite seu nome: ");
                String name = input.string();

                if (name == null) {
                    System.out.print("O campo nome nao pode ser vazio");
                    isInvalid = true;
                    continue;
                }

                if (name.length() < 1) {
                    System.out.print("Por favor informe um nome válido");
                    isInvalid = true;
                    continue;
                }

                System.out.print("Digite seu sobrenome: ");
                String lastName = input.string();

                System.out.println("Deseja cadastrar um endereço?");
                System.out.println("[1] Sim");
                System.out.println("[0] Não");
                System.out.print("Escolha uma opção: ");

                switch (input.string()) {
                    case "1":
                        cadastrarEndereco(enderecos);
                        break;
                    case "0":
                        break;
                    default:
                        System.out.print("==== Opção inválida ====\n");
                }

                System.out.println("Deseja cadastrar um telefone?");
                System.out.println("[1] Sim");
                System.out.println("[0] Não");
                System.out.print("Escolha uma opção: ");

                switch (input.string()) {
                    case "1":
                        cadastrarTelefones(telefones);
                        break;
                    case "0":
                        break;
                    default:
                        System.out.print("==== Opção inválida ====\n");
                }


                Contato contato = new Contato(tipoContato, name, lastName, enderecos, telefones);
                new agenda_contatos.Controllers.Agenda().cadastrar(contato);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;
            }
        } while (isInvalid);
    }

    private static void cadastrarTelefones(List<Telefone> telefones) {
        boolean isInvalid;
        do {
            isInvalid = false;
            try {

                System.out.println("Informe o tipo do contato telefonico");

                for (TipoTelefone tipo : TipoTelefone.values()) {
                    System.out.printf("-> [%s] %s\n", tipo.ordinal(), tipo.name());
                }

                System.out.print("Escolha uma opção: ");
                String tipoOp = input.string();

                if (tipoOp == null) throw new NotNullable(tipoOp, "é um campo obrigatório");

                System.out.print("\n");

                boolean validType = false;
                TipoTelefone tipoTelefone = TipoTelefone.Celular;

                for (TipoTelefone tipo : TipoTelefone.values()) {
                    if (tipoOp.equals(Integer.toString(tipo.ordinal()))) {
                        tipoTelefone = tipo;
                        validType = true;
                    }
                }
                //Verificar mudança no erro InvalidParams
                if (!validType) {
                    System.out.print("Por favor informe informe apenas o numero das opções abaixo\n");
                    isInvalid = true;
                    continue;
                }

                System.out.println("Cadatro rápido ou completo?");
                System.out.println("[1] Rápido");
                System.out.println("[2] Completo");
                System.out.print("Escolha uma opção: ");
                String cadastroOpr = input.string();

                System.out.println("Informe o DDD sem o 0");
                String ddd = input.string();

                if (ddd == null) throw new NotNullable(ddd, "é um campo obrigatório");

                System.out.println("Informe o numero do telefone");
                String numero = input.string();

                if (numero == null) throw new NotNullable(numero, "é um campo obrigatório");

                System.out.println("Informe o DDD sem o 0");
                String contato = input.string();

                if (contato == null) throw new NotNullable(contato, "é um campo obrigatório");


                switch (cadastroOpr) {
                    case "1":
                        Telefone contatoTelefonicoSimples = new Telefone(tipoTelefone, "", ddd, numero, "", contato);
                        telefones.add(contatoTelefonicoSimples);

                        System.out.println("Deseja cadastrar outro contato telefonico?");
                        System.out.println("[1] Sim");
                        System.out.println("[0] Não");
                        System.out.print("Escolha uma opção: ");

                        switch (input.string()) {
                            case "1":
                                isInvalid = true;
                                break;
                            case "0":
                                break;
                            default:
                                System.out.print("==== Opção inválida ====\n");
                        }
                        break;
                    case "2":
                        System.out.println("Informe o ddi do país ex: +55");
                        String ddi = input.string();

                        System.out.println("Informe um ramal");
                        String ramal = input.string();

                        if (ramal != null && ddi == null) throw new NotNullable(ddi, "é um campo obrigatório");

                        Telefone contatoTelefonicoCompleto = new Telefone(tipoTelefone, ddi, ddd, numero, ramal, contato);
                        telefones.add(contatoTelefonicoCompleto);

                        System.out.println("Deseja cadastrar outro contato telefonico?");
                        System.out.println("[1] Sim");
                        System.out.println("[0] Não");
                        System.out.print("Escolha uma opção: ");

                        switch (input.string()) {
                            case "1":
                                isInvalid = true;
                                break;
                            case "0":
                                break;
                            default:
                                System.out.print("==== Opção inválida ====\n");
                        }
                        break;
                    default:
                        System.out.print("==== Opção inválida ====\n");
                }
            } catch (NotNullable ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;
            }
        } while (isInvalid);
    }

    private static void cadastrarEndereco(List<Endereco> enderecos) {

        boolean isInvalid;
        do {
            isInvalid = false;
            try {

                System.out.println("Informe o tipo do endereço");

                for (TipoEndereco tipo : TipoEndereco.values()) {
                    System.out.printf("-> [%s] %s\n", tipo.ordinal(), tipo.name());
                }

                System.out.print("Escolha uma opção: ");
                String tipoOp = input.string();

                if (tipoOp == null) throw new NotNullable(tipoOp, "é um campo obrigatório");

                System.out.print("\n");

                boolean validType = false;
                TipoEndereco tipoEndereco = TipoEndereco.Virtual;

                for (TipoEndereco tipo : TipoEndereco.values()) {
                    if (tipoOp.equals(Integer.toString(tipo.ordinal()))) {
                        tipoEndereco = tipo;
                        validType = true;
                    }
                }
                //Verificar mudança no erro InvalidParams
                if (!validType) {
                    System.out.print("Por favor informe informe apenas o numero das opções abaixo\n");
                    isInvalid = true;
                    continue;
                }

                if (tipoEndereco.equals(TipoEndereco.Virtual)) {
                    System.out.println("Digite seu email");
                    String email = input.string();

                    if (email == null) throw new NotNullable(email, "é um campo obrigatório");
                    if (!email.matches("^(.+)@(\\S+)$")) throw new InvalidParams(email);

                    Endereco enderecoVirtual = new Endereco(tipoEndereco, email);
                    enderecos.add(enderecoVirtual);

                    System.out.println("Deseja cadastrar outro endereço?");
                    System.out.println("[1] Sim");
                    System.out.println("[0] Não");
                    System.out.print("Escolha uma opção: ");

                    switch (input.string()) {
                        case "1":
                            isInvalid = true;
                            break;
                        case "0":
                            break;
                        default:
                            System.out.print("==== Opção inválida ====\n");
                    }
                    System.out.println("");
                    continue;
                }

                System.out.println("Cadatro rápido ou completo?");
                System.out.println("[1] Rápido");
                System.out.println("[2] Completo");
                System.out.print("Escolha uma opção: ");
                String cadastroOpr = input.string();

                System.out.println("Informe seu logradouro");
                String logradouro = input.string();

                System.out.println("Informe o numero do imóvel");
                String numero = input.string();

                if (logradouro == null || numero == null) {
                    throw new NotNullable(logradouro + " e " + numero, "são campos obrigatórios");
                }

                System.out.println("Informe um complemento(opcional)");
                String complemento = input.string();

                switch (cadastroOpr) {
                    case "1":
                        Endereco enderecoSimples = new Endereco(tipoEndereco, logradouro, numero, complemento);
                        enderecos.add(enderecoSimples);

                        System.out.println("Deseja cadastrar outro endereço?");
                        System.out.println("[1] Sim");
                        System.out.println("[0] Não");
                        System.out.print("Escolha uma opção: ");

                        switch (input.string()) {
                            case "1":
                                isInvalid = true;
                                break;
                            case "0":
                                break;
                            default:
                                System.out.print("==== Opção inválida ====\n");
                        }
                        break;
                    case "2":
                        System.out.println("Informe o bairro");
                        String bairro = input.string();

                        if (bairro == null) throw new NotNullable(bairro, "é um campo obrigatório");

                        System.out.println("Informe a cidade");
                        String cidade = input.string();

                        if (cidade == null) throw new NotNullable(cidade, "é um campo obrigatório");

                        System.out.println("Informe o uf");
                        String uf = input.string();

                        if (uf == null) throw new NotNullable(uf, "é um campo obrigatório");

                        System.out.println("Informe o cep");
                        String cep = input.string();

                        if (cep == null) throw new NotNullable(cep, "é um campo obrigatório");

                        System.out.println("Informe o pais");
                        String pais = input.string();

                        if (pais == null) throw new NotNullable(pais, "é um campo obrigatório");

                        Endereco enderecoCompleto = new Endereco(tipoEndereco, logradouro, numero, complemento, bairro, cidade, uf, cep, pais);
                        enderecos.add(enderecoCompleto);

                        System.out.println("Deseja cadastrar outro endereço?");
                        System.out.println("[1] Sim");
                        System.out.println("[0] Não");
                        System.out.print("Escolha uma opção: ");

                        switch (input.string()) {
                            case "1":
                                isInvalid = true;
                                break;
                            case "0":
                                break;
                            default:
                                System.out.print("==== Opção inválida ====\n");
                        }
                        break;
                    default:
                        System.out.print("==== Opção inválida ====\n");
                }
            } catch (InvalidParams ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;

            } catch (NotNullable ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                isInvalid = true;

            }
        } while (isInvalid);
    }
}
