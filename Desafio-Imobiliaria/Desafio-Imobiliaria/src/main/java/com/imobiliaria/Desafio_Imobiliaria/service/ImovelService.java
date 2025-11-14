package com.imobiliaria.Desafio_Imobiliaria.service;

import com.imobiliaria.Desafio_Imobiliaria.exceptions.ObjectNotFoundException;
import com.imobiliaria.Desafio_Imobiliaria.models.Imovel;
import com.imobiliaria.Desafio_Imobiliaria.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;

    public List<Imovel> findAll(){
        return imovelRepository.findAll();
    }
    public Imovel findById(Long id){
        Optional<Imovel> imovel = imovelRepository.findById(id);
        if(imovel.isPresent()){
            return  imovel.get();
        }
        throw new ObjectNotFoundException("Imóvel não cadastrado com id "+ id);
    }
    public Imovel save(Imovel imovel){
        return imovelRepository.save(imovel);
    }

    public void delete(Long id){
        Imovel imovel = findById(id);
        if(!imovel.getAlugueis().isEmpty()){
            throw new DataIntegrityViolationException("Imóvel não pode ser deletado, pois ainda tem alugueis ativos!");
        }
        imovelRepository.deleteById(imovel.getId());
    }
}
