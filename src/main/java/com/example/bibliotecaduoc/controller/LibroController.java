package com.example.bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotecaduoc.Service.LibroService;
import com.example.bibliotecaduoc.model.libro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@Service
@RestController
@RequestMapping("/api/v1/libros")

public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<libro> listaLibros(){
        return libroService.getLibros();

    }


    @PostMapping
    public libro agregaLibro(@RequestBody libro libro) {        
        return libroService.saveLibro(libro);
    }
    
        
    @GetMapping("{id}")
    public libro buscaLibro(@PathVariable int id) {
        return libroService.getLibroId(id);
    }

    @PutMapping("{id}")
    public libro actualizaLibro(@PathVariable int id, @RequestBody libro libro) {
        //EL id se usara mas adelante
        
        return libroService.updateLibro(libro);

    }
    

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.deleteLibro(id);

    }
    

    //comentario bkn

}
