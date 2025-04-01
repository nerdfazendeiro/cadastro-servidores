package br.gov.mt.seplag.cadastro_servidores.unidade;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoUnidade(
        @NotBlank String nome,
        @NotBlank String sigla
) {}
