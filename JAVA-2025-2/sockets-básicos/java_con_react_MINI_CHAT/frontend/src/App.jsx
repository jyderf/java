import React, { useState, useEffect } from "react";
import { connectWebSocket } from "./websocket";

export default function App() {
  const [messages, setMessages] = useState([]);
  const [text, setText] = useState("");
  const [ws, setWs] = useState(null);

  useEffect(() => {
    // Llamamos la función que creamos en websocket.js
    const socket = connectWebSocket((msg) => {
      setMessages((prev) => [...prev, msg]); // agregamos mensajes
    });

    setWs(socket);
  }, []);

  const sendMessage = () => {
    if (ws) ws.send(text);
    setText("");
  };

  return (
    <div style={{ width: "300px", margin: "20px auto", fontFamily: "Arial" }}>
      <h2>Mini Chat WebSocket</h2>

      <div style={{ 
        border: "1px solid black",
        height: "200px",
        padding: "10px",
        overflowY: "auto"
      }}>
        {messages.map((msg, i) => (
          <div key={i}>{msg}</div>
        ))}
      </div>

      <input 
        value={text}
        onChange={(e) => setText(e.target.value)}
        onKeyDown={(e) => e.key === "Enter" && sendMessage()}
        style={{ width: "100%", marginTop: "10px" }}
      />

      <button 
        onClick={sendMessage}
        style={{ width: "100%", marginTop: "5px" }}
      >
        Enviar
      </button>
    </div>
  );
}
