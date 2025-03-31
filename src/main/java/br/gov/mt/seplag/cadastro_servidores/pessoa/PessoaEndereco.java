package br.gov.mt.seplag.cadastro_servidores.pessoa;

import jakarta.persistence.*;
import br.gov.mt.seplag.cadastro_servidores.endereco.Endereco;
import lombok.*;

@Entity
@Table(name = "pessoa_endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id")
    private Endereco endereco;
}
