package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

        Proceso a = new Proceso("Hilo1");
        Proceso b = new Proceso("Hilo2");

        a.valorDeLaCondicion(4);
        b.valorDeLaCondicion(6);


        a.start();

        try {
            a.sleep(2000);
        }catch(Exception e) {
            System.out.println("Error en el hilo: "+e);
        }



        b.start();
        //b.stop();
        //stop (); sale subrayado, porque ya no se usa a partir de java 1.2 por razones de seguridad: sesiones abiertas o
        //bd expuestas.
        try {
            a.sleep(3000);
        }catch(Exception e) {
            System.out.println("Error en el hilo: "+e);
        }

	}

}
