package br.gov.mt.seplag.cadastro_servidores.lotacao;

import br.gov.mt.seplag.cadastro_servidores.servidor.DadosCadastroServidor;
import br.gov.mt.seplag.cadastro_servidores.unidade.DadosCadastroUnidade;

import java.time.LocalDate;

public record DadosCadastroLotacao (DadosCadastroServidor servidor,
                                    DadosCadastroUnidade unidade,
                                    LocalDate dataLotacao,
                                    LocalDate dataRemocao,
                                    String portaria) {
}
