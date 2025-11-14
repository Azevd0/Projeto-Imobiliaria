package com.imobiliaria.Desafio_Imobiliaria.repository;

import com.imobiliaria.Desafio_Imobiliaria.models.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel,Long> {
}
