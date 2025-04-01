package br.gov.mt.seplag.cadastro_servidores.lotacao;

import java.time.LocalDate;

public record DadosDetalhamentoLotacao(
        Long id,
        String nomePessoa,
        String nomeUnidade,
        LocalDate dataLotacao,
        LocalDate dataRemocao,
        String portaria
) {
    public DadosDetalhamentoLotacao(Lotacao lotacao) {
        this(
                lotacao.getLotId(),
                lotacao.getPessoa().getPesNome(),
                lotacao.getUnidade().getUnidNome(),
                lotacao.getLotDataLotacao(),
                lotacao.getLotDataRemocao(),
                lotacao.getLotPortaria()
        );
    }
}