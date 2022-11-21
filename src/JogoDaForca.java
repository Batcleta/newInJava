import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        String palavraCHave = "Bicicleta";
        String letrasUsadas = "";
        String palavraAdivinhada = "";
        int MAX_TENTATIVAS = 10;

        for (int i = 0; i < palavraCHave.length(); i++) {
            palavraAdivinhada += "_ ";

            for (int tentativas = 0; ; tentativas++) {
                if (tentativas == MAX_TENTATIVAS) {
                    System.out.println("Parabéns, você morreu! A palavra era: " + palavraCHave);
                    System.exit(0);
                }
                System.out.println("");
                System.out.printf("Rodada: %d. Até agora adivinhada: %s Qual a sua próxila letra?", tentativas + 1,
                        palavraAdivinhada);

                Character letraTentada = new Scanner(System.in).next().charAt(0);

                if (letrasUsadas.indexOf(letraTentada) >= 0) {
                    System.out.printf("Você já tentou a letra %c.%n", letraTentada);
                } else {
                    letrasUsadas += letraTentada;


                    if (palavraCHave.indexOf(letraTentada) >= 0) {
                        palavraAdivinhada = "";

                        for (int j = 0; j < palavraCHave.length(); j++) {
                            palavraAdivinhada += letrasUsadas.indexOf(palavraCHave.charAt(j)) >= 0 ? palavraCHave.charAt(j) + " " : "_ ";
                        }


                        if (palavraAdivinhada.contains("_")) {
                            System.out.printf("Muito bom! %s existe na palavra. Ainda restam letras escondidas", letraTentada);
                        } else {
                            System.out.printf("Parabéns! Vocçe adivinhou: '%s", palavraAdivinhada.trim());
                            System.exit(0);
                        }
                    } else {
                        System.out.printf("Infelizmente a letra %c não existe na palavra.", letraTentada);
                    }
                }


            }


        }


        System.out.println(palavraAdivinhada);

    }
}
