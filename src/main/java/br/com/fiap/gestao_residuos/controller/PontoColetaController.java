package br.com.fiap.gestao_residuos.controller;

import br.com.fiap.gestao_residuos.dto.PontoColetaDTO;
import br.com.fiap.gestao_residuos.model.PontoColeta;
import br.com.fiap.gestao_residuos.service.PontoColetaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pontos-coleta")
@RequiredArgsConstructor
public class PontoColetaController {

    private final PontoColetaService service;

    @GetMapping
    public ResponseEntity<List<PontoColeta>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PontoColeta> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PontoColeta> criar(@RequestBody @Valid PontoColetaDTO dto) {
        PontoColeta ponto = new PontoColeta();
        ponto.setNmPonto(dto.nmPonto());
        ponto.setEnderecoPonto(dto.enderecoPonto());
        ponto.setCapacidKgPonto(dto.capacidKgPonto());

        PontoColeta salvo = service.criar(ponto);
        return ResponseEntity.created(URI.create("/pontos-coleta/" + salvo.getIdPonto())).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PontoColeta> atualizar(@PathVariable Long id, @RequestBody @Valid PontoColetaDTO dto) {
        PontoColeta ponto = new PontoColeta();
        ponto.setNmPonto(dto.nmPonto());
        ponto.setEnderecoPonto(dto.enderecoPonto());
        ponto.setCapacidKgPonto(dto.capacidKgPonto());

        return ResponseEntity.ok(service.atualizar(id, ponto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
