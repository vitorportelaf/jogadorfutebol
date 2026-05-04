package br.com.fiap.vitorportelaf.jogadorfutebol.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jogadores")
public class Jogador {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome_jogador", length = 100, nullable = false)
    private String nome;

    @Column(name = "posicao", length = 50, nullable = false)
    private String posicao;

    @Column(name = "numero_camisa", nullable = false)
    private Integer numeroCamisa;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    @Column(name = "apelido", length = 50, nullable = true)
    private String apelido;
}
