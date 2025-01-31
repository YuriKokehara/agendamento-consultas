package com.example.agendamento.services;

import com.example.agendamento.dtos.MedicoDTO;
import com.example.agendamento.entities.Medico;
import com.example.agendamento.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public MedicoDTO criarMedico(MedicoDTO medicoDTO) {
        Medico medico = new Medico();
        medico.setName(medicoDTO.getName());
        medico.setEspecialidade(medicoDTO.getEspecialidade());

        Medico medicoSalvo = medicoRepository.save(medico);

        return new MedicoDTO(medicoSalvo.getName(), medicoSalvo.getEspecialidade());
    }

    public MedicoDTO buscarMedicoPorId(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        return new MedicoDTO(medico.getName(), medico.getEspecialidade());
    }
}
