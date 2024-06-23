package com.challengespring.ChallengeLibros.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name="libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private String idiomas;
    private Double numeroDescarga;
    @ManyToOne
    private Autor autor;

    public Libros(){}

    public Libros(Optional<DatosLibros> datosLibros) {
        if (datosLibros.isPresent()) {
            DatosLibros datos = datosLibros.get();
            this.titulo = datos.titulo();
            this.idiomas = String.join(",", datos.idiomas());
            this.numeroDescarga = datos.numeroDescargas();
        }
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autores) {
        this.autor = autores;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDescarga() {
        return numeroDescarga;
    }

    public void setNumeroDescarga(Double numeroDescarga) {
        this.numeroDescarga = numeroDescarga;
    }

    @Override
    public String toString() {
        return String.format("""
                        \n---------   Libro    ---------
                        \tTitulo: %s
                        \tAutor: %s
                        \tIdiomas: %s
                        \tDescargas: %s""",
                titulo, autor.getNombre(), idiomas, numeroDescarga);
    }
}
