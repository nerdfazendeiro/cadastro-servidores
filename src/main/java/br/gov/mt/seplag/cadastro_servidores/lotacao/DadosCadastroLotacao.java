package br.gov.mt.seplag.cadastro_servidores.lotacao;

import br.gov.mt.seplag.cadastro_servidores.pessoa.DadosPessoa;
import br.gov.mt.seplag.cadastro_servidores.unidade.DadosCadastroUnidade;

import java.time.LocalDate;

public record DadosCadastroLotacao (DadosPessoa pessoa,
                                    DadosCadastroUnidade unidade,
                                    LocalDate dataLotacao,
                                    LocalDate dataRemocao,
                                    String portaria) {
}
