package com.example.agendamento.controllers;

import com.example.agendamento.dtos.PacienteDTO;
import com.example.agendamento.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> criarPaciente(@RequestBody PacienteDTO pacienteDTO){
        PacienteDTO pacienteSalvo = pacienteService.criarPaciente(pacienteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPacientePorId(@PathVariable Long id){
        PacienteDTO pacienteDTO = pacienteService.buscarPacientePorId(id);

        return ResponseEntity.ok(pacienteDTO);
    }
}
