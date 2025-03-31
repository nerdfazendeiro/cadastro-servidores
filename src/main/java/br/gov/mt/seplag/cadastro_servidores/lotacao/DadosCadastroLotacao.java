package br.gov.mt.seplag.cadastro_servidores.lotacao;

import br.gov.mt.seplag.cadastro_servidores.pessoa.DadosPessoa;
import br.gov.mt.seplag.cadastro_servidores.unidade.DadosCadastroUnidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroLotacao (
        @NotNull @Valid
        DadosPessoa pessoa,

        @NotBlank
        DadosCadastroUnidade unidade,

        @NotBlank
        LocalDate dataLotacao,

        @NotBlank
        LocalDate dataRemocao,

        @NotBlank
        String portaria) {
}
