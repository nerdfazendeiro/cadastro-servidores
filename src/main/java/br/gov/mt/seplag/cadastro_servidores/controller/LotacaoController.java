package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.lotacao.DadosCadastroLotacao;
import br.gov.mt.seplag.cadastro_servidores.lotacao.Lotacao;
import br.gov.mt.seplag.cadastro_servidores.lotacao.LotacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController {

    @Autowired
    private LotacaoRepository lotacaoRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroLotacao dados) {
        lotacaoRepository.save(new Lotacao(dados));
    }

}
