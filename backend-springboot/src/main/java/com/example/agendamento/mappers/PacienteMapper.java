package com.example.agendamento.mappers;

import com.example.agendamento.dtos.PacienteDTO;
import com.example.agendamento.entities.Paciente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PacienteMapper {
    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteDTO toDto(Paciente paciente);
    Paciente toEntity(PacienteDTO pacienteDTO);
}
