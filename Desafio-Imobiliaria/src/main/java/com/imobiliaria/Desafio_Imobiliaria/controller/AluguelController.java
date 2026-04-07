package com.imobiliaria.Desafio_Imobiliaria.controller;

import com.imobiliaria.Desafio_Imobiliaria.dto.AluguelDto;
import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import com.imobiliaria.Desafio_Imobiliaria.service.AluguelService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    private final AluguelService aluguelService;
    private final ModelMapper modelMapper;

    public AluguelController(AluguelService aluguelService, ModelMapper modelMapper) {
        this.aluguelService = aluguelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca", description = "Buscar aluguel por id")
    public ResponseEntity<AluguelDto> findById(@PathVariable Long id){
        Aluguel aluguel = aluguelService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(aluguel,AluguelDto.class));
    }
    @GetMapping("/atrasados")
    @Operation(summary = "Pendências", description = "Listar alugueis atrasados")
    public ResponseEntity<List<AluguelDto>> listarAtrasados(){
        List<Aluguel> atrasos = aluguelService.buscarAtrasados();
        return ResponseEntity.ok().body(atrasos.stream().map(AluguelDto::new).collect(Collectors.toList()));
    }
    @PostMapping
    @Operation(summary = "Cadastro", description = "Cadastrar alugueis")
    public ResponseEntity<AluguelDto> save(@RequestParam(value = "inquilino") Long id_inq,
                                           @RequestParam(value = "imovel") Long id_imo,
                                           @Valid @RequestBody Aluguel aluguel){
        Aluguel novoAluguel = aluguelService.save(aluguel, id_inq, id_imo);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(novoAluguel,AluguelDto.class));
    }
    @PatchMapping("/{id}/pagar")
    @Operation(summary = "Pagamento", description = "Registrar pagamento de aluguel")
    public ResponseEntity<AluguelDto> marcarPagamento(@PathVariable Long id) {
        Aluguel aluguelPago = aluguelService.marcarComoPago(id);
        return ResponseEntity.ok().body(modelMapper.map(aluguelPago, AluguelDto.class));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Remoção", description = "Remover aluguel por id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        aluguelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
