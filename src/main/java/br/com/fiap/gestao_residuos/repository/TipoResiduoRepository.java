package br.com.fiap.gestao_residuos.repository;

import br.com.fiap.gestao_residuos.model.TipoResiduo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoResiduoRepository extends JpaRepository<TipoResiduo, Long> {
}
