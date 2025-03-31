package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.lotacao.DadosCadastroLotacao;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lotacao")
public class LotacaoController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroLotacao dados) {
        System.out.println(dados);
    }

}
