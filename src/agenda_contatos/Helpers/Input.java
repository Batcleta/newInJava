package agenda_contatos.Helpers;

import agenda_contatos.Helpers.Errors.NotNullable;

import java.util.Scanner;

public class Input {
    public static String string() {
        return new Scanner(System.in).nextLine().trim();
    }

    public static String stringNotNullable (String nomeDoCampo, int tentativas){
       try {
           System.out.printf("Por favor informe o %s", nomeDoCampo);
           String input = new Scanner(System.in).nextLine().trim();

           if(input.isBlank()) throw new NotNullable()
       }catch (NotNullable ex){
           System.out.printf("msg: %s, code: %s", ex.getMessage(), ex.getCode());
       }

    }
}
