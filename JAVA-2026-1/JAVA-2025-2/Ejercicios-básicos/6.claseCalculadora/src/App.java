package src;

public class App {

    public static void main(String[] args) {
        // Crear un objeto de la clase Calculadora
        Calculadora calc = new Calculadora();

        // Usar los métodos
        System.out.println("Suma: " + calc.sumar(10, 5));
        System.out.println("Resta: " + calc.restar(10, 5));
        System.out.println("Multiplicación: " + calc.multiplicar(10, 5));
        System.out.println("División: " + calc.dividir(10, 5));
    }
}
