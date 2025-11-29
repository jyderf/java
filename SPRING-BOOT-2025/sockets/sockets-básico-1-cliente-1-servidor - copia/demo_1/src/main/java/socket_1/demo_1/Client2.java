package socket_1.demo_1;

import java.io.*;
import java.net.*;

public class Client1 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 5000);

        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        output.println("Hola servidor!");

        socket.close();
    }
}
