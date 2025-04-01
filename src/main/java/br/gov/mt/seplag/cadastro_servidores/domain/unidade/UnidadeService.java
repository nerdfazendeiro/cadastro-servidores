package br.gov.mt.seplag.cadastro_servidores.domain.unidade;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public DadosDetalhamentoUnidade cadastrar(DadosCadastroUnidade dados) {
        Unidade unidade = new Unidade(dados);
        unidadeRepository.save(unidade);
        return new DadosDetalhamentoUnidade(unidade);
    }

    public Page<DadosDetalhamentoUnidade> listar(Pageable pageable) {
        return unidadeRepository.findAll(pageable)
                .map(DadosDetalhamentoUnidade::new);
    }

    public DadosDetalhamentoUnidade buscarPorId(Long id) {
        Unidade unidade = unidadeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unidade não encontrada"));
        return new DadosDetalhamentoUnidade(unidade);
    }

    public DadosDetalhamentoUnidade atualizar(Long id, DadosAtualizacaoUnidade dados) {
        Unidade unidade = unidadeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unidade não encontrada"));

        unidade.setUnidNome(dados.nome());
        unidade.setUnidSigla(dados.sigla());

        return new DadosDetalhamentoUnidade(unidadeRepository.save(unidade));
    }
}