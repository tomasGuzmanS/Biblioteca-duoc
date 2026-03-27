package com.example.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.bibliotecaduoc.model.libro;

@Repository
public class LibroRepository {
    //arreglo para guardar todos los libros
    private List<libro> listaLibros= new ArrayList<>();

    public LibroRepository(){
        listaLibros.add(new libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new libro(7, "9780321127426", "Effective Java", "AddisonWesley", 2008, "Joshua Bloch"));
        listaLibros.add(new libro(8, "9780134685991", "Clean Architecture", "Prentice Hall", 2017, "Robert C. Martin"));
        listaLibros.add(new libro(9, "9780201633610", "Design Patterns", "AddisonWesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new libro(10, "9780132350884", "Clean Code", "Prentice Hall",2008, "Robert C. Martin"));

    }

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
