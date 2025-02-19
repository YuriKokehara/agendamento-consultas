package com.example.agendamento.controllers;

import com.example.agendamento.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PacienteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void testCriarPaciente() throws Exception {
        String pacienteJson = "{ \"name\": \"Maria\", \"cpf\": \"123.456.789-00\", \"telefone\": \"(11) 99999-9999\" }";

        mockMvc.perform(post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pacienteJson))
                .andExpect(status().isCreated());
    }
}
