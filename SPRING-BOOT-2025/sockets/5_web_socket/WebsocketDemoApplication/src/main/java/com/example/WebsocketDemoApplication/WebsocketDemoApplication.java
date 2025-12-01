package com.example.WebsocketDemoApplication;
// Define el paquete donde se encuentra esta clase principal.
// Esto organiza el proyecto y permite que Spring escanee los componentes dentro de este paquete raíz.

import org.springframework.boot.SpringApplication;
// Importa la clase SpringApplication, que contiene métodos para iniciar una aplicación Spring Boot.

import org.springframework.boot.autoconfigure.SpringBootApplication;
// Importa la anotación @SpringBootApplication, que combina:
// @Configuration → Define beans y configuración.
// @EnableAutoConfiguration → Activa la autoconfiguración de Spring Boot.
// @ComponentScan → Busca componentes, servicios, controladores, etc., en el paquete actual y sus subpaquetes.

@SpringBootApplication
// Marca esta clase como la clase principal de la aplicación Spring Boot.
// Indica a Spring que debe iniciar la autoconfiguración y escaneo de componentes.

public class WebsocketDemoApplication {
// Declara la clase pública que será el punto de entrada de la aplicación.

    public static void main(String[] args) {
        // Metodo_main: punto de inicio de cualquier aplicación Java.
        // Aquí arranca Spring Boot.

        SpringApplication.run(WebsocketDemoApplication.class, args);
        // Inicia la aplicación Spring Boot.
        // - Crea el contexto de Spring
        // - Configura Beans y servicios
        // - Inicia el servidor embebido (Tomcat por defecto)
        // - levanta_todo lo necesario para ejecutar WebSockets, controladores, etc.
    }
}
