import java.util.Scanner;

public class verificarEleitor {

    public static void main(String[] args) {
        int idade = pegarIdade();

        String resposta = idade >= 16 && idade < 18 ? "Voto facultativo" : idade >= 18 && idade <= 70 ? "Voto obrigatório" : "Sem direito a votar";
        System.out.println(resposta);
    }

    private static int pegarIdade() {
        int idade = 0;

        Scanner sc = new Scanner(System.in);
        boolean isInvalid;

        do {
            isInvalid = false;

            try {
                System.out.println("Informe a sua idade");
                idade = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Por favor informe uma idade válida");
                isInvalid = true;
            }
        } while (isInvalid);

        return idade;
    }
}
