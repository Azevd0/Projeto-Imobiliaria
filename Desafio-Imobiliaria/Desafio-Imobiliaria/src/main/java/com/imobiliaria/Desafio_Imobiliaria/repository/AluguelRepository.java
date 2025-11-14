package com.imobiliaria.Desafio_Imobiliaria.repository;

import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel,Long> {

    List<Aluguel> findByPagoFalseAndDataVencimentoBefore(LocalDate data);
}
