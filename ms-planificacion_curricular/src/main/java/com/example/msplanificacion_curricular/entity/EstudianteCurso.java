package com.example.msplanificacion_curricular.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class EstudianteCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer estudiante_id ;
    private Integer curso_id ;
    private String Año_Academico ;
    private String Periodo_Academico ;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "curso_estudiantecurso",
            joinColumns = @JoinColumn(name = "estudiantecurso_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id")
    )
    @JsonIgnoreProperties({"estudiantes"})
    private Set<Curso> cursos = new HashSet<>();



}
