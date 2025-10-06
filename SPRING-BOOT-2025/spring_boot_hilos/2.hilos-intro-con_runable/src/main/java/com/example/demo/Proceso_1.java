package com.example.demo;

public class Proceso_1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(" proceso 1");
        }
    }
}
