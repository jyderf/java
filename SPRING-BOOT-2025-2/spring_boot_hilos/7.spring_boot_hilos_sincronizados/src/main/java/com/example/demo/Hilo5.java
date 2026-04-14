package com.example.demo;

public class Hilo5 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("A");
            try{
                Hilo5.sleep(1000);

            }catch (InterruptedException e){
                System.out.println("Error en el hilo5 " + e);
            }
        }
    }
}