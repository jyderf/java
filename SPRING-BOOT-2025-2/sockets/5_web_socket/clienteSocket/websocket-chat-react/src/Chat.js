import React, { useEffect, useState } from "react";
import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";

export default function Chat() {

    const [client, setClient] = useState(null);
    const [messages, setMessages] = useState([]);
    const [text, setText] = useState("");

    useEffect(() => {

        // 1. Crear cliente STOMP moderno
        const stompClient = new Client({
            webSocketFactory: () => new SockJS("http://192.168.100.57:8080/ws"),

            reconnectDelay: 5000, // reintenta si se cae
            debug: (msg) => console.log(msg),

            onConnect: () => {
                console.log("React conectado!");

                // 2. Suscribirse al topic desde el servidor
                stompClient.subscribe("/topic/messages", (message) => {
                    const body = JSON.parse(message.body);
                    setMessages((prev) => [...prev, body]);
                });
            }
        });

        stompClient.activate(); // importante

        setClient(stompClient);

        return () => {
            if (stompClient) stompClient.deactivate();
        };

    }, []);

    const send = () => {
        if (client && text.trim() !== "") {

            client.publish({
                destination: "/app/send",
                body: JSON.stringify({
                    from: "React",
                    content: text
                })
            });

            setText("");
        }
    };

    return (
        <div style={{ padding: 20 }}>
            <h2>Chat React WebSocket</h2>

            <input
                value={text}
                onChange={(e) => setText(e.target.value)}
                placeholder="Escribe..."
            />
            <button onClick={send}>Enviar</button>

            <ul>
                {messages.map((m, i) => (
                    <li key={i}>
                        <strong>{m.from}:</strong> {m.content}
                    </li>
                ))}
            </ul>
        </div>
    );
}
