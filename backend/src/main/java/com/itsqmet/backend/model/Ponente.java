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
@Table(name = "ponentes")

public class Ponente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ingresar un formato de correo electrónico válido")
    private String email;

    @NotNull(message = "Los años de experiencia son obligatorios")
    @Min(value = 0, message = "Los años de experiencia deben ser mayores o iguales a 0")
    private Integer anosExperiencia;

    @OneToOne(mappedBy = "ponente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("ponente")
    private PerfilPonente perfilPonente;

    @OneToMany(mappedBy = "ponente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("ponente")
    private List<Evento> eventos;
}