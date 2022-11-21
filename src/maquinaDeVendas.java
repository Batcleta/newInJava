import java.util.Scanner;

public class maquinaDeVendas {
    public static void main(String[] args) {

        int escolha = pegarEscolha();
        String retorno;

        if (escolha == 1) {
            retorno = "Coca-Cola - R$ 5,00";
        } else if (escolha == 2) {
            retorno = "Coca-Cola 0 - R$ 4.50";
        } else if (escolha == 3) {
            retorno = "Pepsi - R$ 4,40";
        } else if (escolha == 4) {
            retorno = "Guaraná Antarctica - R$ 3,50";
        } else if (escolha == 5) {
            retorno = "Fanta Laranja - R$ 4,23";
        } else {
            retorno = "Água - R$ 2,50";
        }

        System.out.println(retorno);
    }

    private static int pegarEscolha() {
        int opcao = 0;

        Scanner sc = new Scanner(System.in);
        boolean isInvalid;

        do {
            isInvalid = false;

            try {
                System.out.println("Escolha sua bebida");
                System.out.println("1 - Coca Cola - R$ 5");
                System.out.println("2 - Coca Cola 0 - R$ 4.50");
                System.out.println("3 - Pepsi - R$ 4,40");
                System.out.println("4 - Guaraná Antarctica - R$ 3,50");
                System.out.println("5 - Fanta Laranja - R$ 4,23");
                System.out.println("Qualquer npumero - Água - R$ 2,50");

                opcao = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Por favor escolha uma das opções ou qualquer numero para agua");
                isInvalid = true;
            }
        } while (isInvalid);

        return opcao;
    }
}
