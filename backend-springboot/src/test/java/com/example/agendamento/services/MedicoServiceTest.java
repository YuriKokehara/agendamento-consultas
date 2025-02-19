package com.example.agendamento.services;

import com.example.agendamento.dtos.MedicoDTO;
import com.example.agendamento.entities.Medico;
import com.example.agendamento.repositories.MedicoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MedicoServiceTest {

    @Mock
    private MedicoRepository medicoRepository;

    @InjectMocks
    private MedicoService medicoService;

    @Test
    public void testCriarMedico() {
        MedicoDTO medicoDTO = new MedicoDTO("Dr. João", "Cardiologia");
        Medico medicoSalvo = new Medico();
        medicoSalvo.setId(1L);
        medicoSalvo.setName("Dr. João");
        medicoSalvo.setEspecialidade("Cardiologia");

        when(medicoRepository.save(any(Medico.class))).thenReturn(medicoSalvo);

        MedicoDTO resultado = medicoService.criarMedico(medicoDTO);

        assertEquals("Dr. João", resultado.getName());
        assertEquals("Cardiologia", resultado.getEspecialidade());
    }
}
