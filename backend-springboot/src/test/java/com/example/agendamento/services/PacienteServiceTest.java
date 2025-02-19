package com.example.agendamento.services;

import com.example.agendamento.dtos.PacienteDTO;
import com.example.agendamento.entities.Paciente;
import com.example.agendamento.repositories.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    public void testCriarPaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO("Maria", "123.456.789-00", "(11) 99999-9999");
        Paciente pacienteSalvo = new Paciente();
        pacienteSalvo.setName("Maria");
        pacienteSalvo.setCpf("123.456.789-00");
        pacienteSalvo.setTelefone("(11) 99999-9999");

        when(pacienteRepository.save(any(Paciente.class))).thenReturn(pacienteSalvo);

        PacienteDTO resultado = pacienteService.criarPaciente(pacienteDTO);

        assertEquals("Maria", resultado.getNome());
        assertEquals("123.456.789-00", resultado.getCpf());
        assertEquals("(11) 99999-9999", resultado.getTelefone());
    }
}
