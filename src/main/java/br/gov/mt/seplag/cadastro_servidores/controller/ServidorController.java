package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.servidor.DadosCadastroServidor;
import br.gov.mt.seplag.cadastro_servidores.servidor.TipoServidor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroServidor dados) {
        if (dados.tipo() == TipoServidor.EFETIVO) {
            System.out.println(dados);
        } else if (dados.tipo() == TipoServidor.TEMPORARIO) {
            System.out.println(dados);
        }
    }
}
