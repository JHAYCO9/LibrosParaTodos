package co.edu.upb.Libritos;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
	
    private List<Libro> libros;
    
    public Libreria() {
        libros = new ArrayList<>();
    }
    
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    
    public void eliminarLibro(Libro libro) {
        libros.remove(libro);
    }
    
    public List<Libro> buscarLibrosPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(libro);
            }
        }
        
        return resultados;
    }
    
    public List<Libro> buscarLibrosPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        
        for (Libro libro : libros) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro);
            }
        }
        
        return resultados;
    }
    
    // Otros métodos del modelo según sea necesario
}

