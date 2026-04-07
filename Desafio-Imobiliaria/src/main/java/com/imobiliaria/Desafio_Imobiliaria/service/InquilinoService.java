package com.imobiliaria.Desafio_Imobiliaria.service;

import com.imobiliaria.Desafio_Imobiliaria.dto.InquilinoRequestDto;
import com.imobiliaria.Desafio_Imobiliaria.dto.InquilinoResponseDto;
import com.imobiliaria.Desafio_Imobiliaria.exceptions.ObjectNotFoundException;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import com.imobiliaria.Desafio_Imobiliaria.repository.InquilinoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InquilinoService {
    private final InquilinoRepository inquilinoRepository;

    public InquilinoService(InquilinoRepository inquilinoRepository) {
        this.inquilinoRepository = inquilinoRepository;
    }

    public List<Inquilino> findALl(){
        return inquilinoRepository.findAll();
    }
    public Inquilino findById(Long id){
        Optional<Inquilino> inquilino = inquilinoRepository.findById(id);
        if(inquilino.isPresent()){
            return inquilino.get();
        }
        throw new ObjectNotFoundException("Inquilino não encontrado com id "+ id);
    }
    public Inquilino findByName(String nome){
        Optional<Inquilino> inquilino = inquilinoRepository.findByNomeIgnoreCase(nome);
        if(inquilino.isPresent()){
            return inquilino.get();
        }
        throw new ObjectNotFoundException("Inquilino não encontrado com nome "+ nome);
    }

    public InquilinoResponseDto save(InquilinoRequestDto dto) {
        validarNomeUnico(dto.nome());
        Inquilino inquilino = new Inquilino(dto);
        inquilino = inquilinoRepository.save(inquilino);
        return new InquilinoResponseDto(inquilino);
    }

    private void validarNomeUnico(String nome) {
        inquilinoRepository.findByNomeIgnoreCase(nome)
                .ifPresent(inq -> {
                    throw new DataIntegrityViolationException("Inquilino de nome " + nome + " já existe");
                });
    }

    public void delete(Long id){
        Inquilino inquilino = findById(id);
        if (!inquilino.getAluguel().isEmpty()){
            throw new DataIntegrityViolationException("Inquilino não pode ser deletado, pois tem alugeis ativos");
        }
        inquilinoRepository.deleteById(inquilino.getId());

    }
}
