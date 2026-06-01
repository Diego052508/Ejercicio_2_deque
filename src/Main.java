import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Deque<String> atras = new ArrayDeque<>();
        Deque<String> adelante = new ArrayDeque<>();

        String paginaActual = "Google";
        int opcion;

        System.out.println("=== NAVEGADOR WEB ===");
        System.out.println("Página inicial: " + paginaActual);

        do {

            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Visitar nueva página");
            System.out.println("2. Retroceder");
            System.out.println("3. Avanzar");
            System.out.println("4. Mostrar historial");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el nombre de la página: ");
                    String nuevaPagina = sc.nextLine();

                    atras.addFirst(paginaActual);
                    paginaActual = nuevaPagina;

                    // Se borra el historial de avance
                    adelante.clear();

                    System.out.println("Visitando: " + paginaActual);
                    break;

                case 2:
                    if (atras.isEmpty()) {
                        System.out.println("No hay páginas para retroceder.");
                    } else {
                        adelante.addFirst(paginaActual);
                        paginaActual = atras.removeFirst();

                        System.out.println("Retrocediendo a: " + paginaActual);
                    }
                    break;

                case 3:
                    if (adelante.isEmpty()) {
                        System.out.println("No hay páginas para avanzar.");
                    } else {
                        atras.addFirst(paginaActual);
                        paginaActual = adelante.removeFirst();

                        System.out.println("Avanzando a: " + paginaActual);
                    }
                    break;

                case 4:
                    System.out.println("\n===== HISTORIAL =====");
                    System.out.println("Página actual: " + paginaActual);
                    System.out.println("Páginas atrás: " + atras);
                    System.out.println("Páginas adelante: " + adelante);
                    break;
                case 0:
                    System.out.println("Saliendo del navegador...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}