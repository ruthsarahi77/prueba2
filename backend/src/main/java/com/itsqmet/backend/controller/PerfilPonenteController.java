package com.itsqmet.backend.controller;

import com.itsqmet.backend.model.PerfilPonente;
import com.itsqmet.backend.service.PerfilPonenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfiles-ponentes")
@CrossOrigin(origins = "*")
public class PerfilPonenteController {

    @Autowired
    private PerfilPonenteService perfilPonenteService;

    @PostMapping
    public PerfilPonente crear(@Valid @RequestBody PerfilPonente perfilPonente) {
        return perfilPonenteService.crear(perfilPonente);
    }

    @GetMapping
    public List<PerfilPonente> listarTodos() {
        return perfilPonenteService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<PerfilPonente> obtenerPorId(@PathVariable Long id) {
        return perfilPonenteService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Optional<PerfilPonente> actualizar(@PathVariable Long id, @Valid @RequestBody PerfilPonente perfilPonente) {
        return perfilPonenteService.actualizar(id, perfilPonente);
    }

    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return perfilPonenteService.eliminar(id);
    }
}