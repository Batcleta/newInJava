import java.math.BigDecimal;
import java.text.NumberFormat;

public class Balanço {
    public static void main(String[] args) {
        int Janeiro = 10000;
        int Fevereiro = 17000;
        int Março = 23000;

        gastosDoTrimestre(Janeiro, Fevereiro, Março);
    }

    private static void gastosDoTrimestre(int janeiro, int fevereiro, int março) {
        BigDecimal total = new BigDecimal((janeiro + fevereiro + março)); // convertendo o total ppara bigdecimal
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        System.out.println("Janeiro: " + nf.format(janeiro));
        System.out.println("Fevereiro: " + nf.format(fevereiro));
        System.out.println("Março: " + nf.format(março));
        System.out.println("Total: " + nf.format(total));

    }
}
