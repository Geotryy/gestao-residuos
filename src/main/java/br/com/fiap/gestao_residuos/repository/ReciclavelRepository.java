package br.com.fiap.repository;


import br.com.fiap.gestao_residuos.model.PontoColeta;
import br.com.fiap.gestao_residuos.model.Reciclavel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReciclavelRepository extends JpaRepository<Reciclavel, Long> {

    // extra: para listar recicláveis de um ponto específico
    List<Reciclavel> findByPontoColeta(PontoColeta pontoColeta);
}
