package com.example.demo;
import java.lang.Thread;

// Clase para Suma
class SumaThread extends Thread {
    private int a, b;

    public SumaThread(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        int resultado = a + b;
        System.out.println("Suma: " + resultado +
                " | Hilo: " + Thread.currentThread().getName());
    }
}

// Clase para Resta
class RestaThread extends Thread {
    private int a, b;

    public RestaThread(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        int resultado = a - b;
        System.out.println("Resta: " + resultado +
                " | Hilo: " + Thread.currentThread().getName());
    }
}

// Clase para Multiplicación
class MultiplicacionThread extends Thread {
    private int a, b;

    public MultiplicacionThread(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        int resultado = a * b;
        System.out.println("Multiplicación: " + resultado +
                " | Hilo: " + Thread.currentThread().getName());
    }
}

// Clase para División
class DivisionThread extends Thread {
    private int a, b;

    public DivisionThread(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
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