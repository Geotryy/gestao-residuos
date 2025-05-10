package br.com.fiap.gestao_residuos.service;


import br.com.fiap.gestao_residuos.exception.NotFoundException;
import br.com.fiap.gestao_residuos.model.PontoColeta;
import br.com.fiap.gestao_residuos.repository.PontoColetaRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PontoColetaService {

    private final PontoColetaRepository repository;

    public List<PontoColeta> listar() {
        return repository.findAll();
    }

    public PontoColeta buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ponto de Coleta não encontrado"));
    }

    public PontoColeta criar(PontoColeta ponto) {
        return repository.save(ponto);
    }

    public PontoColeta atualizar(Long id, PontoColeta novoPonto) {
        PontoColeta existente = buscarPorId(id);
        existente.setNmPonto(novoPonto.getNmPonto());
        existente.setEnderecoPonto(novoPonto.getEnderecoPonto());
        existente.setCapacidKgPonto(novoPonto.getCapacidKgPonto());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }
}
