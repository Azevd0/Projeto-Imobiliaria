package com.imobiliaria.Desafio_Imobiliaria.dto;

import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;

import java.util.ArrayList;
import java.util.List;

public class InquilinoResponseDto {
    private Long id;
    private String nome;
    private String email;
    private List<Aluguel> aluguel = new ArrayList<>();

    public InquilinoResponseDto(Inquilino inquilino) {
        this.id = inquilino.getId();
        this.nome = inquilino.getNome();
        this.email = inquilino.getEmail();
        this.aluguel = inquilino.getAluguel();
    }

    public InquilinoResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Aluguel> getAluguel() {
        return aluguel;
    }

    public void setAluguel(List<Aluguel> aluguel) {
        this.aluguel = aluguel;
    }
}
