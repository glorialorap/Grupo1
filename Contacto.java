import java.io.*;

// Define una clase llamada Contacto, que implementa la interfaz Serializable.
class Contacto implements Serializable {
    // Declara variables de instancia para almacenar la información del contacto.
    String nombre;
    String apellidos;
    String telefono;
    String direccion;

    // Constructor para inicializar el objeto Contacto con la información proporcionada.
    public Contacto(String nombre, String apellidos, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Método getter para obtener el nombre del contacto.
    public String getNombre() {
        return nombre;
    }

    // Método getter para obtener los apellidos del contacto.
    public String getApellidos() {
        return apellidos;
    }

    // Método getter para obtener el teléfono del contacto.
    public String getTelefono() {
        return telefono;
    }

    // Método getter para obtener la dirección del contacto.
    public String getDireccion() {
        return direccion;
    }

    // Sobrescribe el método toString para representar el objeto Contacto como una cadena.
    @Override
    public String toString() {
        // Devuelve una cadena formateada que contiene la información del contacto.
        return apellidos + "\t\t| " + nombre + "\t| " + telefono + "\t| " + direccion;
    }
}