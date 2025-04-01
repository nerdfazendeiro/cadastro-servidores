package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.domain.lotacao.DadosAtualizacaoLotacao;
import br.gov.mt.seplag.cadastro_servidores.domain.lotacao.DadosCadastroLotacao;
import br.gov.mt.seplag.cadastro_servidores.domain.lotacao.DadosDetalhamentoLotacao;
import br.gov.mt.seplag.cadastro_servidores.domain.lotacao.LotacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController {

    @Autowired
    private LotacaoService lotacaoService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoLotacao> cadastrar(@RequestBody @Valid DadosCadastroLotacao dados) {
        return ResponseEntity.ok(lotacaoService.cadastrar(dados));
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoLotacao>> listarTodos() {
        return ResponseEntity.ok(lotacaoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoLotacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(lotacaoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoLotacao> atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoLotacao dados) {
        return ResponseEntity.ok(lotacaoService.atualizar(id, dados));
    }
}

