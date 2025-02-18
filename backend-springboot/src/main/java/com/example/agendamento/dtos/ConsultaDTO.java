package com.example.agendamento.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {
    @NotNull(message = "O ID do médico é obrigatório.")
    private Long medicoId;

    @NotNull(message = "O ID do paciente é obrigatório.")
    private Long pacienteId;

    @NotNull(message = "A data e hora da consulta são obrigatórias.")
    @Future(message = "A data e hora da consulta devem ser no futuro.")
    private LocalDateTime dataHora;

    @Size(max = 500, message = "As observações devem ter no máximo 500 caracteres.")
    private String observacoes;

    public ConsultaDTO(Long medicoId, Long pacienteId, LocalDateTime dataHora, String observacoes) {
        this.medicoId = medicoId;
        this.pacienteId = pacienteId;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
    }
}
