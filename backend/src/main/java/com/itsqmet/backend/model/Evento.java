package com.itsqmet.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del evento es obligatorio")
    @Size(min = 5, max = 150, message = "El nombre del evento debe tener entre 5 y 150 caracteres")
    private String nombre;

    @NotBlank(message = "El tipo de evento es obligatorio")
    private String tipo;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha debe ser actual o futura")
    private LocalDate fecha;

    @NotNull(message = "La capacidad es obligatoria")
    @Min(value = 1, message = "La capacidad debe ser mínimo de 1 persona")
    private Integer capacidad;

    @ManyToOne
    @JoinColumn(name = "ponente_id", nullable = false)
    @JsonIgnoreProperties("eventos")
    private Ponente ponente;

    @ManyToMany
    @JoinTable(
            name = "evento_patrocinador",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "patrocinador_id")
    )
    @JsonIgnoreProperties("eventos")
    private List<Patrocinador> patrocinadores;
}