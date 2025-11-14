package com.imobiliaria.Desafio_Imobiliaria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "inquilino")
public class Inquilino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String nome;

    @Email(message = "Formato de e-mail inválido.")
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "inquilino")
    private List<Aluguel> aluguel = new ArrayList<>();

    public Inquilino() {
    }

    public Inquilino(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.aluguel = aluguel;
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
