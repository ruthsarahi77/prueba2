package com.itsqmet.backend.service;

import com.itsqmet.backend.model.Patrocinador;
import com.itsqmet.backend.repository.PatrocinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadorService {

    @Autowired
    private PatrocinadorRepository patrocinadorRepository;

    public List<Patrocinador> obtenerTodos() {
        return patrocinadorRepository.findAll();
    }

    public Optional<Patrocinador> obtenerPorId(Long id) {
        return patrocinadorRepository.findById(id);
    }

    public Patrocinador crear(Patrocinador patrocinador) {
        return patrocinadorRepository.save(patrocinador);
    }

    public Optional<Patrocinador> actualizar(Long id, Patrocinador datos) {
        return patrocinadorRepository.findById(id).map(p -> {
            p.setEmpresa(datos.getEmpresa());
            p.setSector(datos.getSector());
            p.setMontoAporte(datos.getMontoAporte());
            p.setEventos(datos.getEventos());

            return patrocinadorRepository.save(p);
        });
    }

    public boolean eliminar(Long id) {
        if (patrocinadorRepository.existsById(id)) {
            patrocinadorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Patrocinador> buscarPorMonto(Double minimo, Double maximo) {
        return patrocinadorRepository.findByMontoAporteBetweenOrderByMontoAporteDesc(minimo, maximo);
    }
}