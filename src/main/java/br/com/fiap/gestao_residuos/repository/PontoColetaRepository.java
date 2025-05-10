package br.com.fiap.gestao_residuos.repository;


import br.com.fiap.gestao_residuos.model.PontoColeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PontoColetaRepository extends JpaRepository<PontoColeta, Long> {
}
