package br.gov.mt.seplag.cadastro_servidores.domain.servidor;

import jakarta.persistence.*;
import br.gov.mt.seplag.cadastro_servidores.domain.pessoa.Pessoa;
import lombok.*;

@Entity
@Table(name = "servidor_efetivo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServidorEfetivo {

    @Id
    private Long pesId;

    private String seMatricula;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    public ServidorEfetivo(DadosCadastroServidor dados, Pessoa pessoa) {
        this.pessoa = pessoa;
        this.seMatricula = dados.matricula();
    }
}