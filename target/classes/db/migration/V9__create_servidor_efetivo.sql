CREATE TABLE servidor_efetivo (
    pes_id INT PRIMARY KEY REFERENCES pessoa(pes_id),
    se_matricula VARCHAR(20) NOT NULL
);