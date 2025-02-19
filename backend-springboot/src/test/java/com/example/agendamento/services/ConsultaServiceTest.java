package com.example.agendamento.services;

import com.example.agendamento.dtos.ConsultaDTO;
import com.example.agendamento.exception.BusinessException;
import com.example.agendamento.repositories.ConsultaRepository;
import com.example.agendamento.repositories.MedicoRepository;
import com.example.agendamento.repositories.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultaServiceTest {

    @Mock
    private ConsultaRepository consultaRepository;

    @Mock
    private MedicoRepository medicoRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private ConsultaService consultaService;

    @Test
    public void testAgendarConsultaComMedicoOcupado() {
        ConsultaDTO consultaDTO = new ConsultaDTO(
                1L,
                1L, LocalDateTime.now().plusHours(1),
                "Consulta de rotina"
        );

        when(
                consultaRepository.existsByMedicoIdAndDataHora(
                    1L,
                        consultaDTO.getDataHora()
                )
        ).thenReturn(true);

        assertThrows(BusinessException.class, () -> consultaService.agendarConsulta(consultaDTO));
    }
}
