package com.imobiliaria.Desafio_Imobiliaria.controller;

import com.imobiliaria.Desafio_Imobiliaria.dto.InquilinoDto;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import com.imobiliaria.Desafio_Imobiliaria.service.InquilinoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inquilinos")
public class InquilinoController {
    @Autowired
    private InquilinoService inquilinoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<InquilinoDto> findById(@PathVariable Long id){
        Inquilino inquilino = inquilinoService.findById(id);
        return  ResponseEntity.ok().body(modelMapper.map(inquilino, InquilinoDto.class));
    }
    @PostMapping
    public ResponseEntity<InquilinoDto> save(@Valid @RequestBody InquilinoDto inquilinoDto){
        Inquilino inquilinoCriado = modelMapper.map(inquilinoDto, Inquilino.class);
        Inquilino inquilino = inquilinoService.save(inquilinoCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(inquilino, InquilinoDto.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        inquilinoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
