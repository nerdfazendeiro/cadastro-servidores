package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.servidor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servidores")
public class ServidorController {

    @Autowired
    private ServidorEfetivoRepository servidorEfetivoRepository;
    @Autowired
    private ServidorTemporarioRepository servidorTemporarioRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroServidor dados) {
        if (dados.tipo() == TipoServidor.EFETIVO) {
            servidorEfetivoRepository.save(new ServidorEfetivo(dados));
        } else if (dados.tipo() == TipoServidor.TEMPORARIO) {
            servidorTemporarioRepository.save(new ServidorTemporario(dados));
        }
    }
}
