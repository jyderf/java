import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir el nombre al usuario
        System.out.print("¿Cómo te llamas? ");
        String nombre = scanner.nextLine();

        // Imprimir el saludo personalizado
        System.out.println("¡Hola, " + nombre + "! Bienvenido a la programación en Java.");

        // Cerrar el objeto Scanner
        scanner.close();
    }
}

