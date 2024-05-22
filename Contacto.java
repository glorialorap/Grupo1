import java.io.*;

class Contacto implements Serializable {
    String nombre;
    String apellidos;
    String telefono;
    String direccion;

    public Contacto(String nombre, String apellidos, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return apellidos + "\t\t| " + nombre + "\t| " + telefono + "\t| " + direccion;
    }
}