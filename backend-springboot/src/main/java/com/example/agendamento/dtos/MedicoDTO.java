package com.example.agendamento.dtos;

import lombok.Data;

@Data
public class MedicoDTO {
    private String nome;
    private String especialidade;

    public MedicoDTO(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }
}
