package com.imobiliaria.Desafio_Imobiliaria.dto;

import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import com.imobiliaria.Desafio_Imobiliaria.models.Imovel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AluguelDto {
    private Long id;
    private Imovel imovel;
    private String inquilino;
    private Double valor;

    private LocalDate dataVencimento;
    private Long diasEmAtraso;

    public AluguelDto(Long id, Imovel imovel, String inquilino, Double valor, LocalDate dataVencimento,Long diasEmAtraso) {
        this.id = id;
        this.imovel = imovel;
        this.inquilino = inquilino;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.diasEmAtraso = getDiasEmAtraso();

    }
    public AluguelDto(Aluguel aluguel){
        this.id = aluguel.getId();
        this.imovel = aluguel.getImovel();
        this.inquilino = aluguel.getInquilino().getNome();
        this.valor = aluguel.getValor();
        this.dataVencimento = aluguel.getDataVencimento();
        this.diasEmAtraso = aluguel.getDiasEmAtraso();
    }
    public AluguelDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public String getInquilino() {
        return inquilino;
    }

    public void setInquilino(String inquilino) {
        this.inquilino = inquilino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Long getDiasEmAtraso() {
        Aluguel aluguel = new Aluguel();
        if(aluguel.getPago()) return 0L;
        if(dataVencimento !=null && dataVencimento.isBefore(LocalDate.now())){
            return ChronoUnit.DAYS.between(dataVencimento, LocalDate.now());
        }
        return  0L;
    }

    public void setDiasEmAtraso(Long diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }
}
