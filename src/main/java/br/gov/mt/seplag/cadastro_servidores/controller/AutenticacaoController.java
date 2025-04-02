package br.gov.mt.seplag.cadastro_servidores.controller;

import br.gov.mt.seplag.cadastro_servidores.domain.usuario.DadosAutenticacao;
import br.gov.mt.seplag.cadastro_servidores.domain.usuario.Usuario;
import br.gov.mt.seplag.cadastro_servidores.infra.security.DadosTokenJWT;
import br.gov.mt.seplag.cadastro_servidores.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

    @PostMapping("/refresh")
    public ResponseEntity<DadosTokenJWT> renovarToken(@RequestHeader("Authorization") String header) {
        var token = header.replace("Bearer ", "");
        var novoToken = tokenService.renovarToken(token);
        return ResponseEntity.ok(new DadosTokenJWT(novoToken));
    }
}
