import java.util.Scanner;

public class Main {

    private static int numero1;
    private static int numero2;
    private static int ammount;

    public static void main(String[] args) {

        ammount = args.length;

        if (ammount >= 0 && ammount <= 2) {
            try {

                numero1 = Integer.parseInt(args[0]);
                numero2 = Integer.parseInt(args[1]);

                if (ammount == 1) {
                    getNumbers();
                    return;
                }

                somarNumeros(numero1, numero2);

            } catch (Exception ex) {
                getNumbers();
            }


        } else {
            System.out.println("Quantidade inválida, adicione apenas dois números");
            getNumbers();
        }
    }

    private static void getNumbers() {
        boolean isInvalid;
        do {
            isInvalid = false;
            Scanner scanner = new Scanner(System.in);

            try {
                if (ammount == 0 || ammount >=3) {
                    System.out.println("Informe o primeiro valor da operação");
                    int operand1Value = scanner.nextInt();

                    System.out.println("Informe o segundo valor da operação");
                    int operand2Value = scanner.nextInt();

                    numero1 = operand1Value;
                    numero2 = operand2Value;
                    isInvalid = false;

                    somarNumeros(numero1, numero2);
                } else {
                    System.out.println("Informe o segundo valor da operação");
                    int operand2Value = scanner.nextInt();

                    numero2 = operand2Value;
                    isInvalid = false;

                    somarNumeros(numero1, numero2);
                }
            } catch (Exception ex) {
                isInvalid = true;
                System.out.println("ERRO - Valor digitado nao e um numero inteiro!");
            }

        } while (isInvalid);
    }

    private static void somarNumeros(int numero1, int numero2) {
        System.out.printf("%d + %d = %d", numero1, numero2, numero1 + numero2);
    }

}