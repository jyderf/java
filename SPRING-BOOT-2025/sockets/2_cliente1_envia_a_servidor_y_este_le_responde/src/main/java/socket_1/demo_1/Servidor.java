package socket_1.demo_1;

import java.io.BufferedReader;        // Para leer lo que envía el cliente
import java.io.InputStreamReader;
import java.io.PrintWriter;           // Para enviar mensaje al cliente
import java.net.ServerSocket;         // Crear servidor
import java.net.Socket;               // Representa la conexión con el cliente

public class Servidor {

    public static void main(String[] args) {
        try {
            // Crea un servidor en el puerto 5000
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado. Esperando cliente...");

            // Espera a que un cliente se conecte
            Socket socketCliente = servidor.accept();
            System.out.println("Cliente conectado.");

            // Para leer mensajes del cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

            // Para enviar respuestas al cliente
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true);

            String mensaje;

            // Ciclo infinito: el servidor lee y responde
            while ((mensaje = entrada.readLine()) != null) {

                System.out.println("Cliente dice: " + mensaje);

                // Respuesta automática del servidor
                salida.println("El servidor recibió: " + mensaje);

                // Si el cliente escribe "salir", termina la conexión
                if (mensaje.equalsIgnoreCase("salir")) {
                    break;
                }
            }

            socketCliente.close();
            servidor.close();
            System.out.println("Servidor cerrado.");

        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
