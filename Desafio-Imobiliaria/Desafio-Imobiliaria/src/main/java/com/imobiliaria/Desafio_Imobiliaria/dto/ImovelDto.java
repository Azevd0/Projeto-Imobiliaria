package com.imobiliaria.Desafio_Imobiliaria.dto;

import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class ImovelDto {
    private Long id;

    @NotBlank(message = "O campo descrição é obrigatório")
    private String  descricao;

    @NotBlank(message = "O campo endereço é obrigatório")
    private String endereco;

    private List<Aluguel> alugueis = new ArrayList<>();

    public ImovelDto() {
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

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }
}
