package com.example.agendamento.mappers;

import com.example.agendamento.dtos.MedicoDTO;
import com.example.agendamento.entities.Medico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicoMapper {
    MedicoMapper INSTANCE = Mappers.getMapper(MedicoMapper.class);

    MedicoDTO toDto(Medico medico);
    Medico toEntity(MedicoDTO medicoDTO);
}
