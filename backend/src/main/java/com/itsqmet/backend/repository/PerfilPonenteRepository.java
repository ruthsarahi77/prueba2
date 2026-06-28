package com.itsqmet.backend.repository;

import com.itsqmet.backend.model.PerfilPonente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilPonenteRepository extends JpaRepository<PerfilPonente, Long> {
}