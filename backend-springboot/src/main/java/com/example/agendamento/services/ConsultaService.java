package com.example.agendamento.services;

import com.example.agendamento.dtos.ConsultaDTO;
import com.example.agendamento.entities.Consulta;
import com.example.agendamento.entities.Medico;
import com.example.agendamento.entities.Paciente;
import com.example.agendamento.repositories.ConsultaRepository;
import com.example.agendamento.repositories.MedicoRepository;
import com.example.agendamento.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ConsultaDTO agendarConsulta(ConsultaDTO consultaDTO){
        Medico medico = medicoRepository.findById(consultaDTO.getMedicoId())
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        Paciente paciente = pacienteRepository.findById(consultaDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

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
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        return new ConsultaDTO(
                consulta.getMedico().getId(),
                consulta.getPaciente().getId(),
                consulta.getDataHora(),
                consulta.getObservacoes()
        );
    }
}
