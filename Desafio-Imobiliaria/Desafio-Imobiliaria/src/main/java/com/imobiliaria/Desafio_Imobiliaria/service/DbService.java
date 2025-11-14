package com.imobiliaria.Desafio_Imobiliaria.service;

import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import com.imobiliaria.Desafio_Imobiliaria.models.Imovel;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import com.imobiliaria.Desafio_Imobiliaria.repository.AluguelRepository;
import com.imobiliaria.Desafio_Imobiliaria.repository.ImovelRepository;
import com.imobiliaria.Desafio_Imobiliaria.repository.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class DbService {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private ImovelRepository imovelRepository;

    public void instanciarDb(){
        Inquilino i1 = new Inquilino(null, "Alberto Costa", "alberto44@gmail.com");
        Inquilino i2 = new Inquilino(null, "Joana Vila", "joanavil@email.com");
        Inquilino i3 = new Inquilino(null, "José Silva", "jose87@gmail.com");
        Inquilino i4 = new Inquilino(null, "Adilson Oliveira", "oliveradilson@hotmail.com");
        Inquilino i5 = new Inquilino(null, "Jéssica Eduarda", "jessicanuns98@gmail.com");

        Imovel imovel1 = new Imovel(null,"Apartamento 201", "Rua da Liberdade, 111");
        Imovel imovel2 = new Imovel(null,"Duplex", "Rua do Futuro, 23");
        Imovel imovel3 = new Imovel(null,"Apertamento 333", "Avenida Ayrton senna, 888");
        Imovel imovel4 = new Imovel(null,"Casa com piscina e muro", "Rua Recife, 1003");
        Imovel imovel5 = new Imovel(null,"Apartamento 300", "Rua Rosa Linda, 3444");
        Imovel imovel6 = new Imovel(null,"Apartamento 121", "Rua Rossini, 89");
        Imovel imovel7 = new Imovel(null,"Apartamento 404", "Avenida Boa Vista, 265");

        Aluguel alugel0 = new Aluguel();
        Aluguel aluguel1 = new Aluguel(null, imovel1,i2,1400.00, LocalDate.of(2025,10,30), alugel0.getDiasEmAtraso());
        Aluguel aluguel2 = new Aluguel(null, imovel1, i2, 2800.00,LocalDate.of(2025,11,2),alugel0.getDiasEmAtraso());
        Aluguel aluguel3 = new Aluguel(null,imovel3,i1,1450.00,LocalDate.of(2025,11,10),alugel0.getDiasEmAtraso());
        Aluguel aluguel4 = new Aluguel(null,imovel4,i1,2400.00,LocalDate.of(2025,11,15),alugel0.getDiasEmAtraso());
        Aluguel aluguel5 = new Aluguel(null,imovel3,i4,1600.00,LocalDate.of(2025,10,26),alugel0.getDiasEmAtraso());
        Aluguel aluguel6 = new Aluguel(null,imovel5,i5,1200.00,LocalDate.of(2025,11,16),alugel0.getDiasEmAtraso());
        Aluguel aluguel7 = new Aluguel(null,imovel7,i4,1350.00,LocalDate.of(2025,11,8),alugel0.getDiasEmAtraso());
        Aluguel aluguel8 = new Aluguel(null, imovel2, i3, 1220.00, LocalDate.of(2025,11,3),alugel0.getDiasEmAtraso());
        Aluguel aluguel9 = new Aluguel(null, imovel6, i3, 1190.00,LocalDate.of(2025,10,31),alugel0.getDiasEmAtraso());

        i1.getAluguel().addAll(Arrays.asList(aluguel3, aluguel4));
        i2.getAluguel().addAll(Arrays.asList(aluguel1, aluguel2));
        i3.getAluguel().addAll(Arrays.asList(aluguel8, aluguel9));
        i4.getAluguel().addAll(Arrays.asList(aluguel5, aluguel7));
        i5.getAluguel().add(aluguel6);

        imovel1.getAlugueis().addAll(Arrays.asList(aluguel1, aluguel2));
        imovel2.getAlugueis().add(aluguel8);
        imovel3.getAlugueis().addAll(Arrays.asList(aluguel3, aluguel5));
        imovel4.getAlugueis().add(aluguel4);
        imovel5.getAlugueis().add(aluguel6);
        imovel6.getAlugueis().add(aluguel9);
        imovel7.getAlugueis().add(aluguel7);

        inquilinoRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5));
        imovelRepository.saveAll(Arrays.asList(imovel1, imovel2, imovel3, imovel4, imovel5, imovel6, imovel7));
        aluguelRepository.saveAll(Arrays.asList(aluguel1, aluguel2, aluguel3, aluguel4, aluguel5, aluguel6, aluguel7, aluguel8, aluguel9));
    }
}
