package com.imobiliaria.Desafio_Imobiliaria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "aluguel")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "inquilino_id")
    private Inquilino inquilino;

    @NotNull(message = "O valor do aluguel é obrigatório.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
    private Double valor;

    private LocalDate dataVencimento;

    @Transient
    private Long diasEmAtraso;

    private boolean pago;

    public Aluguel() {
    }

    public Aluguel(Long id,Imovel imovel, Inquilino inquilino, Double valor, LocalDate dataVencimento, Long diasEmAtraso) {
        this.id = id;
        this.imovel = imovel;
        this.inquilino = inquilino;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.diasEmAtraso = getDiasEmAtraso();
    }
    public Long getDiasEmAtraso() {
        if (pago) return 0L;
        if (dataVencimento != null && dataVencimento.isBefore(LocalDate.now())) {
            return ChronoUnit.DAYS.between(dataVencimento, LocalDate.now());
        }
        return 0L;
    }

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

    public void setDiasEmAtraso(Long diasEmAtraso) {this.diasEmAtraso = diasEmAtraso;}

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
