package br.com.fiap.vitorportelaf.jogadorfutebol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TimeCreateRequest {

    @NotNull(message = "O id do time é obrigatório")
    private Long id;

    @NotBlank(message = "O nome do time é obrigatório")
    @Size(max = 100, message = "O nome do time deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "A cidade é obrigatória")
    @Size(max = 80, message = "A cidade deve ter no máximo 80 caracteres")
    private String cidade;

    @NotBlank(message = "O estado é obrigatório")
    @Size(min = 2, max = 2, message = "O estado deve ter exatamente 2 caracteres")
    private String estado;

    @NotNull(message = "O ano de fundação é obrigatório")
    @Positive(message = "O ano de fundação deve ser positivo")
    private Integer anoFundacao;

    @Size(max = 100, message = "O estádio deve ter no máximo 100 caracteres")
    private String estadio;
}
