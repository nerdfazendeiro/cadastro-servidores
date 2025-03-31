package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.servidor.DadosCadastroServidor;
import br.gov.mt.seplag.cadastro_servidores.unidade.DadosCadastroUnidade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroUnidade dados) {
        System.out.println(dados);
    }
}
