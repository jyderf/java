package com.example.demo;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoApplication {

    public static void main(String[] args) {

        // 🔹 Levanta Spring Boot SIN servidor web (ni Tomcat, ni puertos)
        ApplicationContext context = new SpringApplicationBuilder(DemoApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 🔹 Obtiene el bean del servicio y ejecuta las operaciones
        CalculadoraService calculadora = context.getBean(CalculadoraService.class);

        calculadora.sumar(8, 4);
        calculadora.restar(10, 3);
        calculadora.multiplicar(6, 7);
        calculadora.dividir(20, 4);
    }
}
