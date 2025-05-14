package br.com.fiap.gestao_residuos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_tipo_residuo")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoResiduo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "residuo_seq")
    @SequenceGenerator(
            name = "residuo_seq",
            sequenceName = "SQ_RESIDUO",
            allocationSize = 1
    )
    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "nm_tipo", nullable = false, length = 50)
    private String nmTipo;

    @Column(name = "tempo_decomp_dias", nullable = false)
    private Integer tempoDecompDias;
}
