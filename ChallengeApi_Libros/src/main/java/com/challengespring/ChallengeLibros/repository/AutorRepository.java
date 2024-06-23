package com.challengespring.ChallengeLibros.repository;

import com.challengespring.ChallengeLibros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a " +
            "WHERE a.fechaNacimiento <= :anio " +
            "AND (a.fechaFallecimiento > :anio OR a.fechaFallecimiento IS NULL)")
    List<Autor> autoresVivosPorAnio(@Param("anio") String anio);



}