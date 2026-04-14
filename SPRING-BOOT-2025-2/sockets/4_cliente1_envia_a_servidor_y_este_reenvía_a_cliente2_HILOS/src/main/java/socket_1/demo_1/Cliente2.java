package socket_1.demo_1;
import java.io.BufferedReader;              // Para leer del servidor
import java.io.InputStreamReader;
import java.net.Socket;                     // Para conectarse al servidor

public class Cliente2 {

    public static void main(String[] args) {

        try {
            // Se conecta al servidor
            Socket socket = new Socket("localhost", 5000);

            // Para leer mensajes que envía el servidor
            BufferedReader entrada =
                    new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Cliente2 conectado. Esperando mensajes...");

            String mensaje;

            // Ciclo infinito para recibir cualquier mensaje reenviado
            while ((mensaje = entrada.readLine()) != null) {
                System.out.println(">> " + mensaje); // Imprime lo que Cliente1 envió
            }

            socket.close();
            System.out.println("Cliente2 cerrado.");

        } catch (Exception e) {
            System.out.println("Error Cliente2: " + e.getMessage());
        }
    }
}
