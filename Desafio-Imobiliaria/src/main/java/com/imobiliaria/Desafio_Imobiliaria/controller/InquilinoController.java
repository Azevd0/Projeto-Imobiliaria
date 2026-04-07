package com.imobiliaria.Desafio_Imobiliaria.controller;

import com.imobiliaria.Desafio_Imobiliaria.dto.InquilinoRequestDto;
import com.imobiliaria.Desafio_Imobiliaria.dto.InquilinoResponseDto;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import com.imobiliaria.Desafio_Imobiliaria.service.InquilinoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquilinos")
public class InquilinoController {
    private final  InquilinoService inquilinoService;
    private final ModelMapper modelMapper;

    public InquilinoController(InquilinoService inquilinoService, ModelMapper modelMapper) {
        this.inquilinoService = inquilinoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    @Operation(summary = "Todos os inquilinos", description = "Listar todos os inquilinos")
    public ResponseEntity<List<InquilinoResponseDto>> listAll(){
        List<InquilinoResponseDto> inquilinoList = inquilinoService.findALl()
                .stream().map(InquilinoResponseDto::new).toList();
        return ResponseEntity.ok(inquilinoList);
    }
    @GetMapping("/{nome}")
    @Operation(summary = "Busca por nome", description = "Buscar inquilino pelo nome")
    public ResponseEntity<InquilinoResponseDto> findByNome(@PathVariable String nome){
        Inquilino inquilino = inquilinoService.findByName(nome);
        return  ResponseEntity.ok().body(modelMapper.map(inquilino, InquilinoResponseDto.class));
    }
    @PostMapping
    @Operation(summary = "Cadastro", description = "Cadastrar inquilino")
    public ResponseEntity<InquilinoResponseDto> save(@Valid @RequestBody InquilinoRequestDto inquilinoDto){
        return ResponseEntity.ok(inquilinoService.save(inquilinoDto));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção", description = "Deletar inquilino pelo id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        inquilinoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
