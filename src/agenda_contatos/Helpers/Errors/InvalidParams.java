package agenda_contatos.Helpers.Errors;

public class InvalidParams extends Exception{
    public InvalidParams(String param) {
        super(param + " é inválido, por favor preencha corretamente ");
    }
}
