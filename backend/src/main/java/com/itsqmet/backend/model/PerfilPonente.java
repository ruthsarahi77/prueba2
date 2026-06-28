package com.itsqmet.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "perfiles_ponentes")

public class PerfilPonente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 500, message = "La biografía no puede superar los 500 caracteres")
    private String biografia;

    @Size(max = 255, message = "El enlace de LinkedIn no puede superar los 255 caracteres")
    private String linkedin;

    @Size(max = 255, message = "La página web no puede superar los 255 caracteres")
    private String paginaWeb;

    @OneToOne
    @JoinColumn(name = "ponente_id", nullable = false)
    @JsonIgnoreProperties("perfilPonente")
    private Ponente ponente;
}