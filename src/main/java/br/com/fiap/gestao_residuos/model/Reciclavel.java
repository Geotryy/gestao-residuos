package br.com.fiap.gestao_residuos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_reciclavel")
@Getter @Setter
public class Reciclavel {

    @Id
    @Column(name = "id_material")
    private Long idMaterial;

    @Column(name = "peso_kg", nullable = false)
    private Double pesoKg;

    @Column(name = "dt_descarte")
    private LocalDate dtDescarte;

    @Column(name = "status_coleta", nullable = false, length = 1)
    private String statusColeta;

    @ManyToOne
    @JoinColumn(name = "tb_tipo_residuo_id_tipo", nullable = false)
    private TipoResiduo tipoResiduo;

    @ManyToOne
    @JoinColumn(name = "tb_ponto_coleta_id_ponto", nullable = false)
    private PontoColeta pontoColeta;
}
