package br.gov.mt.seplag.cadastro_servidores.domain.servidor;

import br.gov.mt.seplag.cadastro_servidores.domain.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.DadosPessoa;

import java.time.LocalDate;
import java.util.List;

public record DadosAtualizacaoServidor(
        TipoServidor tipo,
        Long id,
        DadosPessoa pessoa,
        List<DadosEndereco> enderecos,
        String matricula,
        LocalDate dataAdmissao,
        LocalDate dataDemissao
) {}
