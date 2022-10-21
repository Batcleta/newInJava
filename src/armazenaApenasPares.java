import java.util.ArrayList;
import java.util.*;

public class armazenaApenasPares {
    public static void main(String[] args) {
        retornaPares();
    }

    private static void retornaPares() {
        List<Integer> paresLista = new ArrayList<Integer>();

        int[][] matriz = new int[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                int randomNumer = (int) (Math.random() * 100 + 1);
                matriz[i][j] = randomNumer;
                System.out.print(matriz[i][j] + "\t");
                if (matriz[i][j] % 2 == 0) {
                    paresLista.add(matriz[i][j]);

                }
            }
        }

        Integer[] paresArray = new Integer[paresLista.size()];
        paresLista.toArray(paresArray);

        System.out.println("\n");

        for (int numeroPar : paresArray) {
            System.out.print(numeroPar + "\t");
        }
    }
}
