package br.com.fiap.vitorportelaf.jogadorfutebol.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "times")
public class Time {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome_time", length = 100, nullable = false)
    private String nome;

    @Column(name = "cidade", length = 80, nullable = false)
    private String cidade;

    @Column(name = "estado", length = 2, nullable = false)
    private String estado;

    @Column(name = "ano_fundacao", nullable = false)
    private Integer anoFundacao;

    @Column(name = "estadio", length = 100, nullable = true)
    private String estadio;
}
