public class mainMatriz {
    public static void main(String[] args) {

        int[][] matriz1 = new int[][]{{1, 2}, {3, 4}};
        int[][] matriz2 = new int[][]{{-1, 3}, {4, 2}};

        int [][] matriz3 = new int[2][2];

        int[] p1 = new int[4];
        int[] p2 = new int[4];
        int ip1 = 0, ip2 = 0, ic = 0;


        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                p1[ip1++] = matriz1[i][j];
                p1[ip1++] = matriz2[j][i];

                p2[ip2++] = matriz1[i][j];
                p2[ip2++] = matriz2[j][1];
            }
        }

        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3[i].length; j++) {
                System.out.println(matriz3[i][j]);
            }
        }
    }
}
