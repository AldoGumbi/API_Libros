package com.challengespring.ChallengeLibros.repository;

import com.challengespring.ChallengeLibros.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface LibrosRepository extends JpaRepository<Libros, Long> {

    List<Libros> findByIdiomas(String idioma);
    List<Libros> findByTitulo(String titulo);



}