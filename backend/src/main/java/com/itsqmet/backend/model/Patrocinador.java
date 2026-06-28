package com.itsqmet.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patrocinadores")
public class Patrocinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre de la empresa debe tener entre 2 y 100 caracteres")
    private String empresa;

    @NotBlank(message = "El sector es obligatorio")
    private String sector;

    @NotNull(message = "Monto de patrocinio obligatorio")
    @Positive(message = "El monto de patrocinio debe ser mayor a 0")
    private Double montoAporte;

    @ManyToMany(mappedBy = "patrocinadores")
    @JsonIgnoreProperties("patrocinadores")
    private List<Evento> eventos;
}