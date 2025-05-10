package br.com.fiap.gestao_residuos.repository;

import br.com.fiap.gestao_residuos.model.Coleta;
import br.com.fiap.gestao_residuos.model.PontoColeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColetaRepository extends JpaRepository<Coleta, Long> {

    // extra: para listar coletas de um ponto específico (caso precise)
    List<Coleta> findByPontoColeta(PontoColeta pontoColeta);
}
