package br.gov.mt.seplag.cadastro_servidores.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosCidade(
        @NotBlank
        String nome,
        @NotBlank
        String uf) {
        public DadosCidade(Cidade cidade) {
                this(
                        cidade.getCidNome(),
                        cidade.getCidUf()
                );
        }
}
