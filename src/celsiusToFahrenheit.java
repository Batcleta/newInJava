import java.util.Scanner;

public class celsiusToFahrenheit {
    private static int[] arrayGraus;

    public static void main(String[] args) {

        getCelsiusDegree();
        convertToFahrenheit(arrayGraus);
    }

    private static void getCelsiusDegree() {
        // checar se as temperaturas fornecidas são válidas e caso não sejam, pedi-las novamente
        boolean isInvalid;
        do {
            isInvalid = false;
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Informe a primeiro temperatura em celsius");
                int celsius1 = scanner.nextInt();
                System.out.println("Informe uma segunda temperatura em celsius");
                int celsius2 = scanner.nextInt();

                //checar se as temperaturas informadas são distintas
                if (celsius1 != celsius2) {
                    arrayGraus = new int[]{celsius1, celsius2};
                    return;
                }
                isInvalid = true;
                System.out.println("ERRO - Por favor informar duas temperaturas distintas ");

            } catch (Exception ex) {
                isInvalid = true;
                System.out.println("ERRO - Valor digitado nao e um numero inteiro!");
            }

        } while (isInvalid);
    }

    private static void convertToFahrenheit(int... celsius) {
        final double fator1 = (double) 9/5;
        final int fator2 = 32;

        if (celsius == null || celsius.length == 0) {
            System.out.println("Por favor informe um valor para celsius");
            getCelsiusDegree();
            return;
        }

        for (int grau : celsius) {
            System.out.println((int) (grau * fator1) + fator2);
        }

    }
}
