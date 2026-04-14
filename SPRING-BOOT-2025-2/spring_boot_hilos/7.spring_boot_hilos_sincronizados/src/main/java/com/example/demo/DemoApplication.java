package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        Hilo1 hilo1 = new Hilo1();
        Hilo2 hilo2 = new Hilo2();
        Hilo3 hilo3 = new Hilo3();
        Hilo4 hilo4 = new Hilo4();
        Hilo5 hilo5 = new Hilo5();


        hilo1.start();
        try{
            hilo1.sleep(10);

        }catch (InterruptedException e){
            System.out.println("Error en el hilo1 " + e);
        }

        hilo2.start();
        try{
            hilo2.sleep(10);

        }catch (InterruptedException e){
            System.out.println("Error en el hilo2 " + e);
        }

        hilo3.start();
        try{
            hilo3.sleep(10);

        }catch (InterruptedException e){
            System.out.println("Error en el hilo3 " + e);
        }

        hilo4.start();
        try{
            hilo4.sleep(10);

        }catch (InterruptedException e){
            System.out.println("Error en el hilo4 " + e);
        }

        hilo5.start();
        try{
            hilo5.sleep(10);

        }catch (InterruptedException e){
            System.out.println("Error en el hilo5 " + e);
        }

    }

}