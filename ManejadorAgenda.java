import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManejadorAgenda {
    private static final String FILE_NAME = "agenda.dat";

    public static ArrayList<Contacto> cargarAgenda() {
        ArrayList<Contacto> agenda = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            agenda = (ArrayList<Contacto>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar la agenda: " + e.getMessage());
        }
        return agenda;
    }

    public static void guardarAgenda(ArrayList<Contacto> agenda) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(agenda);
        } catch (IOException e) {
            System.out.println("Error al guardar la agenda: " + e.getMessage());
        }
    }

    public static void agregarContacto(ArrayList<Contacto> agenda, Scanner scanner) {
        System.out.println("Ingrese el primer nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese los apellidos:");
        String apellidos = scanner.nextLine();

        System.out.println("Ingrese el número telefónico:");
        String telefono = scanner.nextLine();

        System.out.println("Ingrese la dirección:");
        String direccion = scanner.nextLine();

        agenda.add(new Contacto(nombre, apellidos, telefono, direccion));
    }

    public static void eliminarContacto(ArrayList<Contacto> agenda, Scanner scanner) {
        System.out.println("Ingrese los apellidos del contacto a eliminar:");
        String apellidos = scanner.nextLine();

        Contacto contactoAEliminar = null;
        for (Contacto contacto : agenda) {
            if (contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                contactoAEliminar = contacto;
                break;
            }
        }

        if (contactoAEliminar != null) {
            agenda.remove(contactoAEliminar);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

    public static void buscarContacto(ArrayList<Contacto> agenda, Scanner scanner) {
        System.out.println("Ingrese los apellidos del contacto a buscar:");
        String apellidos = scanner.nextLine();

        for (Contacto contacto : agenda) {
            if (contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                System.out.println(contacto);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public static void modificarContacto(ArrayList<Contacto> agenda, Scanner scanner) {
        System.out.println("Ingrese los apellidos del contacto a modificar:");
        String apellidos = scanner.nextLine();

        for (Contacto contacto : agenda) {
            if (contacto.getApellidos().equalsIgnoreCase(apellidos)) {
                System.out.println("Ingrese el nuevo nombre (actual: " + contacto.getNombre() + "):");
                contacto.nombre = scanner.nextLine();

                System.out.println("Ingrese el nuevo número telefónico (actual: " + contacto.getTelefono() + "):");
                contacto.telefono = scanner.nextLine();

                System.out.println("Ingrese la nueva dirección (actual: " + contacto.getDireccion() + "):");
                contacto.direccion = scanner.nextLine();

                System.out.println("Contacto modificado.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public static void mostrarContactos(ArrayList<Contacto> agenda) {
        System.out.println("APELLIDOS\t| NOMBRE\t| TELEFONO\t| DIRECCION");
        for (Contacto contacto : agenda) {
            System.out.println(contacto);
        }
        System.out.println("Total de registros: " + agenda.size());
    }
}