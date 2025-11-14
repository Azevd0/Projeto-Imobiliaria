package com.imobiliaria.Desafio_Imobiliaria.repository;

import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino,Long> {

    public Optional<Inquilino> findByNomeIgnoreCase(String nome);
}
