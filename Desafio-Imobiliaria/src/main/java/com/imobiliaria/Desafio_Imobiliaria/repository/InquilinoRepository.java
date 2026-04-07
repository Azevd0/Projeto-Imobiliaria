package com.imobiliaria.Desafio_Imobiliaria.repository;

import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino,Long> {

    @EntityGraph(attributePaths = "aluguel")
    Optional<Inquilino> findByNomeIgnoreCase(String nome);

    @Override
    @EntityGraph(attributePaths = "aluguel")
    List<Inquilino> findAll();
}
