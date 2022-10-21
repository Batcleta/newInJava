import java.time.Month;
import java.time.Year;
import java.util.*;

public class exerciciosAleatorios {
    public static void main(String[] args) {
//        calcularSalario(150, 40.5);
//        nomeDoMes(10);
//        maiorOuIgual(25, 15);
//        estaEntre(9, 10, 100, false);
//        mutiplicar(5, 5);
//        repetir(7, 10);
//        simboloMais(7);
//        receberPrimeiroEUltimoNumero(new Object[]{7,15,"bilola"});
        retornaApenasNumeros(new Object[]{15, 20, "teste", "14"});

    }

    private static void retornaApenasNumeros(Object[] objects) {
        List<Integer> apenasNumeros = new ArrayList<Integer>();

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Integer) {
                apenasNumeros.add((int) objects[i]);
            }
        }

        Integer[] simpleArray = new Integer[ apenasNumeros.size() ];
        apenasNumeros.toArray( simpleArray );

        for (int numeros: simpleArray){
            System.out.println(numeros);
        }


    }


    private static void receberPrimeiroEUltimoNumero(Object[] objects) {
        System.out.println("primeiro: " + objects[0] + " - Ultimo: " + objects[objects.length - 1]);
    }

    private static void simboloMais(int i) {

        String Resultado = "";

        for (int j = 0; j < i; j++) {
            Resultado = Resultado + "+";
        }

        System.out.println(Resultado);
    }

    private static void repetir(int numeroRepetido, int numeroRepetidor) {
        int[] numeros = new int[numeroRepetidor];

        for (int i = 0; i < numeroRepetidor; i++) {
            numeros[i] = numeroRepetido;
            System.out.println();
        }
        ;

        for (int numero : numeros) {
            System.out.print(numero + "\t");
        }
    }

    private static void mutiplicar(int operando1, int operando2) {
        int resultado = 0;
        // multiplicar sem usar o operador *
        if (operando1 > 0 && operando2 > 0) {

            for (int i = 0; i < operando1; i++) {
                resultado = resultado + operando2;
            }
            System.out.println(resultado);

        } else {
            System.out.println("Favor inserir um numero maior do que zero");
        }
    }

    private static void estaEntre(int numero, int minimo, int maximo, boolean inclusivo) {
        boolean resultado;
        if (!inclusivo) {
            resultado = numero > minimo && numero < maximo;
        } else {
            resultado = numero >= minimo && numero <= maximo;
        }
        System.out.println(resultado);
    }

    private static void maiorOuIgual(int i, int j) {
        System.out.println(i >= j ? true : false);
    }

    private static void nomeDoMes(int month) {
        System.out.println(Month.of(month));
    }

    private static void calcularSalario(int horasTrabalhadas, double valorPorHora) {
        System.out.println((double) horasTrabalhadas * valorPorHora);
    }
}
