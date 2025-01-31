package com.example.agendamento.dtos;

import lombok.Data;

@Data
public class PacienteDTO {
    private String nome;
    private String cpf;
    private String telefone;

    public PacienteDTO(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
}
