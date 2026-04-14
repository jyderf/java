package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    @Async
    public void sumar(int a, int b) {
        int resultado = a + b;
        System.out.println("Suma: " + resultado +
                " | Hilo: " + Thread.currentThread().getName());
    }

    @Async
    public void restar(int a, int b) {
        int resultado = a - b;
        System.out.println("Resta: " + resultado +
                " | Hilo: " + Thread.currentThread().getName());
    }

    @Async
    public void multiplicar(int a, int b) {
        int resultado = a * b;
        System.out.println("Multiplicación: " + resultado +
                " | Hilo: " + Thread.currentThread().getName());
    }

    @Async
    public void dividir(int a, int b) {
        if (b != 0) {
            double resultado = (double) a / b;
            System.out.println("División: " + resultado +
                    " | Hilo: " + Thread.currentThread().getName());
        } else {
            System.out.println("Error: División entre cero." +
                    " | Hilo: " + Thread.currentThread().getName());
        }
    }
}
