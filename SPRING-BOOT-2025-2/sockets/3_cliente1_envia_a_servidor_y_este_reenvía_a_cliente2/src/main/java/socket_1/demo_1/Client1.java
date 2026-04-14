package socket_1.demo_1;
import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) throws Exception {

        // Cliente 1 se conecta al servidor en localhost y puerto 5000
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Cliente 1 conectado al servidor.");

        // Canal para enviar mensajes al servidor
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Enviamos un mensaje al servidor
        out.println("Hola, soy el Cliente 1!");
        System.out.println("Cliente 1 envió el mensaje al servidor.");

        // Cerramos la conexión
        socket.close();
        System.out.println("Cliente 1 desconectado.");
    }
}
