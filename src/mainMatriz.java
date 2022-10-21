public class mainMatriz {
    public static void main(String[] args) {

        int[][] matriz1 = new int[][]{{1, 2}, {3, 4}};
        int[][] matriz2 = new int[][]{{-1, 3}, {4, 2}};

        int [][] matriz3 = new int[2][2];


        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                matriz3[i][j] = matriz1[i][j];
                matriz3[i][j++] = matriz1[i][j++];
            }
        }

        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3[i].length; j++) {
                System.out.println(matriz3[i][j]);
            }
        }
    }
}
