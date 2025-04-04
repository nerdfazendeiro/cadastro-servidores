package br.gov.mt.seplag.cadastro_servidores.domain.servidor;

import br.gov.mt.seplag.cadastro_servidores.domain.endereco.Cidade;
import br.gov.mt.seplag.cadastro_servidores.domain.endereco.DadosEndereco;
import br.gov.mt.seplag.cadastro_servidores.domain.endereco.Endereco;
import br.gov.mt.seplag.cadastro_servidores.domain.foto.FotoService;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.Pessoa;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.PessoaEndereco;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServidorService {

    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;
    @Autowired
    private ServidorTemporarioRepository servidorTemporarioRepository;
    @Autowired
    private FotoService fotoService;

    public void cadastrarComFoto(DadosCadastroServidor dados, MultipartFile foto) {
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
        fotoService.salvarFotoPessoa(foto, pessoa);
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

    @Transactional
    public void atualizar(DadosAtualizacaoServidor dados) {
        switch (dados.tipo()) {
            case EFETIVO -> atualizarEfetivo(dados);
            case TEMPORARIO -> atualizarTemporario(dados);
        }
    }
    private void atualizarEfetivo(DadosAtualizacaoServidor dados) {
        ServidorEfetivo servidor = servidorEfetivoRepository.findById(dados.id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servidor efetivo com ID " + dados.id() + " não encontrado."));

        Pessoa pessoa = servidor.getPessoa();
        pessoa.setPesNome(dados.pessoa().nome());
        pessoa.setPesDataNascimento(dados.pessoa().dataNascimento());
        pessoa.setPesSexo(dados.pessoa().sexo());
        pessoa.setPesMae(dados.pessoa().mae());
        pessoa.setPesPai(dados.pessoa().pai());

        pessoa.getEnderecos().clear();

        for (DadosEndereco e : dados.enderecos()) {
            Endereco endereco = new Endereco(e);
            endereco.setCidade(new Cidade(e.cidade()));
            PessoaEndereco pe = new PessoaEndereco();
            pe.setPessoa(pessoa);
            pe.setEndereco(endereco);
            pessoa.getEnderecos().add(pe);
        }

        servidor.setSeMatricula(dados.matricula());
    }
    private void atualizarTemporario(DadosAtualizacaoServidor dados) {
        ServidorTemporario servidor = servidorTemporarioRepository.findById(dados.id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Servidor efetivo com ID " + dados.id() + " não encontrado."));

        Pessoa pessoa = servidor.getPessoa();
        pessoa.setPesNome(dados.pessoa().nome());
        pessoa.setPesDataNascimento(dados.pessoa().dataNascimento());
        pessoa.setPesSexo(dados.pessoa().sexo());
        pessoa.setPesMae(dados.pessoa().mae());
        pessoa.setPesPai(dados.pessoa().pai());

        pessoa.getEnderecos().clear();

        for (DadosEndereco e : dados.enderecos()) {
            Endereco endereco = new Endereco(e);
            endereco.setCidade(new Cidade(e.cidade()));
            PessoaEndereco pe = new PessoaEndereco();
            pe.setPessoa(pessoa);
            pe.setEndereco(endereco);
            pessoa.getEnderecos().add(pe);
        }

        servidor.setStDataAdmissao(dados.dataAdmissao());
        servidor.setStDataDemissao(dados.dataDemissao());
    }
}
