package com.itsqmet.backend.repository;

import com.itsqmet.backend.model.Patrocinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatrocinadorRepository extends JpaRepository<Patrocinador, Long> {
    List<Patrocinador> findByMontoAporteBetweenOrderByMontoAporteDesc(Double minimo, Double maximo);
}