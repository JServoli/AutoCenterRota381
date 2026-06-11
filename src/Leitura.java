import java.util.Scanner;

public class Leitura {
    public static int lerInteiro(Scanner leitor, String mensagem) {
        System.out.print(mensagem);

        while (!leitor.hasNextInt()) {
            System.out.println("Valor invalido. Digite um numero inteiro.");
            leitor.nextLine();
            System.out.print(mensagem);
        }

        int valor = leitor.nextInt();
        leitor.nextLine();
        return valor;
    }

    public static double lerDouble(Scanner leitor, String mensagem) {
        System.out.print(mensagem);

        while (!leitor.hasNextDouble()) {
            System.out.println("Valor invalido. Digite um numero decimal.");
            leitor.nextLine();
            System.out.print(mensagem);
        }

        double valor = leitor.nextDouble();
        leitor.nextLine();
        return valor;
    }

    public static String lerTexto(Scanner leitor, String mensagem) {
        System.out.print(mensagem);
        String texto = leitor.nextLine();

        while (texto.equals("")) {
            System.out.println("O texto nao pode ficar vazio.");
            System.out.print(mensagem);
            texto = leitor.nextLine();
        }

        return texto;
    }
}
