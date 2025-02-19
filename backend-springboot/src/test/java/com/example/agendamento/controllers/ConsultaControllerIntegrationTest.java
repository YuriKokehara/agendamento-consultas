package com.example.agendamento.controllers;

import com.example.agendamento.entities.Medico;
import com.example.agendamento.entities.Paciente;
import com.example.agendamento.repositories.MedicoRepository;
import com.example.agendamento.repositories.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConsultaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Test
    public void testAgendarConsulta() throws Exception {
        Medico medico = new Medico();
        medico.setName("Dr. João");
        medico.setEspecialidade("Cardiologia");
        medicoRepository.save(medico);

        Paciente paciente = new Paciente();
        paciente.setName("Maria");
        paciente.setCpf("123.456.789-00");
        paciente.setTelefone("(11) 99999-9999");
        pacienteRepository.save(paciente);

        String consultaJson = "{ \"medicoId\": 1, \"pacienteId\": 1, \"dataHora\": \"2025-12-25T10:00:00\", \"observacoes\": \"Consulta de rotina\" }";

        mockMvc.perform(post("/consultas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(consultaJson))
                .andExpect(status().isCreated());

    }
}
