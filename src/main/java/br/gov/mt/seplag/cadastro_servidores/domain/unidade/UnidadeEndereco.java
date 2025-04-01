package br.gov.mt.seplag.cadastro_servidores.domain.unidade;

import jakarta.persistence.*;
import br.gov.mt.seplag.cadastro_servidores.domain.endereco.Endereco;
import lombok.*;

@Entity
@Table(name = "unidade_endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UnidadeEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unid_id")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "end_id")
    private Endereco endereco;
}
