package br.gov.mt.seplag.cadastro_servidores.domain.lotacao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroLotacao(
        @NotNull Long pessoaId,
        @NotNull Long unidadeId,
        @NotNull LocalDate dataLotacao,
        @NotNull LocalDate dataRemocao,
        @NotBlank String portaria
) {}
