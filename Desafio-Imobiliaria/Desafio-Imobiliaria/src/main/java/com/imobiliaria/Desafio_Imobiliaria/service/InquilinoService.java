package com.imobiliaria.Desafio_Imobiliaria.service;

import com.imobiliaria.Desafio_Imobiliaria.exceptions.ObjectNotFoundException;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import com.imobiliaria.Desafio_Imobiliaria.repository.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InquilinoService {
    @Autowired
    private InquilinoRepository inquilinoRepository;

    public Inquilino findById(Long id){
        Optional<Inquilino> inquilino = inquilinoRepository.findById(id);
        if(inquilino.isPresent()){
            return inquilino.get();
        }
        throw new ObjectNotFoundException("Inquilino não encontrado com id "+ id);
    }

    public Inquilino save(Inquilino nome){
        buscarPorNome(nome);
        return inquilinoRepository.save(nome);
    }
    public void delete(Long id){
        Inquilino inquilino = findById(id);
        if (!inquilino.getAluguel().isEmpty()){
            throw new DataIntegrityViolationException("Inquilino não pode ser deletado, pois tem alugeis ativos");
        }
        inquilinoRepository.deleteById(inquilino.getId());

    }
    public void buscarPorNome(Inquilino inquilino){
        Optional<Inquilino> inq = inquilinoRepository.findByNomeIgnoreCase(inquilino.getNome());
        if(inq.isPresent()){
            if(inq.get().getId() != inquilino.getId()){
                throw new IllegalArgumentException("Inquilino de nome "+ inquilino.getNome() + " já existe.");
            }
        }
    }
}
