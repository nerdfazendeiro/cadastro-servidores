CREATE TABLE unidade_endereco (
    id SERIAL PRIMARY KEY,
    unid_id INT REFERENCES unidade(unid_id),
    end_id INT REFERENCES endereco(end_id)
);