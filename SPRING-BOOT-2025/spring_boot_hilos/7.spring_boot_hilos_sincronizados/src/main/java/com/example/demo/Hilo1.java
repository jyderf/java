package com.example.demo;

public class Hilo1 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.print("S");

            try{
                Hilo1.sleep(1000);

            }catch (InterruptedException e){
                System.out.println("Error en el hilo1 " + e);
            }
        }
    }
}
