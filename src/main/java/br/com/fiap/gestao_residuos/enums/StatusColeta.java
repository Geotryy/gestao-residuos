package br.com.fiap.gestao_residuos.enums;

public enum StatusColeta {
    A("Pendente"),
    C("Coletado");

    private final String descricao;
    StatusColeta(String descricao) { this.descricao = descricao; }
    public String getDescricao() { return descricao; }
}

