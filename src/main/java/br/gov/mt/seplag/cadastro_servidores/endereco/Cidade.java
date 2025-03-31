package br.gov.mt.seplag.cadastro_servidores.endereco;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cidId;

    private String cidNome;
    private String cidUf;

    public Cidade(DadosCidade dadosCidade) {
        this.cidNome = dadosCidade.nome();
        this.cidUf = dadosCidade.uf();
    }
}

