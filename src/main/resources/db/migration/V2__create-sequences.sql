-- V2__create_sequences.sql
-- Cria sequences para IDs auto-gerados

-- Sequence para tb_ponto_coleta.id_ponto
CREATE SEQUENCE SQ_PONTO_COLETA
    START WITH 1
    INCREMENT BY 1
    NOCACHE;  -- ou CACHE 20 se preferir performance

-- Sequence para tb_tipo_residuo.id_tipo
CREATE SEQUENCE SQ_TIPO_RESIDUO
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

-- Sequence para tb_reciclavel.id_material
CREATE SEQUENCE SQ_RECICLAVEL
    START WITH 1
    INCREMENT BY 1
    NOCACHE;

-- Sequence para tb_coleta.id_coleta
CREATE SEQUENCE SQ_COLETA
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
