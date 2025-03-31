package br.gov.mt.seplag.cadastro_servidores.endereco;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endId;

    private String endTipoLogradouro;
    private String endLogradouro;
    private int endNumero;
    private String endBairro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid_id")
    private Cidade cidade;

    public Endereco(DadosEndereco dadosEndereco) {
        this.endTipoLogradouro = dadosEndereco.tipo_logradouro();
        this.endLogradouro = dadosEndereco.logradouro();
        this.endNumero = dadosEndereco.numero();
        this.endBairro = dadosEndereco.bairro();
    }
}
