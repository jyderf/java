package socket_1.demo_1;
import java.io.BufferedReader;         // Para leer respuestas del servidor
import java.io.InputStreamReader;
import java.io.PrintWriter;            // Para enviar al servidor
import java.net.Socket;                // Para conectarse al servidor
import java.util.Scanner;              // Para leer desde teclado

public class Cliente {

    public static void main(String[] args) {
        try {
            // Se conecta al servidor en la misma máquina (localhost)
            Socket socket = new Socket("localhost", 5000);

            // Para enviar mensajes al servidor
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            // Para leer respuestas del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Para leer lo que escribe el usuario en consola
            Scanner scanner = new Scanner(System.in);

            System.out.println("Cliente conectado. Escribe mensajes para enviar al servidor.");

            String mensaje;

            // Ciclo para escribir y recibir respuestas
            while (true) {
                System.out.print("Cliente > ");
                mensaje = scanner.nextLine();  // Leer mensaje desde teclado

                salida.println(mensaje);       // Enviar al servidor

                // Si escribe "salir", terminamos
                if (mensaje.equalsIgnoreCase("salir")) {
                    break;
                }

                // Leer lo que responde el servidor
                String respuesta = entrada.readLine();
                System.out.println("Servidor > " + respuesta);
            }

            socket.close();
            System.out.println("Cliente cerrado.");

        } catch (Exception e) {
            System.out.println("Error en cliente: " + e.getMessage());
        }
    }
}
