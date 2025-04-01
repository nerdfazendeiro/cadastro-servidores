package br.gov.mt.seplag.cadastro_servidores.domain.servidor;

import br.gov.mt.seplag.cadastro_servidores.domain.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.DadosPessoa;

import java.util.List;

public record DadosDetalhamentoServidorEfetivo(String matricula,
                                               DadosPessoa pessoa,
                                               List<DadosEndereco> enderecos) {
    public DadosDetalhamentoServidorEfetivo(ServidorEfetivo servidor) {
        this(
                servidor.getSeMatricula(),
                new DadosPessoa(servidor.getPessoa()),
                servidor.getPessoa().getEnderecos().stream()
                        .map(pe -> new DadosEndereco(pe.getEndereco()))
                        .toList()
        );
    }
}
