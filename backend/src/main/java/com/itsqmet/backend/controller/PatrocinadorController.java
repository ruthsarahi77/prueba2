package com.itsqmet.backend.controller;

import com.itsqmet.backend.model.Patrocinador;
import com.itsqmet.backend.service.PatrocinadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrocinadores")
@CrossOrigin(origins = "*")
public class PatrocinadorController {

    @Autowired
    private PatrocinadorService patrocinadorService;

    @PostMapping
    public Patrocinador crear(@Valid @RequestBody Patrocinador patrocinador) {
        return patrocinadorService.crear(patrocinador);
    }

    @GetMapping
    public List<Patrocinador> listarTodos() {
        return patrocinadorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Patrocinador> obtenerPorId(@PathVariable Long id) {
        return patrocinadorService.obtenerPorId(id);
    }

    @GetMapping("/monto")
    public List<Patrocinador> buscarPorMonto(Double minimo, Double maximo) {
        return patrocinadorService.buscarPorMonto(minimo, maximo);
    }

    @PutMapping("/{id}")
    public Optional<Patrocinador> actualizar(@PathVariable Long id, @Valid @RequestBody Patrocinador patrocinador) {
        return patrocinadorService.actualizar(id, patrocinador);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return patrocinadorService.eliminar(id);
    }
}