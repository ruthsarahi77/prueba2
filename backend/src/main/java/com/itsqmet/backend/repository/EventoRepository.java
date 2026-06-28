package com.itsqmet.backend.repository;

import com.itsqmet.backend.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByTipoOrderByNombreAsc(String tipo);
    List<Evento> findByCapacidadGreaterThanEqualAndPonenteId(Integer capacidad, Long ponenteId);
    List<Evento> findByPonenteIdOrderByFechaDesc(Long ponenteId);
}