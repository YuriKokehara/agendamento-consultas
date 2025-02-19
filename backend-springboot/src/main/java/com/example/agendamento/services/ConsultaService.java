package com.example.agendamento.services;

import com.example.agendamento.dtos.ConsultaDTO;
import com.example.agendamento.entities.Consulta;
import com.example.agendamento.entities.Medico;
import com.example.agendamento.entities.Paciente;
import com.example.agendamento.exception.BusinessException;
import com.example.agendamento.repositories.ConsultaRepository;
import com.example.agendamento.repositories.MedicoRepository;
import com.example.agendamento.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ConsultaDTO agendarConsulta(ConsultaDTO consultaDTO){
        if (consultaDTO.getDataHora().isBefore(LocalDateTime.now())) {
            throw new BusinessException("A data e hora da consulta devem ser no futuro.");
        }

        verificarDisponibilidadeMedico(consultaDTO.getMedicoId(), consultaDTO.getDataHora());

        verificarDisponibilidadePaciente(consultaDTO.getPacienteId(), consultaDTO.getDataHora());

        Medico medico = medicoRepository.findById(consultaDTO.getMedicoId())
                .orElseThrow(() -> new BusinessException("Médico não encontrado"));
        Paciente paciente = pacienteRepository.findById(consultaDTO.getPacienteId())
                .orElseThrow(() -> new BusinessException("Paciente não encontrado"));

        Consulta consulta = new Consulta();
        consulta.setMedico(medico);
        consulta.setPaciente(paciente);
        consulta.setDataHora(consultaDTO.getDataHora());
        consulta.setObservacoes(consultaDTO.getObservacoes());

        Consulta consultaSalva = consultaRepository.save(consulta);

        return new ConsultaDTO(
                consultaSalva.getMedico().getId(),
                consultaSalva.getPaciente().getId(),
                consultaSalva.getDataHora(),
                consultaSalva.getObservacoes()
        );
    }

    public ConsultaDTO buscarConsultaPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Consulta não encontrada"));
        return new ConsultaDTO(
                consulta.getMedico().getId(),
                consulta.getPaciente().getId(),
                consulta.getDataHora(),
                consulta.getObservacoes()
        );
    }

    private void verificarDisponibilidadeMedico (Long medicoId, LocalDateTime dataHora){
        boolean medicoOcupado = consultaRepository.existsByMedicoIdAndDataHora(medicoId, dataHora);
        if (medicoOcupado) {
            throw new BusinessException("O médico já possui uma consulta agendada para este horário");
        }
    }

    private void verificarDisponibilidadePaciente(Long pacienteId, LocalDateTime dataHora){
        boolean pacienteOcupado = consultaRepository.existsByPacienteIdAndDataHora(pacienteId, dataHora);
        if (pacienteOcupado) {
            throw new BusinessException("O paciente já possui uma consulta agendada para este horário");
        }
    }
}
