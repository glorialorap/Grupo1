import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Define la clase ManejadorAgenda para gestionar las operaciones de la agenda.
public class ManejadorAgenda {
    // Nombre del archivo donde se guardará la agenda.
    private static final String FILE_NAME = "agenda.dat";

    // Método para cargar la agenda desde el archivo.
    public static ArrayList<Contacto> cargarAgenda() {
        // Inicializa una nueva ArrayList para la agenda.
        ArrayList<Contacto> agenda = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            // Intenta leer la agenda del archivo.
            agenda = (ArrayList<Contacto>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Maneja la excepción si el archivo no se encuentra.
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            // Maneja cualquier otra excepción durante la carga de la agenda.
            System.out.println("Error al cargar la agenda: " + e.getMessage());
        }
        // Retorna la agenda cargada o una nueva ArrayList si no se pudo cargar.
        return agenda;
    }

    // Método para guardar la agenda en el archivo.
    public static void guardarAgenda(ArrayList<Contacto> agenda) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            // Intenta escribir la agenda en el archivo.
            oos.writeObject(agenda);
        } catch (IOException e) {
            // Maneja la excepción si ocurre un error al guardar la agenda.
            System.out.println("Error al guardar la agenda: " + e.getMessage());
        }
    }

    // Método para agregar un nuevo contacto a la agenda.
    public static void agregarContacto(ArrayList<Contacto> agenda, Scanner scanner) {
        // Solicita al usuario ingresar los detalles del nuevo contacto.
        System.out.println("Ingrese el primer nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese los apellidos:");
        String apellidos = scanner.nextLine();

        System.out.println("Ingrese el número telefónico:");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese la dirección:");
        String direccion = scanner.nextLine();

        // Crea un nuevo objeto Contacto y lo agrega a la agenda.
        agenda.add(new Contacto(nombre, apellidos, telefono, direccion));
    }

    // Método para eliminar un contacto de la agenda.
    public static void eliminarContacto(ArrayList<Contacto> agenda, Scanner scanner) {
        // Solicita al usuario ingresar los apellidos del contacto a eliminar.
        System.out.println("Ingrese los apellidos del contacto a eliminar:");
        String apellidos = scanner.nextLine();

        // Busca el contacto en la agenda por los apellidos.
        Contacto contactoAEliminar = null;
        for (Contacto contacto : agenda) {
            if (contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                contactoAEliminar = contacto;
                break;
            }
        }

        // Si se encuentra el contacto, lo elimina de la agenda.
        if (contactoAEliminar != null) {
            agenda.remove(contactoAEliminar);
            System.out.println("Contacto eliminado.");
        } else {
            // Si no se encuentra, muestra un mensaje de contacto no encontrado.
            System.out.println("Contacto no encontrado.");
        }
    }

    // Método para buscar un contacto en la agenda por los apellidos.
    public static void buscarContacto(ArrayList<Contacto> agenda, Scanner scanner) {
        // Solicita al usuario ingresar los apellidos del contacto a buscar.
        System.out.println("Ingrese los apellidos del contacto a buscar:");
        String apellidos = scanner.nextLine();

        // Busca el contacto en la agenda por los apellidos y lo muestra si se encuentra.
        for (Contacto contacto : agenda) {
            if (contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                System.out.println(contacto);
                return;
            }
        }
        // Si no se encuentra el contacto, muestra un mensaje de contacto no encontrado.
        System.out.println("Contacto no encontrado.");
    }

    // Método para modificar un contacto en la agenda por los apellidos.
    public static void modificarContacto(ArrayList<Contacto> agenda, Scanner scanner) {
        // Solicita al usuario ingresar los apellidos del contacto a modificar.
        System.out.println("Ingrese los apellidos del contacto a modificar:");
        String apellidos = scanner.nextLine();

        // Busca el contacto en la agenda por los apellidos.
        for (Contacto contacto : agenda) {
            if (contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                // Solicita al usuario ingresar los nuevos detalles del contacto.
                System.out.println("Ingrese el nuevo nombre (actual: " + contacto.getNombre() + "):");
                contacto.nombre = scanner.nextLine();

                System.out.println("Ingrese el nuevo número telefónico (actual: " + contacto.getTelefono() + "):");
                contacto.telefono = scanner.nextLine();

                System.out.println("Ingrese la nueva dirección (actual: " + contacto.getDireccion() + "):");
                contacto.direccion = scanner.nextLine();

                // Muestra un mensaje de contacto modificado.
                System.out.println("Contacto modificado.");
                return;
            }
        }
        // Si no se encuentra el contacto, muestra un mensaje de contacto no encontrado.
        System.out.println("Contacto no encontrado.");
    }

    // Método para mostrar todos los contactos en la agenda.
    public static void mostrarContactos(ArrayList<Contacto> agenda) {
        // Imprime encabezados de la tabla de contactos.
        System.out.println("APELLIDOS\t| NOMBRE\t| TELEFONO\t| DIRECCION");
        // Itera sobre la agenda y muestra cada contacto.
        for (Contacto contacto : agenda) {
            System.out.println(contacto);
        }
        // Muestra el total de registros en la agenda.
        System.out.println("Total de registros: " + agenda.size());
    }
}