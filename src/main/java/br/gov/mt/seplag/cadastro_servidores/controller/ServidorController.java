package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.servidor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/servidores")
public class ServidorController {

    @Autowired
    private ServidorService servidorService;

    @PostMapping(value = "/com-foto", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<Void> cadastrar(
            @RequestPart @Valid DadosCadastroServidor dados,
            @RequestPart("foto") MultipartFile foto
    ) {
        servidorService.cadastrarComFoto(dados, foto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<?>> listarPorTipo(@RequestParam TipoServidor tipo, Pageable pageable) {
        return ResponseEntity.ok(servidorService.listarPorTipo(tipo, pageable));
    }

    @GetMapping("/{tipo}/{id}")
    public ResponseEntity<?> buscarPorTipoEId(@PathVariable TipoServidor tipo, @PathVariable Long id) {
        return ResponseEntity.ok(servidorService.buscarPorTipoEId(tipo, id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizar(@RequestBody @Valid DadosAtualizacaoServidor dados) {
        servidorService.atualizar(dados);
        return ResponseEntity.noContent().build();
    }
}
