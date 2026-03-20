package com.example.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //genera getters, setters, toString, equals y hashCode y un constructor en los campos requeridos.
@AllArgsConstructor //genera un constructor con todos los campos de la clase.
@NoArgsConstructor //genera un constructor sin argumentos.

public class libro {
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;

}
