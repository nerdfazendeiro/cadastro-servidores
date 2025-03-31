package br.gov.mt.seplag.cadastro_servidores.servidor;

import jakarta.persistence.*;
import br.gov.mt.seplag.cadastro_servidores.pessoa.Pessoa;
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

    @OneToOne
    @MapsId
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;

    public ServidorEfetivo(DadosCadastroServidor dados) {
        this.pessoa = new Pessoa(dados.pessoa());
        this.seMatricula = dados.matricula();
    }
}