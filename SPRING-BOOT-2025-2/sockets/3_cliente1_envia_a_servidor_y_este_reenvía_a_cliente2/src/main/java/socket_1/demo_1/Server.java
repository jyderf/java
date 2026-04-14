package socket_1.demo_1;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws Exception {

        // Creamos un servidor que escucha en el puerto 5000
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Servidor iniciado en puerto 5000...");

        // Espera a que se conecte el Cliente 1
        System.out.println("Esperando Cliente 1...");
        Socket c1 = server.accept();  // Se queda esperando
        System.out.println("Cliente 1 conectado.");

        // Canal para leer el mensaje que envía Cliente 1
        BufferedReader in1 = new BufferedReader(new InputStreamReader(c1.getInputStream())
        );

        // Espera a que se conecte el Cliente 2
        System.out.println("Esperando Cliente 2...");
        Socket c2 = server.accept();  // Se queda esperando
        System.out.println("Cliente 2 conectado.");

        // Canal para enviar mensajes a Cliente 2
        PrintWriter out2 = new PrintWriter(c2.getOutputStream(), true);

        // Lee el mensaje enviado por Cliente 1
        String mensaje = in1.readLine();
        System.out.println("Recibido de Cliente 1: " + mensaje);

        // Envía ese mensaje a Cliente 2
        out2.println(mensaje);
        System.out.println("Mensaje reenviado a Cliente 2.");

        // Cierra conexiones
        c1.close();
        c2.close();
        server.close();
        System.out.println("Servidor cerrado.");
    }
}
