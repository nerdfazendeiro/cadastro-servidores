CREATE TABLE servidor_temporario (
    pes_id INT PRIMARY KEY REFERENCES pessoa(pes_id),
    st_data_admissao DATE NOT NULL,
    st_data_demissao DATE
);