package com.itsqmet.backend.service;

import com.itsqmet.backend.model.PerfilPonente;
import com.itsqmet.backend.repository.PerfilPonenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilPonenteService {

    @Autowired
    private PerfilPonenteRepository perfilPonenteRepository;

    public List<PerfilPonente> obtenerTodos() {
        return perfilPonenteRepository.findAll();
    }

    public Optional<PerfilPonente> obtenerPorId(Long id) {
        return perfilPonenteRepository.findById(id);
    }

    public PerfilPonente crear(PerfilPonente perfilPonente) {
        return perfilPonenteRepository.save(perfilPonente);
    }

    public Optional<PerfilPonente> actualizar(Long id, PerfilPonente datos) {
        return perfilPonenteRepository.findById(id).map(p -> {
            p.setBiografia(datos.getBiografia());
            p.setLinkedin(datos.getLinkedin());
            p.setPaginaWeb(datos.getPaginaWeb());
            p.setPonente(datos.getPonente());

            return perfilPonenteRepository.save(p);
        });
    }

    public boolean eliminar(Long id) {
        if (perfilPonenteRepository.existsById(id)) {
            perfilPonenteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}