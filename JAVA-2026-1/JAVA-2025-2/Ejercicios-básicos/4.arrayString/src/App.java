import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] nombres = new String[3];
        System.out.println("Ingrese 3 nombres:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
        }
        System.out.println("\nLos nombres en mayúsculas son:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i].toUpperCase());
        }
        sc.close();

    }
}