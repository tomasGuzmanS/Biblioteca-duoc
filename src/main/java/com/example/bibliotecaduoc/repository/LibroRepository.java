package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.libro;

@Repository
public class LibroRepository {
    //arreglo para guardar todos los libros
    private List<libro> listaLibros= new ArrayList<>();

    //Metodo que retorna todos los libros
    public List<libro> obtenerLibros(){

        return listaLibros;
    }


    //buscar un libro por su id
    public libro buscarPorId(int id){
        for(libro libro: listaLibros){
            if(libro.getId()==id){
                return libro;

            }

        }
        return null;

    }



    //buscar un libro por su isbn
    public libro porIsbn(String isbn){

        for(libro libro: listaLibros){

            if(libro.getIsbn().equals(isbn)){

                return libro;
            }

        }
        return null;
    }



    //metodo guardar libro
    public libro guardaLibro(libro lib){

        listaLibros.add(lib);
        return lib;
    }


    //metodo para actualizar libros por su id
    public libro actualizar(libro lib){

        int id=0;
        int idPosicion=0;

        for(int i=0;i<listaLibros.size();i++){

            if(listaLibros.get(i).getId()==lib.getId()){

                id=lib.getId();
                idPosicion=i;
            }

        }

        libro libro1=new libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());



        listaLibros.set(idPosicion, libro1);
        return libro1;
    }

    //metodo para eliminar un libro mediante su id
    public void eliminar(int id){
        //alternativa 1 
        libro libro = buscarPorId(id);
        if(libro !=null){

            listaLibros.remove(libro);
        }



        //alternativa 2
        int idPosicion=0;

        for(int i=0;i< listaLibros.size();i++){
            if(listaLibros.get(i).getId()==id){
                idPosicion=i;
                break;

            }

        }
        if(idPosicion>0){
            listaLibros.remove(idPosicion);

        }


        //otra alternativa
        listaLibros.removeIf(x-> x.getId()==id);

    }



}
