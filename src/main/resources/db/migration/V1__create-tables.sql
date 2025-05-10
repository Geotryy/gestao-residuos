
CREATE TABLE tb_ponto_coleta (
                                 id_ponto         NUMBER PRIMARY KEY,
                                 nm_ponto         VARCHAR2(100) NOT NULL,
                                 endereco_ponto   VARCHAR2(200) NOT NULL,
                                 capacid_kg_ponto NUMBER NOT NULL
);

CREATE TABLE tb_tipo_residuo (
                                 id_tipo           NUMBER PRIMARY KEY,
                                 nm_tipo           VARCHAR2(50) NOT NULL,
                                 tempo_decomp_dias NUMBER NOT NULL
);


CREATE TABLE tb_reciclavel (
                               id_material               NUMBER PRIMARY KEY,
                               peso_kg                   NUMBER NOT NULL,
                               dt_descarte               DATE,
                               status_coleta            CHAR NOT NULL,
                               tb_tipo_residuo_id_tipo  NUMBER NOT NULL,
                               tb_ponto_coleta_id_ponto NUMBER NOT NULL,
                               CONSTRAINT tb_material_tb_tipo_residuo_fk FOREIGN KEY (tb_tipo_residuo_id_tipo)
                                   REFERENCES tb_tipo_residuo (id_tipo),
                               CONSTRAINT tb_material_tb_ponto_coleta_fk FOREIGN KEY (tb_ponto_coleta_id_ponto)
                                   REFERENCES tb_ponto_coleta (id_ponto)
);


CREATE TABLE tb_coleta (
                           id_coleta                NUMBER PRIMARY KEY,
                           dt_coleta                DATE NOT NULL,
                           tb_material_id_material  NUMBER NOT NULL,
                           tb_ponto_coleta_id_ponto NUMBER NOT NULL,
                           CONSTRAINT tb_coleta_tb_material_fk FOREIGN KEY (tb_material_id_material)
                               REFERENCES tb_reciclavel (id_material),
                           CONSTRAINT tb_coleta_tb_ponto_coleta_fk FOREIGN KEY (tb_ponto_coleta_id_ponto)
                               REFERENCES tb_ponto_coleta (id_ponto)
);


