package br.gov.mt.seplag.cadastro_servidores.domain.lotacao;

import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.Pessoa;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.PessoaRepository;
import br.gov.mt.seplag.cadastro_servidores.domain.unidade.Unidade;
import br.gov.mt.seplag.cadastro_servidores.domain.unidade.UnidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotacaoService {

    @Autowired
    private LotacaoRepository lotacaoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    public DadosDetalhamentoLotacao cadastrar(DadosCadastroLotacao dados) {
        Pessoa pessoa = pessoaRepository.findById(dados.pessoaId())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        Unidade unidade = unidadeRepository.findById(dados.unidadeId())
                .orElseThrow(() -> new EntityNotFoundException("Unidade não encontrada"));

        Lotacao lotacao = new Lotacao(null, dados.dataLotacao(), dados.dataRemocao(), dados.portaria(), pessoa, unidade);
        lotacaoRepository.save(lotacao);

        return new DadosDetalhamentoLotacao(lotacao);
    }

    public List<DadosDetalhamentoLotacao> listarTodos() {
        return lotacaoRepository.findAll().stream()
                .map(DadosDetalhamentoLotacao::new)
                .toList();
    }

    public DadosDetalhamentoLotacao buscarPorId(Long id) {
        Lotacao lotacao = lotacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lotação não encontrada"));
        return new DadosDetalhamentoLotacao(lotacao);
    }

    public DadosDetalhamentoLotacao atualizar(Long id, DadosAtualizacaoLotacao dados) {
        Lotacao lotacao = lotacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lotação não encontrada"));

        Pessoa pessoa = pessoaRepository.findById(dados.pessoaId())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        Unidade unidade = unidadeRepository.findById(dados.unidadeId())
                .orElseThrow(() -> new EntityNotFoundException("Unidade não encontrada"));

        lotacao.setPessoa(pessoa);
        lotacao.setUnidade(unidade);
        lotacao.setLotDataLotacao(dados.dataLotacao());
        lotacao.setLotDataRemocao(dados.dataRemocao());
        lotacao.setLotPortaria(dados.portaria());

        return new DadosDetalhamentoLotacao(lotacaoRepository.save(lotacao));
    }
}