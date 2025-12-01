// Punto de entrada principal de React.
// Renderiza la aplicación completa en el div con id "root" del index.html

import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import './styles.css'; // estilos opcionales

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<App />);
