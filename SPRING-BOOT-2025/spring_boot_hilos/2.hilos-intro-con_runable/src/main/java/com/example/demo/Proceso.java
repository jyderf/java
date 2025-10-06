package com.example.demo;

public class Proceso extends Thread {

    int num_int;



    @Override
    public void run() {
        for (int i = 1; i <= num_int; i++) {
            System.out.println(i + this.getName());
        }
        System.out.println("");
    }
    public void valorDeLaCondicion(int valor){
        this.num_int = valor;
    }


}
