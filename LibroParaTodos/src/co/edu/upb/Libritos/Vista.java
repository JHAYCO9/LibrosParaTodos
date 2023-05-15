package co.edu.upb.Libritos;

import java.util.List;
import java.util.Scanner;

public class Vista {
    private Scanner scanner;
    
    public Vista() {
        scanner = new Scanner(System.in);
    }
    
    public String obtenerTitulo() {
        System.out.print("Ingrese el título del libro: ");
        return scanner.nextLine();
    }
    
    public String obtenerAutor() {
        System.out.print("Ingrese el autor del libro: ");
        return scanner.nextLine();
    }
    
    public int mostrarMenu() {
        System.out.println("---- Menú ----");
        System.out.println("1. Buscar libro por título");
        System.out.println("2. Reservar libro");
        System.out.println("3. Actualizar disponibilidad de libro");
        System.out.println("4. Comprar libro");
        System.out.println("5. Agregar libro");
        System.out.println("6. Devolver libro");
        System.out.println("7. Eliminar libro");
        System.out.println("8. Buscar libro por autor");
        System.out.println("9. Ver informe de ventas");
        System.out.println("10. Recibir recomendaciones");
        System.out.println("11. Salir");
        System.out.print("Ingrese la opción deseada: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        
        return opcion;
    }

    public int obtenerOpcion() {
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return opcion;
    }
    
    public int obtenerLibroReserva() {
        System.out.print("Seleccione el libro que desea reservar (ingrese el número correspondiente): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return opcion - 1; // Restar 1 para obtener el índice correcto en la lista de libros
    }
    
    public int obtenerLibroEliminacion() {
        System.out.print("Seleccione el libro a eliminar (Ingrese el número correspondiente): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return opcion - 1; // Restar 1 para ajustar al índice de la lista
    }
    
    public int obtenerLibroDisponibilidad() {
        System.out.print("Seleccione el libro cuya disponibilidad desea actualizar (ingrese el número correspondiente): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return opcion - 1; // Restar 1 para obtener el índice correcto en la lista de libros
    }
    
    public boolean obtenerNuevaDisponibilidad() {
        System.out.print("Ingrese la nueva disponibilidad (true/false): ");
        boolean disponibilidad = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return disponibilidad;
    }
    
    public boolean obtenerDisponibilidad() {
        System.out.print("Ingrese la disponibilidad del libro (true/false): ");
        boolean disponibilidad = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return disponibilidad;
    }
    
    public int obtenerLibroCompra() {
        System.out.print("Seleccione el libro a comprar (Ingrese el número correspondiente): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return opcion - 1; // Restar 1 para ajustar al índice de la lista
    }
    
    public int obtenerLibroDevolucion() {
        System.out.print("Seleccione el libro a devolver (Ingrese el número correspondiente): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        return opcion - 1; // Restar 1 para ajustar al índice de la lista
    }
    
    public void mostrarLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros.");
        } else {
            System.out.println("Libros encontrados:");
            for (Libro libro : libros) {
                System.out.println("Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor());
            }
        }
    }
    
    // Otros métodos de la vista según sea necesario
}
