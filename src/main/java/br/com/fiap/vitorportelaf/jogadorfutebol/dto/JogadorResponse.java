package br.com.fiap.vitorportelaf.jogadorfutebol.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JogadorResponse {

    private Long id;
    private String nome;
    private String posicao;
    private Integer numeroCamisa;
    private String nacionalidade;
    private String apelido;
}
