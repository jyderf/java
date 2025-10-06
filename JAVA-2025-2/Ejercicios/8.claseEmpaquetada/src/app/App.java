package app;
import modelo.Persona;

public class App {
    public static void main(String[] args) {

        Persona p = new Persona("Ana");
        System.out.println("Nombre: " + p.getNombre());
    }
}