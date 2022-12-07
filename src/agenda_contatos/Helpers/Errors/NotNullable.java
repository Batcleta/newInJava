package agenda_contatos.Helpers.Errors;

public class NotNullable extends Exception {
    public NotNullable(String param, String message) {
        super(param + " " + message + " Por favor, preencha corretamente");
    }
}
