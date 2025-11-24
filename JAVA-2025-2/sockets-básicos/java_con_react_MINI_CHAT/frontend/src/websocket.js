// Este archivo maneja SOLO la lógica de conexión WebSocket

export function connectWebSocket(onMessageCallback) {
          // Creamos el WebSocket hacia el backend
          const socket = new WebSocket("ws://localhost:8081");
        
          // Cuando llega un mensaje del servidor se ejecuta esta función
          socket.onmessage = (event) => {
            onMessageCallback(event.data);
          };
        
          return socket; // retornamos el WebSocket para poder usarlo en App.jsx
        }
        