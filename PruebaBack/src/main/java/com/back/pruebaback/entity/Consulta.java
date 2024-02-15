package com.back.pruebaback.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "consulta")
public class Consulta implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsulta;
    @NotNull
    private String city;
    
    @Column(name = "tipo_consulta")
    @NotNull
    private String tipoConsulta;
    @NotNull
    private LocalDateTime fecha;
    @NotNull
    private String respuesta;
    @Column(name = "id_usuario")
    @NotNull
    private int idUsuario;
}
