import java.time.Month;
import java.time.Year;

public class exerciciosAleatorios {
    public static void main(String[] args) {
//        calcularSalario(150, 40.5);
        nomeDoMes(10);
    }

    private static void nomeDoMes(int month) {
        System.out.println(Month.of(month));
    }

    private static void calcularSalario(int horasTrabalhadas, double valorPorHora) {
        System.out.println((double) horasTrabalhadas * valorPorHora);
    }
}
