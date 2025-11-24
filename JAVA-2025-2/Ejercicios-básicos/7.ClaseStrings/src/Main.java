//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // Crear objeto de la clase Nombre
        Nombre nombre = new Nombre("Fredy");

        // Usar los métodos
        System.out.println("En mayúsculas: " + nombre.enMayusculas());
        System.out.println("En minúsculas: " + nombre.enMinusculas());
        System.out.println("Cantidad de letras: " + nombre.longitud());
    }
}