CREATE TABLE lotacao (
    lot_id SERIAL PRIMARY KEY,
    lot_data_lotacao DATE NOT NULL,
    lot_data_remocao DATE NOT NULL,
    lot_portaria VARCHAR(255) NOT NULL,
    pes_id INT REFERENCES pessoa(pes_id),
    unid_id INT REFERENCES unidade(unid_id)
);