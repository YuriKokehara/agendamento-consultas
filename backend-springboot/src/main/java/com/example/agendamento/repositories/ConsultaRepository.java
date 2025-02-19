package com.example.agendamento.repositories;

import com.example.agendamento.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndDataHora(Long medicoId, LocalDateTime dataHora);
    boolean existsByPacienteIdAndDataHora(Long pacienteId, LocalDateTime dataHora);
}
