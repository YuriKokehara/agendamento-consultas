package com.example.agendamento.controllers;

import com.example.agendamento.dtos.ConsultaDTO;
import com.example.agendamento.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaDTO> agendarConsulta(@Valid @RequestBody ConsultaDTO consultaDTO){
        ConsultaDTO consultaAgendada = consultaService.agendarConsulta(consultaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaAgendada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDTO> buscarConsultaPorId(@PathVariable Long id){
        ConsultaDTO consultaDTO = consultaService.buscarConsultaPorId(id);

        return ResponseEntity.ok(consultaDTO);
    }
}
