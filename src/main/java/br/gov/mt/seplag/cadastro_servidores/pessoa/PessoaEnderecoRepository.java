package br.gov.mt.seplag.cadastro_servidores.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {

}
