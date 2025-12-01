import React, { useEffect, useState } from "react";
// Importa React y dos hooks esenciales:
// - useState: para manejar estados (cliente, mensajes, texto).
// - useEffect: para ejecutar la conexión WebSocket cuando el componente se monta.

import SockJS from "sockjs-client";
// Importa SockJS: biblioteca que permite una conexión compatible con navegadores
// aunque WebSocket nativo falle. Es el cliente del endpoint "/ws".

import { Client } from "@stomp/stompjs";
// Importa el cliente STOMP moderno (basado en clases) para manejar el protocolo STOMP
// usado por Spring Boot WebSocket.

export default function Chat() {
// Exporta el componente principal del chat.

    const [client, setClient] = useState(null);
    // Guarda la instancia STOMP ya conectada. Se usa para enviar mensajes.

    const [messages, setMessages] = useState([]);
    // Estado que almacena todos los mensajes recibidos para el chat.

    const [text, setText] = useState("");
    // Texto actual que el usuario escribe antes de enviarlo.

    useEffect(() => {
        // Hook que se ejecuta solo una vez ([]) al montar el componente.
        // Aquí se construye y activa el WebSocket + STOMP.

        // 1. Crear cliente STOMP moderno
        const stompClient = new Client({
            // Crea una instancia moderna del cliente STOMP.

            webSocketFactory: () => new SockJS("http://192.168.100.57:8080/ws"),
            // webSocketFactory define cómo crear el WebSocket.
            // Aquí usamos SockJS, apuntando al endpoint Spring: "/ws".
            // Importante: se usa la IP de la PC para permitir acceso desde celular.

            reconnectDelay: 5000,
            // Si la conexión se cae, intenta reconectar cada 5 segundos.

            debug: (msg) => console.log(msg),
            // Permite imprimir mensajes de debug en consola, útil para desarrollo.

            onConnect: () => {
                // Función que se ejecuta cuando STOMP se conecta exitosamente.
                console.log("React conectado!");

                // 2. Suscribirse al topic desde el servidor
                stompClient.subscribe("/topic/messages", (message) => {
                    // Se suscribe al topic donde el servidor hace broadcast de los mensajes.

                    const body = JSON.parse(message.body);
                    // Convierte el mensaje STOMP (string) a JSON.

                    setMessages((prev) => [...prev, body]);
                    // Agrega el mensaje al estado 'messages' para renderizar en pantalla.
                });
            }
        });

        stompClient.activate();
        // Activa el cliente STOMP y se conecta al servidor.

        setClient(stompClient);
        // Guarda el cliente conectado en el estado para poder usarlo luego en send().

        return () => {
            // cleanup cuando el componente se desmonta
            if (stompClient) stompClient.deactivate();
            // Detiene el cliente STOMP y cierra la conexión WebSocket.
        };

    }, []); 
    // Dependencias vacías: este efecto se ejecuta solo una vez.

    const send = () => {
        // Función que envía un mensaje al servidor.

        if (client && text.trim() !== "") {
            // Verifica que haya un cliente conectado y que el texto no esté vacío.

            client.publish({
                destination: "/app/send",
                // El destino debe comenzar con "/app", que es el prefijo definido en Spring.
                // Esto corresponde al @MessageMapping("/send").

                body: JSON.stringify({
                    from: "React",
                    content: text
                })
                // Cuerpo del mensaje en formato JSON:
                // - from: nombre del remitente
                // - content: contenido del mensaje
            });

            setText("");
            // Limpia el input después de enviar.
        }
    };

    return (
        <div style={{ padding: 20 }}>
            {/* Contenedor con padding */}

            <h2>Chat React WebSocket</h2>
            {/* Título en pantalla */}

            <input
                value={text}
                onChange={(e) => setText(e.target.value)}
                placeholder="Escribe..."
            />
            {/* Input donde el usuario escribe el mensaje */}

            <button onClick={send}>Enviar</button>
            {/* Botón que dispara la función send() */}

            <ul>
                {messages.map((m, i) => (
                    <li key={i}>
                        <strong>{m.from}:</strong> {m.content}
                    </li>
                ))}
            </ul>
            {/* Lista de mensajes recibidos desde el servidor */}
        </div>
    );
}
