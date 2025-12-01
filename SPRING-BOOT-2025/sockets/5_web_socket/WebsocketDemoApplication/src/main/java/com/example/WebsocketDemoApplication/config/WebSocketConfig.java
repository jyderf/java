package com.example.WebsocketDemoApplication.config;
// Declara el paquete donde vive esta clase. Organiza el código y determina su namespace.

import org.springframework.context.annotation.Configuration;
// Importa la anotación @Configuration que marca esta clase como fuente de beans para Spring.

import org.springframework.messaging.simp.config.MessageBrokerRegistry;
// Importa la clase usada para configurar el broker de mensajes (topics, colas, prefijos).

import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
// Importa la anotación que habilita el soporte de WebSocket + STOMP en Spring.

import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
// Importa la clase usada para registrar endpoints STOMP (puntos de conexión WebSocket).

import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
// Importa la interfaz que proporciona métodos para personalizar la configuración WebSocket/STOMP.

@Configuration
// Indica a Spring que esta clase contiene configuración (beans) y debe instanciarse en el contexto.
@EnableWebSocketMessageBroker
// Activa el soporte de WebSocket y el message broker basado en STOMP dentro de la app Spring.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
// Define la clase de configuración y dice que implementa WebSocketMessageBrokerConfigurer
// para poder sobrescribir métodos de configuración del broker y endpoints.

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Método llamado por Spring para configurar el "message broker" (ruta de enrutamiento de mensajes).

        registry.enableSimpleBroker("/topic");
        // Habilita un broker simple en memoria que enviará mensajes a destinos que empiecen por "/topic".
        // Es útil para broadcasting/pub-sub sencillo (mensajes a todos los suscritos).
        // (Alternativa: enableStompBrokerRelay para delegar a un broker externo como RabbitMQ.)

        registry.setApplicationDestinationPrefixes("/app");
        // Define el prefijo que usarán los clientes para enviar mensajes al servidor (a los controllers).
        // Ejemplo: un cliente que haga send("/app/send") será mapeado a @MessageMapping("/send") en un @Controller.
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Método llamado por Spring para registrar los endpoints donde los clientes establecerán la conexión STOMP/WebSocket.

        registry.addEndpoint("/ws")
                // Registra el endpoint físico en "/ws". Los clientes harán SockJS/WebSocket a "http://host:port/ws".

                .setAllowedOriginPatterns("*")
                // Permite orígenes CORS desde cualquier host. Útil en desarrollo para aceptar conexiones desde diferentes orígenes (ej: React en :3000).
                // En producción es recomendable limitarlo a los orígenes confiables por seguridad (ej. "https://mi-dominio.com").

                .withSockJS();
        // Habilita soporte SockJS: proporciona fallback (xhr-streaming, long-polling) cuando WebSocket puro no está disponible
        // y mejora la compatibilidad con navegadores/proxies intermediarios.
    }
}
