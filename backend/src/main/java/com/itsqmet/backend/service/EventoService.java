package com.itsqmet.backend.service;

import com.itsqmet.backend.model.Evento;
import com.itsqmet.backend.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> obtenerTodos() {
        return eventoRepository.findAll();
    }

    public List<Evento> buscarPorTipo(String tipo){
        return eventoRepository.findByTipoOrderByNombreAsc(tipo);
    }

    public Optional<Evento> obtenerPorId(Long id) {
        return eventoRepository.findById(id);
    }

    public Evento crear(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Optional<Evento> actualizar(Long id, Evento datos) {
        return eventoRepository.findById(id).map(e -> {
            e.setNombre(datos.getNombre());
            e.setTipo(datos.getTipo());
            e.setFecha(datos.getFecha());
            e.setCapacidad(datos.getCapacidad());
            e.setPonente(datos.getPonente());
            e.setPatrocinadores(datos.getPatrocinadores());

            return eventoRepository.save(e);
        });
    }

    public boolean eliminar(Long id) {
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Evento> buscarPorCapacidadYPonente(Integer capacidad, Long ponenteId) {
        return eventoRepository.findByCapacidadGreaterThanEqualAndPonenteId(capacidad, ponenteId);
    }

    public List<Evento> buscarPorPonente(Long ponenteId) {
        return eventoRepository.findByPonenteIdOrderByFechaDesc(ponenteId);
    }

}