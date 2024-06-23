package com.challengespring.ChallengeLibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaNacimiento,
        @JsonAlias("death_year") String fechaFallecimiento
) {

    @Override
    public String fechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public String fechaFallecimiento() {
        return fechaFallecimiento;
    }
}
