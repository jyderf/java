package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
        /*
        Proceso_1 a = new Proceso_1();
        Proceso_2 b = new Proceso_2();
        */
        Thread a = new Thread(new Proceso_1());
        Thread b = new Thread(new Proceso_2());
        a.start();
        b.start();
	}

}
