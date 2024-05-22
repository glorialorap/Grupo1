import java.util.ArrayList;
import java.util.Scanner;

public class AgendaTelefonica {
    private static ArrayList<Contacto> agenda; // Declara un ArrayList estático para contener objetos de tipo Contacto.

    public static void main(String[] args) {
        agenda = ManejadorAgenda.cargarAgenda(); // Llama a un método para cargar los datos de la agenda.
        Scanner scanner = new Scanner(System.in); // Inicializa un objeto Scanner para la entrada del usuario.
        int opcion; // Declara una variable entera para contener la elección del usuario.

        do {
            System.out.println("\nAGENDA TELEFÓNICA"); // Imprime un título de menú.
            System.out.println("1. Agregar Contacto"); // Imprime las opciones del menú.
            System.out.println("2. Eliminar Contacto");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Modificar Contacto");
            System.out.println("5. Mostrar Todos los Contactos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: "); // Solicita al usuario que elija una opción.
            opcion = scanner.nextInt(); // Lee la entrada del usuario.
            scanner.nextLine(); // Limpia el buffer de entrada.

            switch (opcion) {
                case 1:
                    ManejadorAgenda.agregarContacto(agenda, scanner); // Llama al método para agregar un contacto.
                    break;
                case 2:
                    ManejadorAgenda.eliminarContacto(agenda, scanner); // Llama al método para eliminar un contacto.
                    break;
                case 3:
                    ManejadorAgenda.buscarContacto(agenda, scanner); // Llama al método para buscar un contacto.
                    break;
                case 4:
                    ManejadorAgenda.modificarContacto(agenda, scanner); // Llama al método para modificar un contacto.
                    break;
                case 5:
                    ManejadorAgenda.mostrarContactos(agenda); // Llama al método para mostrar todos los contactos.
                    break;
                case 6:
                    ManejadorAgenda.guardarAgenda(agenda); // Llama al método para guardar los datos de la agenda.
                    System.out.println("Saliendo..."); // Imprime un mensaje de salida.
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo."); // Imprime un mensaje de opción inválida.
            }
        } while (opcion != 6); // Itera hasta que el usuario elija salir.
    }
}