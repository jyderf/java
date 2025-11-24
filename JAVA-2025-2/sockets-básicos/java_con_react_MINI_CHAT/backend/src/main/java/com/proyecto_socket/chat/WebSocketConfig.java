package com.proyecto_socket.chat;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;

// Esta clase habilita WebSocket y registra nuestros endpoints
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatController chatController;

    // Inyectamos nuestro controlador de WebSocket
    public WebSocketConfig(ChatController chatController) {
        this.chatController = chatController;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // Registramos un endpoint para React en /chat
        registry.addHandler(chatController, "/chat")
                .setAllowedOrigins("*"); // Permite conexiones desde cualquier origen
    }
}

