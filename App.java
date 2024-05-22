import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contacto> contacts = new ArrayList<>();

        System.out.print("Ingrese el número de registros: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume la nueva línea después del entero

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese los datos del contacto " + (i + 1) + ":");
            System.out.print("Primer nombre: ");
            String firstName = scanner.nextLine();
            System.out.print("Apellidos: ");
            String lastName = scanner.nextLine();
            System.out.print("Número telefónico: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Dirección: ");
            String address = scanner.nextLine();

            contacts.add(new Contacto(firstName, lastName, phoneNumber, address));
        }

        System.out.println("\nAPELLIDOS     | NOMBRE       | TELEFONO     | DIRECCION");
        for (Contacto contact : contacts) {
            System.out.println(contact);
        }
        System.out.println("Total de registros: " + contacts.size());
    }
}