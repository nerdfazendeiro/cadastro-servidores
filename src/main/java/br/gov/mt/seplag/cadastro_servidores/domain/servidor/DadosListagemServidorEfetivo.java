package br.gov.mt.seplag.cadastro_servidores.domain.servidor;

import br.gov.mt.seplag.cadastro_servidores.domain.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.DadosPessoa;

public record DadosListagemServidorEfetivo(DadosPessoa pessoa, DadosEndereco endereco, String matricula) {
}
