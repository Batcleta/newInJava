import java.math.BigDecimal;

public class testesAleatorios {
    public static void main(String[] args) {
        BigDecimal teste = new BigDecimal(0);
        teste = teste.add(new BigDecimal(100));
        teste = teste.multiply(BigDecimal.valueOf(1-0.2));

        System.out.println(teste);
    }
}
