package br.com.fiap.gestao_residuos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record ReciclavelDTO(


        @NotNull(message = "O peso do material é obrigatório")
        @Positive(message = "O peso deve ser maior que zero")
        Double pesoKg,

        LocalDate dtDescarte,

        @NotNull(message = "O status da coleta é obrigatório")
        @Pattern(regexp = "^[AC]$", message = "O status deve ser 'A' (Pendente) ou 'C' (Coletado)")
        String statusColeta,

        @NotNull(message = "O tipo de resíduo é obrigatório")
        Long idTipoResiduo,

        @NotNull(message = "O ponto de coleta é obrigatório")
        Long idPontoColeta
) {}
