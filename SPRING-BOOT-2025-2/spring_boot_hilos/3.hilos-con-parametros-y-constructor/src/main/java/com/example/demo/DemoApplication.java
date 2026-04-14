package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

        Proceso a = new Proceso();
        Proceso b = new Proceso();

        a.valorDeLaCondicion(4);
        b.valorDeLaCondicion(6);
        a.start();
        b.start();
	}

}
