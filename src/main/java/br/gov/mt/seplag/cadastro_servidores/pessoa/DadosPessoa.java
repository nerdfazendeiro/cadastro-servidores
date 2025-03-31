package br.gov.mt.seplag.cadastro_servidores.pessoa;

import java.time.LocalDate;

public record DadosPessoa(String nome,
                          LocalDate dataNascimento,
                          Sexo sexo,
                          String pai,
                          String mae) {
}
