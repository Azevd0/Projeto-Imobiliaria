package com.imobiliaria.Desafio_Imobiliaria.controller;

import com.imobiliaria.Desafio_Imobiliaria.dto.AluguelDto;
import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import com.imobiliaria.Desafio_Imobiliaria.service.AluguelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
@Autowired
    private AluguelService aluguelService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AluguelDto> findById(@PathVariable Long id){
        Aluguel aluguel = aluguelService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(aluguel,AluguelDto.class));
    }
   @GetMapping("/atrasados")
    public ResponseEntity<List<AluguelDto>> listarAtrasados(){
        List<Aluguel> atrasos = aluguelService.buscarAtrasados();
        return ResponseEntity.ok().body(atrasos.stream().map(x -> new AluguelDto(x)).collect(Collectors.toList()));
    }
     @PostMapping
    public ResponseEntity<AluguelDto> save(@RequestParam(value = "inquilino") Long id_inq,
                                           @RequestParam(value = "imovel") Long id_imo,
                                           @Valid @RequestBody Aluguel aluguel){
        Aluguel novoAluguel = aluguelService.save(aluguel, id_inq, id_imo);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(novoAluguel,AluguelDto.class));
    }
     @PatchMapping("/{id}/pagar")
    public ResponseEntity<AluguelDto> marcarPagamento(@PathVariable Long id) {
        Aluguel aluguelPago = aluguelService.marcarComoPago(id);
        return ResponseEntity.ok().body(modelMapper.map(aluguelPago, AluguelDto.class));
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        aluguelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}




