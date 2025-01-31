package com.example.agendamento.dtos;

import lombok.Data;

@Data
public class MedicoDTO {
    private String name;
    private String especialidade;

    public MedicoDTO(String name, String especialidade) {
        this.name = name;
        this.especialidade = especialidade;
    }
}
