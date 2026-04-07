package com.imobiliaria.Desafio_Imobiliaria.dto;

import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;

public record InquilinoRequestDto(String nome, String email, String senha) {

    public InquilinoRequestDto(Inquilino inquilino){
        this(
                inquilino.getNome(),
                inquilino.getEmail(),
                inquilino.getSenha()
        );
    }
}
