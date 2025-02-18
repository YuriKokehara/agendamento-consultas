package com.example.agendamento.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PacienteDTO {
    @NotBlank(message = "O nome do paciente é obrigatório.")
    @Size(max = 100, message = "O nome do paciente deve ter no máximo 100 caracteres.")
    private String nome;

    @NotBlank(message = "O CPF do paciente é obrigatório.")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato 123.456.789-00.")
    private String cpf;

    @NotBlank(message = "O telefone do paciente é obrigatório.")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}", message = "O telefone deve estar no formato (11) 99999-9999")
    private String telefone;

    public PacienteDTO(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
