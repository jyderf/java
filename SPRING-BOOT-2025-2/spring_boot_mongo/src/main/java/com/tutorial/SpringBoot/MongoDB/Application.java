package com.tutorial.SpringBoot.MongoDB;

// Importamos las librerías necesarias de Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta anotación marca esta clase como la principal de la aplicación.
// Spring Boot usará esta clase para iniciar el proyecto.
@SpringBootApplication
public class Application {

    // Método main: es el punto de entrada de cualquier aplicación Java.
    // Aquí es donde se arranca la aplicación de Spring Boot.
    public static void main(String[] args) {
        // SpringApplication.run(...) inicia todo el ecosistema de Spring.
        // Esto incluye levantar el servidor, configurar los beans y
        // habilitar los controladores REST.
        SpringApplication.run(Application.class, args);
    }
}

