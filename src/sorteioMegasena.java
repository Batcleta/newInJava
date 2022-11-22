import java.util.Scanner;
import java.util.stream.Stream;

public class sorteioMegasena {

    private static boolean bilheteRegistrado = false;
    private static int[] bilhete;

    public static void main(String[] args) {

        marcarCartela();

//        testando abordagem de retorno direto de valores
//        ao invés de passar o valor para uma variável de classe

        int[] numerosSorteados = sorteio();

        // checando se o bilhete foi registrado na loteria
        // caso o bilhete tenha sito registrado, checar se o meliante ganhou

        int compararResultado = compararNumeros(bilhete, numerosSorteados);

        System.out.print("Seu Bilhete:" + "\t");
        for (int numero : bilhete) {
            System.out.print(numero + "\t");
        }
        System.out.println(bilheteRegistrado == true ? "registrado" : "Não registrado");

        System.out.print("Numeros sorteados:" + "\t");
        for (int numero : numerosSorteados) {
            System.out.print(numero + "\t");
        }

        System.out.println(" ");

        System.out.println("Você acertou: " + compararResultado + " numeros");

        if (compararResultado != 6){
            System.out.println("Infelizmente não foi dessa vez");
            return;
        }

        if (bilheteRegistrado == true) {
            System.out.println("Voce Ganhou!!!! Retire seu prêmio em uma de nossas agências");
        } else {
            System.out.println("Poxa, você esqueceu de registrar o bilhete, perdeu playboy");
        }


    }

    private static int compararNumeros(int[] bilhete, int[] sorteio) {
        int resultado = 0;

        // comparar arrays e retornar a quantidade de numeros iguais

        for (int i = 0; i < sorteio.length; i++) {
            for (int j = 0; j < sorteio.length; j++) {
                if (sorteio[i] == bilhete[j]) {
                    resultado++;
                }
            }
        }

        return resultado;
    }

    private static void marcarCartela() {
        int[] numeros = new int[6];
        Scanner scanner = new Scanner(System.in);
        boolean isInvalid;

        do {
            isInvalid = false;

            try {
                System.out.println("Informe 6 números distintos entre 1 e 60 separados com espaço");
                String numerosCartela = scanner.nextLine();

                String[] numerosString = numerosCartela.split(" ");

                if (numerosString.length != 6) {
                    System.out.println(numerosString.length + " números informados. Por favor informe 6 números. Lembre-se que devem estar separados com espaço");
                    isInvalid = true;
                    continue;
                }

                numeros = Stream.of(numerosString).mapToInt(Integer::parseInt).toArray();

                for (int i = 0; i < numeros.length; i++) {
                    if (numeros[i] <= 0 || numeros[i] > 60) {
                        isInvalid = true;
                        System.out.println("Os números devem estar entre 1 e 60");
                        break;
                    }

                    for (int j = i + 1; j < numeros.length; j++) {
                        if (numeros[i] == numeros[j]) {
                            isInvalid = true;
                            System.out.println("Os números devem ser distintos");
                            break;
                        }
                    }
                }

            } catch (Exception ex) {
                System.out.println("deu ruim" + ex);
            }
            continue;
        } while (isInvalid);

        RegistrarBilhete(numeros);
    }

    private static void RegistrarBilhete(int... numeros) {
        if (numeros.length < 3) {
            System.out.println("Para registrar o bilhere, serão necesários 6 números");
            marcarCartela();
            return;
        }

        boolean isInvalid;

        Scanner scanner = new Scanner(System.in);


        do {
            isInvalid = false;

            try {
                System.out.println("Deseja registrar seu bilhete? (apenas sim ou não)");
                String registro = scanner.next();

                if (registro.equalsIgnoreCase("sim")) {
                    bilhete = numeros;
                    bilheteRegistrado = true;
                    return;
                } else if (registro.equalsIgnoreCase("nao") || registro.equalsIgnoreCase("não")) {
                    System.out.println("Gostaria de informar uma nova sequencia?");
                    String informarNova = scanner.next();

                    if (informarNova.equalsIgnoreCase("sim")) {
                        marcarCartela();
                        return;
                    } else if (registro.equalsIgnoreCase("nao") || registro.equalsIgnoreCase("não")) {
                        bilhete = numeros;
                        bilheteRegistrado = false;
                        return;
                    } else {
                        isInvalid = true;
                        System.out.println("Por favor responda apenas com sim ou não");
                    }
                } else {
                    isInvalid = true;
                    System.out.println("Por favor responda apenas com sim ou não");
                }


            } catch (Exception ex) {
                isInvalid = true;
                System.out.println(" Por favor informe apenas sim ou não");
            }

        } while (isInvalid);


    }

    private static int[] sorteio() {
        int[] numeros = new int[6];

        for (int i = 0; i < numeros.length; i++) {
            //atribui o numero aleatório ao indice i do array
            numeros[i] = novoAleatorio(61);

            // caso seja passado 0 ou um numero negativo, reseta o index do loop e atribui um novo número
            if (numeros[i] == 0) {
                i--;
                continue;
            }

            // Verifica se o numero é repetido em outro loop
            for (int j = 0; j < i; j++) {
                //se o numero atribuido for igual a um numero existente
                if (numeros[i] == numeros[j]) {
                    //reduz o indice do loop que irá reatribuir o valor ao reiniciar o loop
                    i--;
                    break;
                }
            }
        }

        return numeros;
    }

    private static int novoAleatorio(int max) {
        int aleatorio = (int) (Math.random() * max);
        int[] bilola;
        int gerador = 0;

        for (int i = 0; i < max; i++) {


        }

        return gerador;
    }


}

