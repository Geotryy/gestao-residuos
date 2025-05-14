package br.com.fiap.gestao_residuos.model;

import br.com.fiap.gestao_residuos.enums.StatusColeta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "tb_reciclavel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reciclavel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reciclavel_seq")
    @SequenceGenerator(
            name = "reciclavel_seq",
            sequenceName = "SQ_RECICLAVEL",
            allocationSize = 1
    )
    @Column(name = "id_material")
    private Long idMaterial;

    @Column(name = "peso_kg", nullable = false)
    private Double pesoKg;

    @Column(name = "dt_descarte")
    private LocalDate dtDescarte;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_coleta", nullable = false, length = 1)
    private StatusColeta statusColeta;


    @ManyToOne
    @JoinColumn(name = "tb_tipo_residuo_id_tipo", nullable = false)
    private TipoResiduo tipoResiduo;

    @ManyToOne
    @JoinColumn(name = "tb_ponto_coleta_id_ponto", nullable = false)
    private PontoColeta pontoColeta;
}
