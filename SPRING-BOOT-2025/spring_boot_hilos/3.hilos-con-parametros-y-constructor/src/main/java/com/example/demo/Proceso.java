package com.example.demo;

public class Proceso extends Thread {

    int num_int;
    @Override
    public void run() {
        for (int i = 1; i <= num_int; i++) {
            System.out.println(i + this.getName());
        }
    }

    public void valorDeLaCondicion(int num_int) {
        this.num_int = num_int;
    }


}
