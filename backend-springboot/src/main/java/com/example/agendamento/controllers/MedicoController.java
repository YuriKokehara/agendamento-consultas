package com.example.agendamento.controllers;

import com.example.agendamento.dtos.MedicoDTO;
import com.example.agendamento.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<MedicoDTO> criarMedico(@Valid @RequestBody MedicoDTO medicoDTO){
        MedicoDTO medicoSalvo = medicoService.criarMedico(medicoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTO> buscarMedicoPorId(@PathVariable Long id){
        MedicoDTO medicoDTO = medicoService.buscarMedicoPorId(id);
        return ResponseEntity.ok(medicoDTO);
    }
}
