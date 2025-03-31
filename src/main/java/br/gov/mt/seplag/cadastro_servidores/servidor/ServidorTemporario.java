package br.gov.mt.seplag.cadastro_servidores.servidor;

import jakarta.persistence.*;
import java.time.LocalDate;
import br.gov.mt.seplag.cadastro_servidores.pessoa.Pessoa;
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

    @OneToOne
    @MapsId
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    public ServidorTemporario(DadosCadastroServidor dados) {
        this.pessoa = new Pessoa(dados.pessoa());
        this.stDataAdmissao = dados.dataAdmissao();
        this.stDataDemissao = dados.dataDemissao();
    }
}
