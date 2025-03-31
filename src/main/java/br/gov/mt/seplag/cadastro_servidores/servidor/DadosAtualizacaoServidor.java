package br.gov.mt.seplag.cadastro_servidores.servidor;

import br.gov.mt.seplag.cadastro_servidores.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.pessoa.DadosPessoa;

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
