package br.gov.mt.seplag.cadastro_servidores.servidor;

import br.gov.mt.seplag.cadastro_servidores.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.pessoa.DadosPessoa;

public record DadosListagemServidorEfetivo(DadosPessoa pessoa, DadosEndereco endereco, String matricula) {
}
