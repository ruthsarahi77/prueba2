package com.itsqmet.backend.controller;

import com.itsqmet.backend.model.Evento;
import com.itsqmet.backend.service.EventoService;
import com.itsqmet.backend.service.PdfService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private PdfService pdfService;

    @PostMapping
    public Evento crear(@Valid @RequestBody Evento evento) {
        return eventoService.crear(evento);
    }

    @GetMapping
    public List<Evento> listarTodos() {
        return eventoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Evento> obtenerPorId(@PathVariable Long id) {
        return eventoService.obtenerPorId(id);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Evento> buscarPorTipo(@PathVariable String tipo){
        return eventoService.buscarPorTipo(tipo);
    }

    @GetMapping("/capacidad/{capacidad}/ponente/{ponenteId}")
    public List<Evento> buscarPorCapacidadYPonente(@PathVariable Integer capacidad,
                                                   @PathVariable Long ponenteId) {
        return eventoService.buscarPorCapacidadYPonente(capacidad, ponenteId);
    }

    @GetMapping("/ponente/{ponenteId}")
    public List<Evento> buscarPorPonente(@PathVariable Long ponenteId) {
        return eventoService.buscarPorPonente(ponenteId);
    }

    @PutMapping("/{id}")
    public Optional<Evento> actualizar(@PathVariable Long id, @Valid @RequestBody Evento evento) {
        return eventoService.actualizar(id, evento);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return eventoService.eliminar(id);
    }

    @GetMapping("/reporte/pdf")
    public ResponseEntity<byte[]> generarReporte() {
        ByteArrayInputStream pdf = pdfService.generarReporteEventos();

        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=reporte.pdf")
                .body(pdf.readAllBytes());
    }

}