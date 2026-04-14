package com.example.demo;
public class MainCalculadora {
    public static void main(String[] args) {

        // Creamos una instancia para cada operación
        SumaThread suma = new SumaThread(8, 4);
        RestaThread resta = new RestaThread(10, 3);
        MultiplicacionThread multiplicacion = new MultiplicacionThread(6, 7);
        DivisionThread division = new DivisionThread(20, 4);

        // Iniciamos los hilos (cada uno se ejecuta en paralelo)
        suma.start();
        resta.start();
        multiplicacion.start();
        division.start();
    }
}
