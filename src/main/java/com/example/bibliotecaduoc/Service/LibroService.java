package com.example.bibliotecaduoc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service

public class LibroService {
    @Autowired
    private LibroRepository libroRepository;



    public List<libro> getLibros(){
        return libroRepository.obtenerLibros();

    }

    public libro saveLibro(libro libro){
        return libroRepository.guardaLibro(libro);


    }


    public libro getLibroId(int id){
        return libroRepository.buscarPorId(id);

    }


    public libro updateLibro(libro libro){
        return libroRepository.actualizar(libro);

    }

    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "Producto eliminado";

    }
    // La accion la ace el service
    public int totaLibros(){
        return libroRepository.obtenerLibros().size();
    }
    // la accion la hace
    public int totaLibrosV2(){
        return libroRepository.totaLibros();
    }

    public libro porIsbn(String isnb){
        return libroRepository.porIsbn(isnb);
    }

    public int cantidadLibrosPorAño(int anio){
        return libroRepository.cantidadLibrosPorAño(anio);
    }

    public List<libro> obtenerPorAutor(String autor){
        return libroRepository.obtenerPorAutor(autor);
    }

    public List<libro> ordenarPorAnio(){
        return libroRepository.ordenarPorAnio();
    }

}
