package com.itsqmet.backend.controller;

import com.itsqmet.backend.model.Ponente;
import com.itsqmet.backend.service.PonenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ponentes")
@CrossOrigin(origins = "*")
public class PonenteController {

    @Autowired
    private PonenteService ponenteService;

    @PostMapping
    public Ponente crear(@Valid @RequestBody Ponente ponente) {
        return ponenteService.crear(ponente);
    }

    @GetMapping
    public List<Ponente> listarTodos() {
        return ponenteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Ponente> obtenerPorId(@PathVariable Long id) {
        return ponenteService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Optional<Ponente> actualizar(@PathVariable Long id, @Valid @RequestBody Ponente ponente) {
        return ponenteService.actualizar(id, ponente);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<Ponente> buscarPorEspecialidad(@PathVariable String especialidad) {
        return ponenteService.buscarPorEspecialidad(especialidad);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return ponenteService.eliminar(id);
    }

}