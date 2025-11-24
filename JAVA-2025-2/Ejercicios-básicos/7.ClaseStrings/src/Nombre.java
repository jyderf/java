public class Nombre {
    private String texto;

    // Constructor
    public Nombre(String texto) {
        this.texto = texto;
    }

    // Método para devolver el nombre en mayúsculas
    public String enMayusculas() {
        return texto.toUpperCase();
    }

    // Método para devolver el nombre en minúsculas
    public String enMinusculas() {
        return texto.toLowerCase();
    }

    // Método para obtener la cantidad de letras
    public int longitud() {
        return texto.length();
    }
}
