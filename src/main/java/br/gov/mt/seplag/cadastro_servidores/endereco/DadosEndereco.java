package br.gov.mt.seplag.cadastro_servidores.endereco;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEndereco(
        @NotBlank
        String tipoLogradouro,
        @NotBlank
        String logradouro,
        int numero,
        @NotBlank
        String bairro,
        @NotNull @Valid
        DadosCidade cidade) {
        public DadosEndereco(Endereco endereco) {
                this(
                        endereco.getEndTipoLogradouro(),
                        endereco.getEndLogradouro(),
                        endereco.getEndNumero(),
                        endereco.getEndBairro(),
                        new DadosCidade(endereco.getCidade())
                );
        }
}
