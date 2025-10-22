import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] args) {


        final String palavraSecreta = "sopas";

        final int maxTentativas = 5;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tente adivinhar a palavra de 5 letras");


        for (int tentativaAtual = 1; tentativaAtual <= maxTentativas; tentativaAtual++) {
        System.out.print("Tentativa " + tentativaAtual + ": ");
        String tentativa = scanner.nextLine();

        if (tentativa.length() != 5) {
            System.out.println(ANSI_RED + "A palavra precisa ter 5 letras!" + ANSI_RESET);
            tentativaAtual--;
            continue;
        }

        if (tentativa.equals(palavraSecreta)) {
            System.out.println(ANSI_GREEN + "Parabéns!!! Você acertou a palavra! " + ANSI_RESET);
        }

        boolean[] usada = new boolean[5];
        for (int i = 0; i < 5; i++) {
            if (tentativa.charAt(i) == palavraSecreta.charAt(i)) {
                usada[i] = true;
            }
        }

        for (int i = 0; i < 5; i++) {
            char letra = tentativa.charAt(i);
            if (letra == palavraSecreta.charAt(i)){
                System.out.print(ANSI_GREEN + letra + ANSI_RESET);
            } else {
                boolean achou = false;
                for (int j = 0; j < 5; j++) {
                    if (!usada[j] && letra == palavraSecreta.charAt(j)){
                        achou = true;
                        usada[j] = true;
                        break;
                    }
                }

                if (achou) {
                    System.out.println(ANSI_YELLOW + letra + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED + letra + ANSI_RESET);
                }
            }
        }
            System.out.println();
    }
        System.out.println("FIM DE JOGO");
        scanner.close();
}