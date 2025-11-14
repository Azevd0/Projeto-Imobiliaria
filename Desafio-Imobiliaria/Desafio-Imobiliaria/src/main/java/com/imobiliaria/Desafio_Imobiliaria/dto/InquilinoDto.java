package com.imobiliaria.Desafio_Imobiliaria.dto;

import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class InquilinoDto {
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String nome;

    @Email(message = "Formato de e-mail inválido.")
    private String email;

    private List<Aluguel> aluguel = new ArrayList<>();

    public InquilinoDto(Long id, String nome, String email, List<Aluguel> aluguel) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.aluguel = aluguel;
    }

    public InquilinoDto() {
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
