package br.gov.mt.seplag.cadastro_servidores.domain.pessoa;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record DadosPessoa(
        @NotBlank
        String nome,

        @Past
        LocalDate dataNascimento,

        @NotNull
        @JsonProperty("sexo")
        Sexo sexo,

        String pai,
        String mae) {

        public DadosPessoa(Pessoa pessoa) {
                this(
                        pessoa.getPesNome(),
                        pessoa.getPesDataNascimento(),
                        pessoa.getPesSexo(),
                        pessoa.getPesMae(),
                        pessoa.getPesPai()
                );
        }
}
