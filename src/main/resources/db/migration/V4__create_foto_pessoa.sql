CREATE TABLE foto_pessoa (
    fp_id SERIAL PRIMARY KEY,
    fp_data DATE,
    fp_bucket VARCHAR(50),
    fp_hash VARCHAR(50),
    pes_id INT REFERENCES pessoa(pes_id)
);