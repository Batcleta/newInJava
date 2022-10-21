import javax.swing.*;

public class AdivinheUmNumero {

    //Jogo que permite o usuário adivinhar o número que o comutador gerou

    public static void main(String[] args) {
        int numeroGerado = gerarIntAleatorio();
        int resposta = 0;

        int contador = 1;

        while (resposta != numeroGerado) {

            try {
                String numeroInformado = JOptionPane.showInputDialog(null, "Insira um número entre 1 e 100", "Jogo do acerto", 3);
                resposta = Integer.parseInt(numeroInformado);

                JOptionPane.showMessageDialog(null, "" + determineGuess(resposta, numeroGerado, contador));
                contador++;
            } catch (Exception e) {
                continue;
            }


        }
    }

    private static int gerarIntAleatorio() {
        return (int) (Math.random() * 100 + 1);
    }

    public static String determineGuess(int resposta, int numeroGerado, int contador) {

        if (resposta <= 0 || resposta > 100) {

            return "Opa, sua resposta é inválida";

        } else if (resposta == numeroGerado) {

            return "Acertou!\ntentativas: " + contador;

        } else if (resposta > numeroGerado) {

            return "Opa... Chutou alto, tente de novo.\ntentativas: " + contador;

        } else if (resposta < numeroGerado) {

            return "Opa... Chutou baixo, tente de novo.\ntentativas: " + contador;

        } else {

            return "Errouuuuuuu, tente de novo \ntentativas: " + contador;

        }

    }
}
