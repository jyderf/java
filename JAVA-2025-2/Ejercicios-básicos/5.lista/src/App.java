import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nombres = new ArrayList<>();
        System.out.println("Ingrese 3 nombres:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Nombre " + (i + 1) + ": ");
            String nombre = sc.nextLine();
            nombres.add(nombre);
        }
        System.out.println("\nLos nombres ingresados son:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
        sc.close();
    }
}