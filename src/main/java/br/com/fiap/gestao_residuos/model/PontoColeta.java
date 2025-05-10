package br.com.fiap.gestao_residuos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_ponto_coleta")
@Getter @Setter
public class PontoColeta {

    @Id
    @Column(name = "id_ponto")
    private Long idPonto;

    @Column(name = "nm_ponto", nullable = false, length = 100)
    private String nmPonto;

    @Column(name = "endereco_ponto", nullable = false, length = 200)
    private String enderecoPonto;

    @Column(name = "capacid_kg_ponto", nullable = false)
    private Double capacidKgPonto;
}
