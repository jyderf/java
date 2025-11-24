package com.proyecto_socket.chat;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Nuestro controlador WebSocket maneja eventos como conexión y mensajes
@Component
public class ChatController extends TextWebSocketHandler {

    // Lista thread-safe para mantener todas las conexiones activas
    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    // Se ejecuta cuando un cliente se conecta
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("Cliente conectado: " + session.getRemoteAddress());
    }

    // Se ejecuta cuando un cliente envía un mensaje
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Mensaje recibido: " + message.getPayload());

        // Enviar el mensaje a todos los clientes conectados
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                s.sendMessage(message);
            }
        }
    }

    // Se ejecuta cuando un cliente se desconecta
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("Cliente desconectado: " + session.getRemoteAddress());
    }

    // Manejo de errores
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        exception.printStackTrace();
    }
}
