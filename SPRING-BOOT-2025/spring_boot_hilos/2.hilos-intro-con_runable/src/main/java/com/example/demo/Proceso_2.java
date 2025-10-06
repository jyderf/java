package com.example.demo;

public class Proceso_2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println( " proceso 2");
        }
    }
}
