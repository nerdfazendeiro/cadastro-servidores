package br.gov.mt.seplag.cadastro_servidores.servidor;

import br.gov.mt.seplag.cadastro_servidores.endereco.Cidade;
import br.gov.mt.seplag.cadastro_servidores.endereco.Endereco;
import br.gov.mt.seplag.cadastro_servidores.pessoa.Pessoa;
import br.gov.mt.seplag.cadastro_servidores.pessoa.PessoaEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServidorService {

    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;
    @Autowired
    private ServidorTemporarioRepository servidorTemporarioRepository;

    public void cadastrar(DadosCadastroServidor dados) {
        Pessoa pessoa = new Pessoa(dados.pessoa());
        Endereco endereco = new Endereco(dados.endereco());
        Cidade cidade = new Cidade(dados.endereco().cidade());
        endereco.setCidade(cidade);

        PessoaEndereco pessoaEndereco = new PessoaEndereco();
        pessoaEndereco.setPessoa(pessoa);
        pessoaEndereco.setEndereco(endereco);
        pessoa.getEnderecos().add(pessoaEndereco);

        if (dados.tipo() == TipoServidor.EFETIVO) {
            servidorEfetivoRepository.save(new ServidorEfetivo(dados, pessoa));
            System.out.println("Servidor Efetivo cadastrado com sucesso!");
        } else if (dados.tipo() == TipoServidor.TEMPORARIO) {
            servidorTemporarioRepository.save(new ServidorTemporario(dados, pessoa));
            System.out.println("Servidor Temporario cadastrado com sucesso!");
        }
    }

    public Object buscarPorTipoEId(TipoServidor tipo, Long id) {
        return switch (tipo) {
            case EFETIVO -> buscarEfetivo(id);
            case TEMPORARIO -> buscarTemporario(id);
        };
    }

    public Page<?> listarPorTipo(TipoServidor tipo, Pageable pageable) {
        return switch (tipo) {
            case EFETIVO -> servidorEfetivoRepository.findAll(pageable).map(DadosDetalhamentoServidorEfetivo::new);
            case TEMPORARIO -> servidorTemporarioRepository.findAll(pageable).map(DadosDetalhamentoServidorTemporario::new);
        };
    }

    private List<DadosDetalhamentoServidorEfetivo> listarEfetivos() {
        return servidorEfetivoRepository.findAll().stream()
                .map(DadosDetalhamentoServidorEfetivo::new)
                .toList();
    }

    private List<DadosDetalhamentoServidorTemporario> listarTemporarios() {
        return servidorTemporarioRepository.findAll().stream()
                .map(DadosDetalhamentoServidorTemporario::new)
                .toList();
    }

    private DadosDetalhamentoServidorEfetivo buscarEfetivo(Long id) {
        ServidorEfetivo servidor = servidorEfetivoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new DadosDetalhamentoServidorEfetivo(servidor);
    }

    private DadosDetalhamentoServidorTemporario buscarTemporario(Long id) {
        ServidorTemporario servidor = servidorTemporarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new DadosDetalhamentoServidorTemporario(servidor);
    }
}
