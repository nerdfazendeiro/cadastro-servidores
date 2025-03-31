CREATE TABLE pessoa_endereco (
    id SERIAL PRIMARY KEY,
    pes_id INT REFERENCES pessoa(pes_id),
    end_id INT REFERENCES endereco(end_id)
);