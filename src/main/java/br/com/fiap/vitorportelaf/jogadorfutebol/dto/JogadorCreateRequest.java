package br.com.fiap.vitorportelaf.jogadorfutebol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JogadorCreateRequest {

    @NotNull(message = "O id do jogador é obrigatório")
    private Long id;

    @NotBlank(message = "O nome do jogador é obrigatório")
    @Size(max = 100, message = "O nome do jogador deve ter no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "A posição do jogador é obrigatória")
    @Size(max = 50, message = "A posição deve ter no máximo 50 caracteres")
    private String posicao;

    @NotNull(message = "O número da camisa é obrigatório")
    @Positive(message = "O número da camisa deve ser positivo")
    private Integer numeroCamisa;

    @NotBlank(message = "A nacionalidade é obrigatória")
    @Size(max = 50, message = "A nacionalidade deve ter no máximo 50 caracteres")
    private String nacionalidade;

    @Size(max = 50, message = "O apelido deve ter no máximo 50 caracteres")
    private String apelido;
}
