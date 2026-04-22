package com.imobiliaria.Desafio_Imobiliaria.service;

import com.imobiliaria.Desafio_Imobiliaria.exceptions.ObjectNotFoundException;
import com.imobiliaria.Desafio_Imobiliaria.models.Aluguel;
import com.imobiliaria.Desafio_Imobiliaria.models.Imovel;
import com.imobiliaria.Desafio_Imobiliaria.models.Inquilino;
import com.imobiliaria.Desafio_Imobiliaria.repository.AluguelRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AluguelServiceTest {

    @Mock
    private AluguelRepository aluguelRepository;

    @Mock
    private InquilinoService inquilinoService;

    @Mock
    private ImovelService imovelService;

    @InjectMocks
    private AluguelService aluguelService;

    private Aluguel aluguel;
    private Long idValido = 1L;

    @BeforeEach
    void setUp() {
        aluguel = new Aluguel();
        aluguel.setId(idValido);
        aluguel.setPago(false);
        aluguel.setDataVencimento(LocalDate.now().minusDays(5));
    }

    @Test
    @DisplayName("Deve retornar um aluguel quando o ID existir")
    void findByIdSucesso() {
        Mockito.when(aluguelRepository.findById(idValido)).thenReturn(Optional.of(aluguel));
        Aluguel result = aluguelService.findById(idValido);
        assertNotNull(result);
        assertEquals(idValido, result.getId());
        Mockito.verify(aluguelRepository, Mockito.times(1)).findById(idValido);
    }

    @Test
    @DisplayName("Deve lançar ObjectNotFoundException quando o ID não existir")
    void findByIdFalha() {
        Mockito.when(aluguelRepository.findById(idValido)).thenReturn(Optional.empty());
        Assertions.assertThrows(ObjectNotFoundException.class, () -> aluguelService.findById(idValido));
    }

    @Test
    @DisplayName("Deve buscar alugueis atrasados corretamente")
    void buscarAtrasados_Sucesso() {
        Mockito.when(aluguelRepository.findByPagoFalseAndDataVencimentoBefore(Mockito.any(LocalDate.class)))
                .thenReturn(List.of(aluguel));

        List<Aluguel> result = aluguelService.buscarAtrasados();

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(1, result.size());
        Mockito.verify(aluguelRepository).findByPagoFalseAndDataVencimentoBefore(Mockito.any(LocalDate.class));
    }

    @Test
    @DisplayName("Deve salvar um aluguel vinculando inquilino e imovel")
    void save_Sucesso() {
        Inquilino inq = new Inquilino();
        Imovel imo = new Imovel();

        Mockito.when(inquilinoService.findById(1L)).thenReturn(inq);
        Mockito.when(imovelService.findById(1L)).thenReturn(imo);
        Mockito.when(aluguelRepository.save(Mockito.any(Aluguel.class))).thenReturn(aluguel);

        Aluguel salvo = aluguelService.save(new Aluguel(), 1L, 1L);

        Assertions.assertNotNull(salvo);
        Mockito.verify(inquilinoService, Mockito.atLeastOnce()).findById(1L);
        Mockito.verify(imovelService, Mockito.atLeastOnce()).findById(1L);
        Mockito.verify(aluguelRepository).save(Mockito.any(Aluguel.class));
    }

    @Test
    @DisplayName("Deve marcar o aluguel como pago")
    void marcarComoPago_Sucesso() {
        Mockito.when(aluguelRepository.findById(idValido)).thenReturn(Optional.of(aluguel));
        Mockito.when(aluguelRepository.save(Mockito.any(Aluguel.class))).thenReturn(aluguel);

        Aluguel result = aluguelService.marcarComoPago(idValido);

        Assertions.assertTrue(result.getPago());
        Mockito.verify(aluguelRepository).save(aluguel);
    }

    @Test
    @DisplayName("Deve deletar o aluguel com sucesso")
    void delete_Sucesso() {
        Mockito.when(aluguelRepository.findById(idValido)).thenReturn(Optional.of(aluguel));
        Mockito.doNothing().when(aluguelRepository).deleteById(idValido);

        aluguelService.delete(idValido);

        Mockito.verify(aluguelRepository, Mockito.times(1)).deleteById(idValido);
    }
}