import java.util.Scanner;

public class JogoDaForca2 {
    private static String keyWord;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean theWheelsOnTheBus = true;
        while (theWheelsOnTheBus) {
            hangmanGame(theWheelsOnTheBus);
        }
    }

    private static void hangmanGame(boolean theWheelsOnTheBus) {
        keyWord = getNewKeyword();
        String usedWords = "";
        StringBuilder playingWords = new StringBuilder();
        int MAX_ATTEMPTS = 10;

        for (int i = 0; i < keyWord.length(); i++) {
            playingWords.append("_ ");


            for (int attempts = 1; ; attempts++) {
                if (attempts == MAX_ATTEMPTS) {
                    System.out.println("Congratulations! you died. The correct word was: " + keyWord);

                    playAgain(theWheelsOnTheBus);
                }

                if (attempts == 1) {
                    System.out.println("");
                    System.out.printf("----> Round: %d - Lets play! with %s letters\n", attempts, keyWord.length());
                    System.out.print("You can type and character or try your lucky with the full word?\n");
                } else if (attempts < 6) {
                    System.out.println("");
                    System.out.printf("----> Round: %d. The road so far: %s\n", attempts, playingWords.toString());
                    System.out.printf("Already tried: %s\n", usedWords);
                    System.out.print("try a next character or a full word ");
                } else if (attempts < 10) {
                    System.out.println("");
                    System.out.printf("----> Round: %d. The road so far: %s\n", attempts, playingWords.toString());
                    System.out.printf("Already tried: %s\n", usedWords);
                    System.out.print("try a next character or lets get crazy and try your lucky ");
                } else {
                    System.out.println("");
                    System.out.printf("----> Round: %d. The road so far: %s\n", attempts, playingWords.toString());
                    System.out.printf("Already tried: %s\n", usedWords);
                    System.out.print("Last try. Do or die\n");
                }


                boolean isInvalid;

                do {
                    isInvalid = false;

                    try {
                        String playedWord = scanner.nextLine().toLowerCase();

                        if (playedWord.length() < 1) {
                            System.out.println("Please, type a valid character ou word");
                            isInvalid = true;
                            continue;
                        }

                        if (playedWord.length() > 1) {
                            if (playedWord.equals(keyWord)) {
                                if (attempts < (keyWord.length() / 3)) {
                                    System.out.print("Wow. You must be the coolest kit in school. Nice Job!\n");
                                } else {
                                    System.out.print("Nice job, you're right\n");
                                }
                                playAgain(theWheelsOnTheBus);
                            } else {
                                System.out.println("");
                                System.out.println("Nice try! and !!CONGRATULATIONS!! you died. The correct word was: " + keyWord);
                                playAgain(theWheelsOnTheBus);
                            }
                        }

                        if (usedWords.contains(playedWord)) {
                            System.out.println("You already try this word: " + playedWord);
                        } else {
                            usedWords += playedWord + ",";

                            String comparedKeyWord = letsGetSpecial(keyWord);

                            if (comparedKeyWord.contains(playedWord)) {
                                playingWords = new StringBuilder();

                                for (int j = 0; j < keyWord.length(); j++) {
                                    playingWords.append(usedWords.indexOf(comparedKeyWord.charAt(j)) >= 0 ? keyWord.charAt(j) + " " : "_ ");
                                }

                                if (playingWords.toString().contains("_")) {
                                    System.out.printf("Nicee! '%s' exists\n", playedWord);
                                } else {
                                    System.out.println("");
                                    System.out.printf("Nice job, you got it: '%s\n", keyWord);
                                    playAgain(theWheelsOnTheBus);
                                }
                            } else {
                                System.out.printf("Oh sorry. '%s' don't exists.\n", playedWord);
                            }
                        }


                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        attempts--;
                        isInvalid = true;
                    }

                } while (isInvalid);

            }
        }
    }

    public static String getNewKeyword() {
        String newKeyWord = "";
        String[] words = new String[]{"Anticonstitucionalissimamente", "Apicultor", "Agrônomo", "Auditor", "Bartender",
                "Cerimonialista", "Chef", "Coach", "Desembargador", "Despachante", "Endocrinologista", "Embaixador",
                "Gerentólogo", "Headhunter", "Intérprete", "Juiz", "Nanotecnólogo", "Nutrólogo", "Pizzaiolo",
                "Perito", "Quiroprata", "Roteirizador", "Silvicultor", "Trader", "Taquígrafo", "Turismólogo", "Animais",
                "Albatroz", "Alpaca", "Anchova", "Bacalhau", "Badejo", "Barracuda", "Beluga", "Cágado", "Chinchila",
                "Dromedário", "Escaravelho", "Gerbo", "Gnu", "Gralha", "Hamster", "Lêmure", "Lhama", "Lince", "Marreco",
                "Melro", "Ocapi", "Ouriço", "Pelicano", "Percevejo", "Pirilampo", "Quati", "Rouxinol", "Sanguessuga",
                "Surucucu", "Tapir", "Texugo", "Vison", "Zebu", "Ampulhet", "Ampulheta", "Anzol", "Almofariz", "Bidê",
                "Botija", "Candelabro", "Daguerreótipo", "Dedaleira", "Desfibrilador", "Diapasão", "Echarpe", "Estribo",
                "Fagote", "Fantoche", "Fórceps", "Navalha", "Jaleco", "Modem", "Narguilé", "Nebulizador", "Novelo",
                "Oboé", "Oxímetro", "Pêndulo", "Quepe", "Selim", "Sintetizador", "Spray", "Urinol", "Vuvuzela", "Webcam",
                "Xadrez", "Xequerê", "Xilofone", "Zíper", "Craca"};
        newKeyWord = words[aleatorio(words.length)];

        if (newKeyWord.equals(keyWord)) {
            getNewKeyword();
        }

        return newKeyWord.toLowerCase();
    }

    private static int aleatorio(int max) {
        int gerador = (int) (Math.random() * max);
        return gerador;
    }

    private static void playAgain(boolean theWheelsOnTheBus) {
        boolean letsPlay = true;
        System.out.println("");
        System.out.println("------> Wanna play again?");
        System.out.println("[1] yes");
        System.out.println("[2] no");
        System.out.print("pick an option:");

        String option = scanner.nextLine();

        if (option.equals("2")) {
            letsPlay = false;
        }

        if (letsPlay) {
            System.out.println("Ok, lets rock!");
            hangmanGame(theWheelsOnTheBus);
        } else {
            System.out.println("Thanks for play! see ya later aligator");
            theWheelsOnTheBus = false;
        }

        return;
    }

    public static String letsGetSpecial(String txt) {
        String s = "";
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            switch (c) {


                case 'Á':
                case 'À':
                case 'Ã':
                case 'á':
                case 'à':
                case 'ã':
                    c = 'a';
                    break;
                case 'É':
                case 'Ê':
                case 'é':
                case 'ê':
                    c = 'e';
                    break;
                case 'í':
                case 'Í':
                    c = 'i';
                    break;
                case 'Ó':
                case 'Õ':
                case 'Ô':
                case 'ó':
                case 'õ':
                case 'ô':
                    c = 'o';
                    break;
                case 'ú':
                case 'Ú':
                    c = 'u';
                    break;
                case 'ç':
                case 'Ç':
                    c = 'c';
                    break;
            }
            s += c;
        }
        return s;
    }
}
