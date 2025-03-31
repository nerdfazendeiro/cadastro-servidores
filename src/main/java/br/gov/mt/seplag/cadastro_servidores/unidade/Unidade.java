package br.gov.mt.seplag.cadastro_servidores.unidade;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "unidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unidId;

    private String unidNome;
    private String unidSigla;
}