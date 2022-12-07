package agenda_contatos.Helpers.Errors;

public class AlreadyExists extends Exception {
    public AlreadyExists(String param, String modelName) {
        super(param + " already exists in " + modelName);
    }
}
