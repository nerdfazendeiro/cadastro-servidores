package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.unidade.DadosCadastroUnidade;
import br.gov.mt.seplag.cadastro_servidores.unidade.Unidade;
import br.gov.mt.seplag.cadastro_servidores.unidade.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroUnidade dados) {
        unidadeRepository.save(new Unidade(dados));
    }
}
