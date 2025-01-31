package com.example.agendamento.services;

import com.example.agendamento.dtos.PacienteDTO;
import com.example.agendamento.entities.Paciente;
import com.example.agendamento.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteDTO criarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setName(pacienteDTO.getNome());
        paciente.setCpf(pacienteDTO.getCpf());
        paciente.setTelefone(pacienteDTO.getTelefone());

        Paciente pacienteSalvo = pacienteRepository.save(paciente);

        return new PacienteDTO(pacienteSalvo.getName(), pacienteSalvo.getCpf(), pacienteSalvo.getTelefone());
    }
}
