package modelo;

public class Arreglo {
    private int[] numeros;
    private String[] nombres;

    // Constructor: inicializa los arreglos
    public Arreglo() {
        numeros = new int[]{10, 20, 30, 40, 50};
        nombres = new String[]{"Ana", "Luis", "Maria", "Pedro"};
    }

    // Método para mostrar los números
    public void mostrarNumeros() {
        System.out.println("Números del arreglo:");
        for (int num : numeros) {
            System.out.println(num);
        }
    }

    // Método para mostrar los nombres
    public void mostrarNombres() {
        System.out.println("Nombres del arreglo:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}
