package br.com.fiap.gestao_residuos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_tipo_residuo")
@Getter @Setter
public class TipoResiduo {

    @Id
    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "nm_tipo", nullable = false, length = 50)
    private String nmTipo;

    @Column(name = "tempo_decomp_dias", nullable = false)
    private Integer tempoDecompDias;
}
