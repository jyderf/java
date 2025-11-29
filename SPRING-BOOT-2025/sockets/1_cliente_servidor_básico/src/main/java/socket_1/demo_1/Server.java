package socket_1.demo_1;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Servidor escuchando...");

        Socket socket = server.accept(); // Espera conexión
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String mensaje = input.readLine();
        System.out.println("Mensaje recibido: " + mensaje);

        socket.close();
        server.close();
    }
}

