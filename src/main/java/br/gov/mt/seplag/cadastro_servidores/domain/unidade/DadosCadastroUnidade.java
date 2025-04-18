package br.gov.mt.seplag.cadastro_servidores.domain.unidade;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUnidade(
        @NotBlank String nome,
        @NotBlank String sigla
) {}