package br.com.fiap.gestao_residuos.service;

import br.com.fiap.gestao_residuos.exception.NotFoundException;
import br.com.fiap.gestao_residuos.model.TipoResiduo;
import br.com.fiap.gestao_residuos.repository.TipoResiduoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoResiduoService {

    private final TipoResiduoRepository repository;

    public List<TipoResiduo> listar() {
        return repository.findAll();
    }

    public TipoResiduo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Tipo de Resíduo não encontrado"));
    }
}
