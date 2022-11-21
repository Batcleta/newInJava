import java.text.NumberFormat;
import java.util.Locale;

public class imprimeTotalDatas {
    public static void main(String[] args) {
        String frase = "Janeiro: 1543, Fevereiro: 1222, Março: 1234";
        String[] convertida = frase.split(",");
        Double soma = 0.00;

        for (String item : convertida){
            String[] balancoMensal = item.split(": ");
            String mes = balancoMensal[0].trim();
            Double Valor = Double.parseDouble(balancoMensal[1]);


            soma += Valor;
            System.out.println("Mes: " + mes + " - Gastos: " + converterParaReal(Valor));
        }

        System.out.println("Total de gastos no trimestre: " + converterParaReal(soma));

    }

    private static String converterParaReal(Double valor){
        String paraReal = NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valor);
        return paraReal;
    }
}
