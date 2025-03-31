package br.gov.mt.seplag.cadastro_servidores.servidor;

import br.gov.mt.seplag.cadastro_servidores.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.pessoa.DadosPessoa;

import java.time.LocalDate;
import java.util.List;

public record DadosDetalhamentoServidorTemporario(DadosPessoa pessoa,
                                                  LocalDate dataAdmissao,
                                                  LocalDate dataDemissao,
                                                  List<DadosEndereco> enderecos) {
    public DadosDetalhamentoServidorTemporario(ServidorTemporario servidor) {
        this(
                new DadosPessoa(servidor.getPessoa()),
                servidor.getStDataAdmissao(),
                servidor.getStDataDemissao(),
                servidor.getPessoa().getEnderecos().stream()
                        .map(pe -> new DadosEndereco(pe.getEndereco()))
                        .toList()
        );
    }
}
