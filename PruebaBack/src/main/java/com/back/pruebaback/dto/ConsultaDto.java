package com.back.pruebaback.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaDto {
    @NotBlank
    private String city;
    @NotBlank
    private String tipoConsulta;
    @NotBlank
    private LocalDateTime fecha;
    @NotBlank
    private String respuesta;
    @NotBlank
    private int idUsuario;
}
