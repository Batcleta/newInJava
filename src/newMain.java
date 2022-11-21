public class newMain {
    public static void main(String[] args) {
        String email = "emai.email@email.com";

//        boolean verificar = arrobaRepetido(email);
        boolean verificar = email.chars().filter(ch -> ch == '@').count() > 1? true: false;

        System.out.println(verificar);
    }

}
