package com.example.WebsocketDemoApplication.dto;
// Declara el paquete donde vive esta clase (organiza el código por módulos).
// "dto" significa Data Transfer Object: objetos usados para transportar datos.

public class Message {
    // Declara la clase pública Message, que será enviada y recibida vía WebSocket.
    // Representa un mensaje simple con un remitente y un contenido.

    private String from;
    // Campo privado que almacena quién envía el mensaje (nombre, usuario, cliente).

    private String content;
    // Campo privado que almacena el texto del mensaje enviado.

    public Message() {}
    // Constructor vacío requerido por frameworks como Spring, Jackson, etc.
    // Permite que la clase sea creada sin parámetros al deserializar JSON.

    public Message(String from, String content) {
        // Constructor con parámetros para crear un mensaje rápidamente.
        this.from = from;          // Asigna el valor del remitente.
        this.content = content;    // Asigna el contenido del mensaje.
    }

    public String getFrom() { return from; }
    // Getter para obtener el valor del campo "from".
    // Necesario para convertir el objeto a JSON y para lectura.

    public void setFrom(String from) { this.from = from; }
    // Setter para modificar el valor de "from".
    // Necesario para deserialización desde JSON si llega un mensaje del cliente.

    public String getContent() { return content; }
    // Getter que devuelve el contenido del mensaje.

    public void setContent(String content) { this.content = content; }
    // Setter para asignar un nuevo valor al contenido del mensaje.
}
