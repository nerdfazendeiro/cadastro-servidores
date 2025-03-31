package br.gov.mt.seplag.cadastro_servidores.servidor;

import br.gov.mt.seplag.cadastro_servidores.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.pessoa.DadosPessoa;

import java.time.LocalDate;

public record DadosCadastroServidor(TipoServidor tipo,
                                    DadosPessoa pessoa,
                                    DadosEndereco endereco,
                                    String matricula,
                                    LocalDate dataAdmissao,
                                    LocalDate dataDemissao) {
}
