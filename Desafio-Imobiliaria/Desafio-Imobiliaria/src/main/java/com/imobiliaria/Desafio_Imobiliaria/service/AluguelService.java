package com.imobiliaria.Desafio_Imobiliaria.service;

import com.imobiliaria.Desafio_Imobiliaria.exceptions.ObjectNotFoundException;
import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import com.imobiliaria.Desafio_Imobiliaria.models.Imovel;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import com.imobiliaria.Desafio_Imobiliaria.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private InquilinoService inquilinoService;
    @Autowired
    private ImovelService imovelService;

    public Aluguel findById(Long id){
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        if(aluguel.isPresent()){
            return aluguel.get();
        }
        throw new ObjectNotFoundException("Aluguel não encontrado com id "+ id);
    }

    public List<Aluguel> buscarAtrasados(){
        LocalDate data = LocalDate.now();
        return aluguelRepository.findByPagoFalseAndDataVencimentoBefore(data);
    }
    public Aluguel save(Aluguel aluguel, Long id_inq, Long id_imo){
        Inquilino inquilino = inquilinoService.findById(id_inq);
        aluguel.setInquilino(inquilino);
        Imovel imovel = imovelService.findById(id_imo);
        aluguel.setImovel(imovel);
        return aluguelRepository.save(aluguel);
    }
    public Aluguel marcarComoPago(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                     .orElseThrow(() -> new ObjectNotFoundException("Aluguel não encontrado com id " + id));
        aluguel.setPago(true);
        return aluguelRepository.save(aluguel);
    }
    public void delete(Long id){
        Aluguel aluguel = findById(id);
        aluguelRepository.deleteById(aluguel.getId());
    }
}
