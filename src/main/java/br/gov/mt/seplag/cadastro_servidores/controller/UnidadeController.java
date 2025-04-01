package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.domain.unidade.DadosAtualizacaoUnidade;
import br.gov.mt.seplag.cadastro_servidores.domain.unidade.DadosCadastroUnidade;
import br.gov.mt.seplag.cadastro_servidores.domain.unidade.DadosDetalhamentoUnidade;
import br.gov.mt.seplag.cadastro_servidores.domain.unidade.UnidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoUnidade> cadastrar(@RequestBody @Valid DadosCadastroUnidade dados) {
        return ResponseEntity.ok(unidadeService.cadastrar(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoUnidade>> listar(Pageable pageable) {
        return ResponseEntity.ok(unidadeService.listar(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUnidade> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(unidadeService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUnidade> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoUnidade dados) {
        return ResponseEntity.ok(unidadeService.atualizar(id, dados));
    }
}
