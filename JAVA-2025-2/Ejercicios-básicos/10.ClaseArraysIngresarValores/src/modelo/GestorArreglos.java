package modelo;
import java.util.Scanner;

public class GestorArreglos {
    private int[] numeros;
    private String[] nombres;

    // Constructor
    public GestorArreglos(int tamNumeros, int tamNombres) {
        numeros = new int[tamNumeros];
        nombres = new String[tamNombres];
    }

    // Método para llenar números
    public void ingresarNumeros(Scanner sc) {
        System.out.println("=== Ingreso de números ===");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese un número en la posición " + i + ": ");
            numeros[i] = sc.nextInt();
        }
    }

    // Método para llenar nombres
    public void ingresarNombres(Scanner sc) {
        sc.nextLine(); // limpiar buffer
        System.out.println("\n=== Ingreso de nombres ===");
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese un nombre en la posición " + i + ": ");
            nombres[i] = sc.nextLine();
        }
    }

    // Mostrar números
    public void mostrarNumeros() {
        System.out.println("\n--- Números ingresados ---");
        for (int num : numeros) {
            System.out.println(num);
        }
    }

    // Mostrar nombres
    public void mostrarNombres() {
        System.out.println("\n--- Nombres ingresados ---");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
