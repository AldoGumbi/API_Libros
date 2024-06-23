package com.challengespring.ChallengeLibros.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;
    private String fechaNacimiento;
    private String fechaFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libros> libros;

    public Autor() {}

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaNacimiento = datosAutor.fechaNacimiento();
        this.fechaFallecimiento = datosAutor.fechaFallecimiento();
    }

    // Getters y setters

    public List<String> getLibros() {
        return libros.stream()
                .map(Libros::getTitulo)
                .collect(Collectors.toList());
    }

    public void setLibros(List<Libros> libros) {
        libros.forEach(libro -> libro.setAutor(this));
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(String fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }



    @Override
    public String toString() {
        return String.format("""
                        \n\tAutor: %s
                        \tFecha de Nacimiento: %s
                        \tFecha de fallecimiento: %s
                        \tLibros: %s""",
                nombre, fechaNacimiento, fechaFallecimiento, getLibros());
    }
}
