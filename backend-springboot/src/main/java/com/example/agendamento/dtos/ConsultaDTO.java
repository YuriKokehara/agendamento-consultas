package com.example.agendamento.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {
    private Long medicoId;
    private Long pacienteId;
    private LocalDateTime dataHora;
    private String observacoes;

    public ConsultaDTO(Long medicoId, Long pacienteId, LocalDateTime dataHora, String observacoes) {
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
    }
}
