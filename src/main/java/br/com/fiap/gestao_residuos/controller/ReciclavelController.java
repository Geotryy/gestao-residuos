package br.com.fiap.gestao_residuos.controller;

import br.com.fiap.gestao_residuos.dto.ReciclavelDTO;
import br.com.fiap.gestao_residuos.model.Reciclavel;
import br.com.fiap.gestao_residuos.service.ReciclavelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reciclaveis")
@RequiredArgsConstructor
public class ReciclavelController {

    private final ReciclavelService service;

    @GetMapping
    public ResponseEntity<List<Reciclavel>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reciclavel> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/ponto/{idPonto}")
    public ResponseEntity<List<Reciclavel>> listarPorPonto(@PathVariable Long idPonto) {
        return ResponseEntity.ok(service.listarPorPonto(idPonto));
    }

    @PostMapping
    public ResponseEntity<Reciclavel> criar(@RequestBody @Valid ReciclavelDTO dto) {
        Reciclavel reciclavel = new Reciclavel();
        reciclavel.setIdMaterial(dto.idMaterial());
        reciclavel.setPesoKg(dto.pesoKg());
        reciclavel.setStatusColeta(dto.statusColeta());
        reciclavel.setDtDescarte(dto.dtDescarte());

        Reciclavel salvo = service.criar(reciclavel, dto.idTipoResiduo(), dto.idPontoColeta());
        return ResponseEntity.created(URI.create("/reciclaveis/" + salvo.getIdMaterial())).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reciclavel> atualizar(@PathVariable Long id, @RequestBody @Valid ReciclavelDTO dto) {
        Reciclavel reciclavel = new Reciclavel();
        reciclavel.setPesoKg(dto.pesoKg());
        reciclavel.setStatusColeta(dto.statusColeta());

        return ResponseEntity.ok(service.atualizar(id, reciclavel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}