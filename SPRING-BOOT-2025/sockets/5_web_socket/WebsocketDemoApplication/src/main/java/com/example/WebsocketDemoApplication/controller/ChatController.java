package com.example.WebsocketDemoApplication.controller;

// Importa la clase DTO que representa el mensaje (debe tener getters/setters).
import com.example.WebsocketDemoApplication.dto.Message;

// Anotaciones Spring para manejo de mensajes STOMP/WebSocket
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// Indica que esta clase es un bean controlador manejado por Spring
@Controller
public class ChatController {

    // @MessageMapping registra un "handler" para mensajes entrantes.
    // Cuando un cliente STOMP envía a la ruta "/app/send" (prefijo /app viene de la config),
    // este metodo sera invocado con el payload deserializado en Message.
    @MessageMapping("/send")        // Recibe: /app/send

    // @SendTo indica la ruta STOMP a la que se reenvía el resultado devuelto por el método.
    // El objeto que retorne este metodo sera serializado (por ejemplo a JSON)
    // y enviado a todos los clientes suscritos a "/topic/messages".
    @SendTo("/topic/messages")      // Envía a: /topic/messages

    // Metodo que procesa el mensaje entrante. Spring lo invoca automáticamente.
    public Message broadcast(Message message) {
        // Línea de depuración: imprime en consola el contenido recibido (útil para debug).
        System.out.println("Servidor recibió: " + message.getContent());

        // Retorna el mismo objeto Message. Spring lo enviará a /topic/messages.
        // Alternativamente podrías modificarlo (ej. agregar timestamp, usuario, id).
        return message; // Reenvía a todos los suscritos
    }
}
