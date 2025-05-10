package br.com.fiap.gestao_residuos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_coleta")
@Getter @Setter
public class Coleta {

    @Id
    @Column(name = "id_coleta")
    private Long idColeta;

    @Column(name = "dt_coleta", nullable = false)
    private LocalDate dtColeta;

    @ManyToOne
    @JoinColumn(name = "tb_material_id_material", nullable = false)
    private Reciclavel reciclavel;

    @ManyToOne
    @JoinColumn(name = "tb_ponto_coleta_id_ponto", nullable = false)
    private PontoColeta pontoColeta;
}
