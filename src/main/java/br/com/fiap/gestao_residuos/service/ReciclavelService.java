package br.com.fiap.gestao_residuos.service;

import br.com.fiap.gestao_residuos.exception.NotFoundException;
import br.com.fiap.gestao_residuos.model.PontoColeta;
import br.com.fiap.gestao_residuos.model.Reciclavel;
import br.com.fiap.gestao_residuos.model.TipoResiduo;
import br.com.fiap.gestao_residuos.repository.ReciclavelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReciclavelService {

    private final ReciclavelRepository repository;
    private final TipoResiduoService tipoResiduoService;
    private final PontoColetaService pontoColetaService;

    public List<Reciclavel> listar() {
        return repository.findAll();
    }

    public Reciclavel buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Material Reciclável não encontrado"));
    }

    public List<Reciclavel> listarPorPonto(Long idPonto) {
        PontoColeta ponto = pontoColetaService.buscarPorId(idPonto);
        return repository.findByPontoColeta(ponto);
    }

    public Reciclavel criar(Reciclavel reciclavel, Long idTipoResiduo, Long idPontoColeta) {
        TipoResiduo tipo = tipoResiduoService.buscarPorId(idTipoResiduo);
        PontoColeta ponto = pontoColetaService.buscarPorId(idPontoColeta);
        reciclavel.setTipoResiduo(tipo);
        reciclavel.setPontoColeta(ponto);
        return repository.save(reciclavel);
    }

    public Reciclavel atualizar(Long id, Reciclavel novo) {
        Reciclavel existente = buscarPorId(id);
        existente.setPesoKg(novo.getPesoKg());
        existente.setStatusColeta(novo.getStatusColeta());
        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.delete(buscarPorId(id));
    }
}
