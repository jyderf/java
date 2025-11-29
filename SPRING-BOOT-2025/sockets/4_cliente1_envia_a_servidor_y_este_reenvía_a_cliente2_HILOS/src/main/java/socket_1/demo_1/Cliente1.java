package socket_1.demo_1;
import java.io.PrintWriter;                 // Para enviar al servidor
import java.net.Socket;                     // Conexión con el servidor
import java.util.Scanner;                   // Para leer desde teclado
public class Cliente1 {

    public static void main(String[] args) {

        try {
            // Se conecta al servidor en localhost en el puerto 5000
            Socket socket = new Socket("localhost", 5000);

            // Crea un escritor para enviar mensajes al servidor
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Para leer texto desde teclado
            Scanner scanner = new Scanner(System.in);

            System.out.println("Cliente1 conectado. Escribe mensajes:");

            // Bucle infinito para enviar muchos mensajes
            while (true) {
                System.out.print("Cliente1 > ");
                String mensaje = scanner.nextLine(); // Lee lo que escribe el usuario

                salida.println(mensaje); // ENVÍA AL SERVIDOR

                if (mensaje.equalsIgnoreCase("salir")) {
                    break;  // Si escribe "salir" termina
                }
            }

            socket.close();
            System.out.println("Cliente1 cerrado.");

        } catch (Exception e) {
            System.out.println("Error Cliente1: " + e.getMessage());
        }
    }
}
