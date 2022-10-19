import java.util.Scanner;

public class mathOper {
    private static int operand1;
    private static int operand2;
    private static char operator;

    private static String MSG_SOMA = "%d + %d é igual a: %d";
    private static String MSG_SUBTRACAO = "%d - %d é igual a: %d";
    private static String MSG_DIVISAO = "%d / %d é igual a: %d";
    private static String MSG_MULTIPLICACAO = "%d * %d é igual a: %d";

    public static void main(String[] args) {
        getMathParams();
        doTheMagicCalc();
    }

    private static void doTheMagicCalc() {

        switch (operator) {
            case '+':
                System.out.printf(MSG_SOMA, operand1, operand2, operand1 + operand2);
                ;
                break;
            case '-':
                System.out.printf(MSG_SUBTRACAO, operand1, operand2, operand1 - operand2);
                break;
            case '*':
                System.out.printf(MSG_MULTIPLICACAO, operand1, operand2, operand1 * operand2);
                break;
            case '/':
                System.out.printf(MSG_DIVISAO, operand1, operand2, operand1 / operand2);
                break;
            default:
                System.out.println("Operador não encontrado");
        }
    }

    private static void getMathParams() {
        boolean isInvalid;
        do {
            isInvalid = false;
            Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Informe um operador (+-/*)");
                char operatorValue = scanner.next().charAt(0);

                System.out.println("Informe o primeiro valor da operação");
                int operand1Value = scanner.nextInt();

                System.out.println("Informe o segundo valor da operação");
                int operand2Value = scanner.nextInt();

                Boolean condition = operatorValue == '+' || operatorValue == '-' || operatorValue == '*' || operatorValue == '/';

                if (condition) {
                    operator = operatorValue;
                    operand1 = operand1Value;
                    operand2 = operand2Value;
                    return;
                }

                isInvalid = true;
                System.out.println("ERRO - " + operatorValue + " não é um operador válido");


            } catch (Exception ex) {
                isInvalid = true;
                System.out.println("ERRO - Valor digitado nao e um numero inteiro!");
            }

        } while (isInvalid);
    }
}
