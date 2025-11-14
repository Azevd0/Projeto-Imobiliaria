package com.imobiliaria.Desafio_Imobiliaria.controller;

import com.imobiliaria.Desafio_Imobiliaria.dto.ImovelDto;
import com.imobiliaria.Desafio_Imobiliaria.models.Imovel;
import com.imobiliaria.Desafio_Imobiliaria.service.ImovelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/imoveis")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ImovelDto> findById(@PathVariable Long id){
        Imovel imovel = imovelService.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(imovel, ImovelDto.class));
    }
    @PostMapping
    public ResponseEntity<ImovelDto> save(@Valid @RequestBody ImovelDto imovelDto){
        Imovel imovel = modelMapper.map(imovelDto, Imovel.class);
        Imovel novoImovel = imovelService.save(imovel);
        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(novoImovel, ImovelDto.class));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        imovelService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
