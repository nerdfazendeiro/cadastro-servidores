package br.gov.mt.seplag.cadastro_servidores.unidade;

public record DadosDetalhamentoUnidade(
        Long id,
        String nome,
        String sigla
) {
    public DadosDetalhamentoUnidade(Unidade unidade) {
        this(unidade.getUnidId(), unidade.getUnidNome(), unidade.getUnidSigla());
    }
}