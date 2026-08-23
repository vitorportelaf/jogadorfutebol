package br.com.fiap.vitorportelaf.jogadorfutebol.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.vitorportelaf.jogadorfutebol.dto.JogadorCreateRequest;
import br.com.fiap.vitorportelaf.jogadorfutebol.dto.JogadorResponse;
import br.com.fiap.vitorportelaf.jogadorfutebol.dto.JogadorUpdateRequest;
import br.com.fiap.vitorportelaf.jogadorfutebol.model.Jogador;

@Component
public class JogadorMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public Jogador toModel(JogadorCreateRequest dto) {
        return modelMapper.map(dto, Jogador.class);
    }

    public Jogador toModel(Long id, JogadorUpdateRequest dto) {
        Jogador jogador = modelMapper.map(dto, Jogador.class);
        jogador.setId(id);
        return jogador;
    }

    public JogadorResponse toDto(Jogador entity) {
        return modelMapper.map(entity, JogadorResponse.class);
    }
}
