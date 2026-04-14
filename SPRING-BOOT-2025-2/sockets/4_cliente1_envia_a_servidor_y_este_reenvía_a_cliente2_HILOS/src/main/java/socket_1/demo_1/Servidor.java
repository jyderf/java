package socket_1.demo_1;

import java.io.BufferedReader;           // Para leer texto del cliente
import java.io.InputStreamReader;
import java.io.PrintWriter;              // Para escribir texto al cliente
import java.net.ServerSocket;            // Para abrir el servidor
import java.net.Socket;                  // Conexión con cada cliente

public class Servidor {

    // Sockets globales: uno para Cliente1 y otro para Cliente2
    private static Socket socketCliente1;
    private static Socket socketCliente2;

    // Writer global para enviar a Cliente2
    private static PrintWriter escritorCliente2;

    public static void main(String[] args) {
        try {
            // Crea un servidor en el puerto 5000
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Servidor iniciado. Esperando Cliente1...");

            // Espera la conexión del Cliente1
            socketCliente1 = servidor.accept();
            System.out.println("Cliente1 conectado.");

            // Espera la conexión del Cliente2
            System.out.println("Esperando Cliente2...");
            socketCliente2 = servidor.accept();
            System.out.println("Cliente2 conectado.");

            // Crea el escritor para enviar mensajes a Cliente2
            escritorCliente2 = new PrintWriter(socketCliente2.getOutputStream(), true);

            // Crea un hilo que escucha mensajes de Cliente1
            HiloCliente1 hilo1 = new HiloCliente1(socketCliente1, escritorCliente2);
            hilo1.start();

            System.out.println("Servidor listo. Reenviando mensajes de Cliente1 a Cliente2.");

        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}


// Este hilo se encarga de escuchar TODO lo que envía Cliente1
class HiloCliente1 extends Thread {

    private Socket socket1;                 // Conexión con Cliente1
    private PrintWriter escritorCliente2;   // Para reenviar a Cliente2

    public HiloCliente1(Socket socket1, PrintWriter escritorCliente2) {
        this.socket1 = socket1;             // Guarda el socket del cliente1
        this.escritorCliente2 = escritorCliente2; // Guarda el escritor hacia cliente2
    }

    @Override
    public void run() {
        try {
            // Para leer lo que Cliente1 envía
            BufferedReader entradaCliente1 =
                    new BufferedReader(new InputStreamReader(socket1.getInputStream()));

            String mensaje;

            // Ciclo infinito: recibe mensajes de Cliente1
            while ((mensaje = entradaCliente1.readLine()) != null) {

                System.out.println("Cliente1 envió: " + mensaje);

                // Reenvía ese mensaje a Cliente2
                escritorCliente2.println("Cliente1 dice: " + mensaje);
            }

            System.out.println("Cliente1 se desconectó.");

        } catch (Exception e) {
            System.out.println("Error en hilo Cliente1: " + e.getMessage());
        }
    }
}
