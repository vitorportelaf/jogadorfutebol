package br.com.fiap.vitorportelaf.jogadorfutebol.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeResponse {

    private Long id;
    private String nome;
    private String cidade;
    private String estado;
    private Integer anoFundacao;
    private String estadio;
}
