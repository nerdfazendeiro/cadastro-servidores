package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.servidor.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/servidores")
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroServidor dados) {
        servidorService.cadastrar(dados);
    }

    @GetMapping
    public ResponseEntity<Page<?>> listarPorTipo(@RequestParam TipoServidor tipo, Pageable pageable) {
        return ResponseEntity.ok(servidorService.listarPorTipo(tipo, pageable));
    }

    @GetMapping("/{tipo}/{id}")
    public ResponseEntity<?> buscarPorTipoEId(@PathVariable TipoServidor tipo, @PathVariable Long id) {
        return ResponseEntity.ok(servidorService.buscarPorTipoEId(tipo, id));
    }
}
