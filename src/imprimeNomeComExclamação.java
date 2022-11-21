import java.util.Scanner;

public class imprimeNomeComExclamação {
    public static void main(String[] args) {
        String nome = pegarNomeDigitado();

        String[] arrayNomes = nome.split(" ");
        for (int i = 0; i < arrayNomes.length; i++) {
            arrayNomes[i] = "!" + arrayNomes[i];
        }
        String nomeModificado = String.join(" ", arrayNomes);
        System.out.println(nomeModificado);
    }

    private static String pegarNomeDigitado() {
        String nome = "";
        Scanner sc = new Scanner(System.in);

        boolean isInvalid;

        do {
            isInvalid = false;

            try {
                System.out.println("Por favor informe su nome completo");
                nome = sc.nextLine();
            } catch (Exception ex) {
                isInvalid = true;
                System.out.println("ERRO - Valor digitado nao e um numero inteiro!");
            }

        } while (isInvalid);

        return nome;
    }
}
