package com.imobiliaria.Desafio_Imobiliaria.dto;

import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import com.imobiliaria.Desafio_Imobiliaria.models.Imovel;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AluguelDto {
    private Long id;
    @NotNull(message = "O aluguel deve ter um imovel")
    private Imovel imovel;
    @NotNull(message = "O aluguel deve ter um inquilino")
    private Inquilino inquilino;

    @NotNull(message = "O valor do aluguel é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
    private Double valor;

    private LocalDate dataVencimento;
    private Long diasEmAtraso;
    private boolean pago;

    public AluguelDto(Long id, Imovel imovel, Inquilino inquilino, Double valor, LocalDate dataVencimento,Long diasEmAtraso) {
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
        this.inquilino = aluguel.getInquilino();
        this.valor = aluguel.getValor();
        this.dataVencimento = aluguel.getDataVencimento();
        this.diasEmAtraso = aluguel.getDiasEmAtraso();
        this.pago = aluguel.getPago();
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

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
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
        if(pago) return 0L;
        if(dataVencimento !=null && dataVencimento.isBefore(LocalDate.now())){
            return ChronoUnit.DAYS.between(dataVencimento, LocalDate.now());
        }
        return  0L;
    }

    public void setDiasEmAtraso(Long diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
