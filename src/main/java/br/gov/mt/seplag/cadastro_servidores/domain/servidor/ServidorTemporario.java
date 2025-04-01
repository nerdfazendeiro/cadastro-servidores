package br.gov.mt.seplag.cadastro_servidores.domain.servidor;

import jakarta.persistence.*;
import java.time.LocalDate;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.Pessoa;
import lombok.*;

@Entity
@Table(name = "servidor_temporario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServidorTemporario {

    @Id
    private Long pesId;

    private LocalDate stDataAdmissao;
    private LocalDate stDataDemissao;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    public ServidorTemporario(DadosCadastroServidor dados, Pessoa pessoa) {
        this.pessoa = pessoa;
        this.stDataAdmissao = dados.dataAdmissao();
        this.stDataDemissao = dados.dataDemissao();
    }
}
