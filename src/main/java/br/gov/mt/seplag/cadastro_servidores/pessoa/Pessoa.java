package br.gov.mt.seplag.cadastro_servidores.pessoa;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.*;


@Entity
@Table(name = "pessoa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pesId;

    private String pesNome;
    private LocalDate pesDataNascimento;

    @Enumerated(EnumType.STRING)
    private Sexo pesSexo;

    private String pesMae;
    private String pesPai;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PessoaEndereco> enderecos = new ArrayList<>();

    public Pessoa(DadosPessoa dadosPessoa) {
        this.pesNome = dadosPessoa.nome();
        this.pesDataNascimento = dadosPessoa.dataNascimento();
        this.pesSexo = dadosPessoa.sexo();
        this.pesMae = dadosPessoa.mae();
        this.pesPai = dadosPessoa.pai();
    }
}
