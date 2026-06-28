package com.itsqmet.backend.service;

import com.itsqmet.backend.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class PdfService {

    private final EventoRepository eventoRepository;

    public PdfService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public ByteArrayInputStream generarReporteEventos() {
        var eventos = eventoRepository.findAll();

        StringBuilder texto = new StringBuilder();
        texto.append("REPORTE DE EVENTOS\n\n");

        for (var e : eventos) {
            texto.append("ID: ").append(e.getId()).append("\n");
            texto.append("Nombre: ").append(e.getNombre()).append("\n");
            texto.append("Tipo: ").append(e.getTipo()).append("\n\n");
        }

        return new ByteArrayInputStream(texto.toString().getBytes());
    }
}