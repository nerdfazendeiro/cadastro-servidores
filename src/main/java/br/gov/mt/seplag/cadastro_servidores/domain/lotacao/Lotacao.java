package br.gov.mt.seplag.cadastro_servidores.domain.lotacao;

import jakarta.persistence.*;
import java.time.LocalDate;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.Pessoa;
import br.gov.mt.seplag.cadastro_servidores.domain.unidade.Unidade;
import lombok.*;

@Entity
@Table(name = "lotacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lotId;

    private LocalDate lotDataLotacao;
    private LocalDate lotDataRemocao;
    private String lotPortaria;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "unid_id")
    private Unidade unidade;

}
