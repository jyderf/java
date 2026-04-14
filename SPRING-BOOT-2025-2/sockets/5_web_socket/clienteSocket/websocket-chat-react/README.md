# ============================
# CREAR PROYECTO REACT
# ============================
npx create-react-app websocket-chat-react

cd websocket-chat-react

# ============================
# INSTALAR DEPENDENCIAS
# ============================
npm install @stomp/stompjs sockjs-client

# ============================
# CREAR ARCHIVO Chat.js
# ============================
cat > src/Chat.js << 'EOF'
import React, { useEffect, useState } from "react";
import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";

const Chat = () => {
  const [client, setClient] = useState(null);
  const [messages, setMessages] = useState([]);
  const [text, setText] = useState("");

  useEffect(() => {
    // Cambia esta IP por la IP real de tu backend Spring
    const socket = new SockJS("http://192.168.100.57:8080/ws");

    const stompClient = new Client({
      webSocketFactory: () => socket,
      debug: () => {}, // para evitar demasiado log
    });

    stompClient.onConnect = () => {
      console.log("Conectado a WebSocket");

      stompClient.subscribe("/topic/messages", (msg) => {
        const body = JSON.parse(msg.body);
        setMessages((prev) => [...prev, body.content]);
      });
    };

    stompClient.activate();
    setClient(stompClient);
  }, []);

  const sendMessage = () => {
    if (client && text.trim() !== "") {
      client.publish({
        destination: "/app/chat",
        body: JSON.stringify({ content: text }),
      });
      setText("");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Chat WebSocket</h2>

      <div style={{ border: "1px solid #ccc", padding: "10px", height: "200px", overflowY: "scroll" }}>
        {messages.map((m, i) => (
          <p key={i}>{m}</p>
        ))}
      </div>

      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="Escribe un mensaje..."
        style={{ width: "70%", marginTop: "10px" }}
      />
      <button onClick={sendMessage} style={{ marginLeft: "10px" }}>
        Enviar
      </button>
    </div>
  );
};

export default Chat;
EOF

# ============================
# REEMPLAZAR App.js
# ============================
cat > src/App.js << 'EOF'
import Chat from "./Chat";

function App() {
  return (
    <div>
      <Chat />
    </div>
  );
}

export default App;
EOF

# ============================
# CREAR README.md COMPLETO
# ============================
cat > README.md << 'EOF'
# WebSocket Chat Frontend (React)

Este proyecto es un cliente frontend creado en **React** que se conecta mediante WebSockets usando **SockJS** y **STOMP** a un backend desarrollado en Spring Boot.

Permite enviar y recibir mensajes en tiempo real desde cualquier navegador (PC o celular).

---

## 🚀 1. Requisitos previos

Antes de comenzar, debes tener instalado:

- **Node.js** (mínimo 20.19)
- **npm**

Verifica versiones:

