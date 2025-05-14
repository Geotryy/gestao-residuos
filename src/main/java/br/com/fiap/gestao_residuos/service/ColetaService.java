package br.com.fiap.gestao_residuos.service;

import br.com.fiap.gestao_residuos.enums.StatusColeta;
import br.com.fiap.gestao_residuos.model.Coleta;
import br.com.fiap.gestao_residuos.model.PontoColeta;
import br.com.fiap.gestao_residuos.model.Reciclavel;
import br.com.fiap.gestao_residuos.repository.ColetaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ColetaService {

    private final ColetaRepository repository;
    private final ReciclavelService reciclavelService;
    private final PontoColetaService pontoColetaService;

    public List<Coleta> listarPorPonto(Long idPonto) {
        PontoColeta ponto = pontoColetaService.buscarPorId(idPonto);
        return repository.findByPontoColeta(ponto);
    }

    public Coleta registrarColeta(Long idReciclavel, Long idPonto) {
        Reciclavel reciclavel = reciclavelService.buscarPorId(idReciclavel);
        PontoColeta ponto = pontoColetaService.buscarPorId(idPonto);

        Coleta coleta = new Coleta();
        coleta.setIdColeta(System.currentTimeMillis());
        coleta.setDtColeta(LocalDate.now());
        coleta.setPontoColeta(ponto);
        coleta.setReciclavel(reciclavel);

        reciclavel.setStatusColeta(StatusColeta.valueOf("C"));
        reciclavelService.atualizar(idReciclavel, reciclavel);

        return repository.save(coleta);
    }}
