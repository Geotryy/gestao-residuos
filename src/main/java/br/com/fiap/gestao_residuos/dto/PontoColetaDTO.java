package br.com.fiap.gestao_residuos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PontoColetaDTO(


        @NotBlank(message = "O nome do ponto é obrigatório")
        String nmPonto,

        @NotBlank(message = "O endereço do ponto é obrigatório")
        String enderecoPonto,

        @NotNull(message = "A capacidade em kg é obrigatória")
        @Positive(message = "A capacidade deve ser maior que zero")
        Double capacidKgPonto
) {}
