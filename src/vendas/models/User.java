package vendas.models;

public class User {
    private String Registration;
    private String Name;
    private String Email;
    private String Login;
    private String Password;
    private String Authorization;

    public void funcionario(String registration, String name, String email, String login, String password, String authorization) {
        this.Registration = registration;
        this.Name = name;
        this.Email = email;
        this.Login = login;
        this.Password = password;
        this.Authorization = authorization;
    }

    public String getRegistration() {
        return Registration;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public String getAuthorization() {
        return Authorization;
    }
}
