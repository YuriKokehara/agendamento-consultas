package com.example.agendamento.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {
    private Long medicoId;
    private Long pacienteId;
    private LocalDateTime dataHora;
    private String observacoes;
}
