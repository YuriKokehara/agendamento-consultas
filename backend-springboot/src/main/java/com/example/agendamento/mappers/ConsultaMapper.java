package com.example.agendamento.mappers;

import com.example.agendamento.dtos.ConsultaDTO;
import com.example.agendamento.entities.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConsultaMapper {
    ConsultaMapper INSTANCE = Mappers.getMapper(ConsultaMapper.class);

    ConsultaDTO toDto(Consulta consulta);
    Consulta toEntity(ConsultaDTO consultaDTO);
}
