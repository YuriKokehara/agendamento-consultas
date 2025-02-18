package com.example.agendamento.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MedicoDTO {
    @NotBlank(message = "O nome do médico é obrigatório.")
    @Size(max = 180, message = "O nome do médico deve ter no máximo 180 caracteres.")
    private String name;

    @NotBlank(message = "A especialidade do médico é obrigatória.")
    @Size(max = 50, message = "A especialidade do médico deve ter no máximo 50 caracteres.")
    private String especialidade;

    public MedicoDTO(String name, String especialidade) {
        this.name = name;
        this.especialidade = especialidade;
    }
}
