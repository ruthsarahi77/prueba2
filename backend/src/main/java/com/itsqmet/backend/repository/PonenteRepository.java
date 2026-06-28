package com.itsqmet.backend.repository;

import com.itsqmet.backend.model.Ponente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PonenteRepository extends JpaRepository<Ponente, Long> {

    List<Ponente> findByEspecialidadContainingIgnoreCase(String especialidad);
}