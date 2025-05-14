package br.com.fiap.gestao_residuos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_ponto_coleta")
@Getter @Setter
public class PontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto_seq")
    @SequenceGenerator(
            name = "ponto_seq",
            sequenceName = "SQ_PONTO_COLETA",
            allocationSize = 1
    )
    @Column(name = "id_ponto")
    private Long idPonto;

    @Column(name = "nm_ponto", nullable = false, length = 100)
    private String nmPonto;

    @Column(name = "endereco_ponto", nullable = false, length = 200)
    private String enderecoPonto;

    @Column(name = "capacid_kg_ponto", nullable = false)
    private Double capacidKgPonto;
}
