package com.imobiliaria.Desafio_Imobiliaria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "imovel")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo descrição é obrigatório")
    private String  descricao;

    @NotBlank(message = "O campo endereço é obrigatório")
    private String endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "imovel")
    private List<Aluguel> alugueis = new ArrayList<>();


    public Imovel() {
    }

    public Imovel(Long id, String descricao, String endereco) {
        this.id = id;
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
