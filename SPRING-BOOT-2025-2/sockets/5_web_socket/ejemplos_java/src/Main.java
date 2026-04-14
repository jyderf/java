//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner  sc = new Scanner(System.in);

        int[] numeros = new int[5];


       System.out.println("Ingrese 5 números: ");

       for(int i=0;i<numeros.length;i++){

           System.out.println("Numero" + (i+1)  + ": ");

           numeros[i] = sc.nextInt();

       }

       System.out.println("\n Los números ingresados son:");

       for(int i=0;i<numeros.length;i++){

           System.out.println("Posicion " + (i+1) + " = " + numeros[i]);
       }




        sc.close();
    }
}