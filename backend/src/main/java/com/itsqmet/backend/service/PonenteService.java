package com.itsqmet.backend.service;

import com.itsqmet.backend.model.Ponente;
import com.itsqmet.backend.repository.PonenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PonenteService {

    @Autowired
    private PonenteRepository ponenteRepository;

    public List<Ponente> obtenerTodos() {
        return ponenteRepository.findAll();
    }

    public Optional<Ponente> obtenerPorId(Long id) {
        return ponenteRepository.findById(id);
    }

    public Ponente crear(Ponente ponente) {
        return ponenteRepository.save(ponente);
    }

    public Optional<Ponente> actualizar(Long id, Ponente datos) {
        return ponenteRepository.findById(id).map(p -> {
            p.setNombre(datos.getNombre());
            p.setEspecialidad(datos.getEspecialidad());
            p.setEmail(datos.getEmail());
            p.setAnosExperiencia(datos.getAnosExperiencia());

            return ponenteRepository.save(p);
        });
    }

    public boolean eliminar(Long id) {
        if (ponenteRepository.existsById(id)) {
            ponenteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Ponente> buscarPorEspecialidad(String especialidad) {
        return ponenteRepository.findByEspecialidadContainingIgnoreCase(especialidad);
    }
}