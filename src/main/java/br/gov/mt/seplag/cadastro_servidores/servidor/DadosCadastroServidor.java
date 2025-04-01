package br.gov.mt.seplag.cadastro_servidores.servidor;

import br.gov.mt.seplag.cadastro_servidores.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.pessoa.DadosPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroServidor(
        @NotNull
        TipoServidor tipo,

        @NotNull @Valid
        DadosPessoa pessoa,

        @NotNull @Valid
        DadosEndereco endereco,

        String matricula,
        LocalDate dataAdmissao,
        LocalDate dataDemissao) {
}
