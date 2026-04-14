package app;
import java.util.Scanner;
import modelo.GestorArreglos;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GestorArreglos gestor = new GestorArreglos(3, 3);

        gestor.ingresarNumeros(sc);
        gestor.ingresarNombres(sc);

        gestor.mostrarNumeros();
        gestor.mostrarNombres();

        sc.close();
    }
}



