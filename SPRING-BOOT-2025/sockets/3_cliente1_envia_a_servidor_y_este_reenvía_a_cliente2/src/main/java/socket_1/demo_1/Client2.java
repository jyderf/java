package socket_1.demo_1;

import java.io.*;
import java.net.*;

public class Client2 {
    public static void main(String[] args) throws Exception {

        // Cliente 2 se conecta al servidor
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Cliente 2 conectado al servidor.");

        // Canal para recibir mensajes del servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())
        );

        // Espera el mensaje reenviado por el servidor
        String mensaje = in.readLine();
        System.out.println("Cliente 2 recibió: " + mensaje);

        // Cerramos la conexión
        socket.close();
        System.out.println("Cliente 2 desconectado.");
    }
}
