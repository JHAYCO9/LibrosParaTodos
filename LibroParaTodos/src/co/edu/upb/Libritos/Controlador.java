package co.edu.upb.Libritos;

import java.util.List;

public class Controlador {
    private Libreria libreria;
    private Vista vista;
    
    public Controlador() {
        libreria = new Libreria();
        vista = new Vista();
    }
    
    public void ejecutar() {
        boolean salir = false;
        
        while (!salir) {
            int opcion = mostrarMenu();
            
            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    reservarLibro();
                    break;
                case 3:
                    actualizarDisponibilidad();
                    break;
                case 4:
                    comprarLibro();
                    break;
                case 5:
                    agregarLibro();
                    break;
                case 6:
                    devolverLibro();
                    break;
                case 7:
                    eliminarLibro();
                    break;
                case 8:
                    buscarLibroPorAutor();
                    break;
                case 9:
                    verInformeVentas();
                    break;
                case 10:
                    recibirRecomendaciones();
                    break;
                case 11:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
    
    private int mostrarMenu() {
        vista.mostrarMenu();
        int opcion = vista.obtenerOpcion();
        return opcion;
    }
    
    private void buscarLibroPorTitulo() {
        String titulo = vista.obtenerTitulo();
        List<Libro> librosEncontrados = libreria.buscarLibrosPorTitulo(titulo);
        vista.mostrarLibros(librosEncontrados);
    }
    
    private void reservarLibro() {
        String titulo = vista.obtenerTitulo();
        List<Libro> librosEncontrados = libreria.buscarLibrosPorTitulo(titulo);
        vista.mostrarLibros(librosEncontrados);
        
        if (!librosEncontrados.isEmpty()) {
            int opcion = vista.obtenerLibroReserva();
            
            if (opcion >= 0 && opcion < librosEncontrados.size()) {
                Libro libroReservado = librosEncontrados.get(opcion);
                libroReservado.setDisponible(false);
                System.out.println("Libro reservado con éxito.");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
    
    private void actualizarDisponibilidad() {
        String titulo = vista.obtenerTitulo();
        List<Libro> librosEncontrados = libreria.buscarLibrosPorTitulo(titulo);
        vista.mostrarLibros(librosEncontrados);
        
        if (!librosEncontrados.isEmpty()) {
            int opcion = vista.obtenerLibroDisponibilidad();
            
            if (opcion >= 0 && opcion < librosEncontrados.size()) {
                Libro libroActualizado = librosEncontrados.get(opcion);
                boolean disponible = vista.obtenerNuevaDisponibilidad();
                libroActualizado.setDisponible(disponible);
                System.out.println("Disponibilidad actualizada con éxito.");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
    
    private void comprarLibro() {
        String titulo = vista.obtenerTitulo();
        List<Libro> librosEncontrados = libreria.buscarLibrosPorTitulo(titulo);
        vista.mostrarLibros(librosEncontrados);
        
        if (!librosEncontrados.isEmpty()) {
            int opcion = vista.obtenerLibroCompra();
            
            if (opcion >= 0 && opcion < librosEncontrados.size()) {
                Libro libroComprado = librosEncontrados.get(opcion);
                if (libroComprado.isDisponible()) { 
                    libroComprado.setDisponible(false);
                    System.out.println("Libro comprado con éxito.");
                } else {
                    System.out.println("El libro no está disponible para la compra.");
                }
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
    
    private void agregarLibro() {
        String titulo = vista.obtenerTitulo();
        String autor = vista.obtenerAutor();
        boolean disponible = vista.obtenerDisponibilidad(); 
        
        Libro nuevoLibro = new Libro (titulo, autor, disponible);
        libreria.agregarLibro(nuevoLibro);
        
        System.out.println("Libro agregado con éxito.");
    }
    
    private void devolverLibro() {
        String titulo = vista.obtenerTitulo();
        List<Libro> librosEncontrados = libreria.buscarLibrosPorTitulo(titulo);
        vista.mostrarLibros(librosEncontrados);
        
        if (!librosEncontrados.isEmpty()) {
            int opcion = vista.obtenerLibroDevolucion();
            
            if (opcion >= 0 && opcion < librosEncontrados.size()) {
                Libro libroDevuelto = librosEncontrados.get(opcion);
                libroDevuelto.setDisponible(true);
                System.out.println("Libro devuelto con éxito.");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
    
    private void eliminarLibro() {
        String titulo = vista.obtenerTitulo();
        List<Libro> librosEncontrados = libreria.buscarLibrosPorTitulo(titulo);
        vista.mostrarLibros(librosEncontrados);
        
        if (!librosEncontrados.isEmpty()) {
            int opcion = vista.obtenerLibroEliminacion(); 
            
            if (opcion >= 0 && opcion < librosEncontrados.size()) {
                Libro libroEliminado = librosEncontrados.get(opcion);
                libreria.eliminarLibro(libroEliminado);
                System.out.println("Libro eliminado con éxito.");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
    
    private void buscarLibroPorAutor() {
        String autor = vista.obtenerAutor();
        List<Libro> librosEncontrados = libreria.buscarLibrosPorAutor(autor);
        vista.mostrarLibros(librosEncontrados);
    }
    
    private void verInformeVentas() {
        // Lógica para generar y mostrar el informe de ventas
    }
    
    private void recibirRecomendaciones() {
        // Lógica para generar y mostrar recomendaciones de libros basadas en compras anteriores
    }
}
