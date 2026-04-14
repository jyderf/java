import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[5];

        System.out.println("Ingrese 5 números:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();
        }

        System.out.println("\nLos números ingresados son:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Posición " + i + " = " + numeros[i]);
        }
        sc.close();
    }
}
