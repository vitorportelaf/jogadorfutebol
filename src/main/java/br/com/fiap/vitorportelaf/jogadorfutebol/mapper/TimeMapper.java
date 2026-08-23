package br.com.fiap.vitorportelaf.jogadorfutebol.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.vitorportelaf.jogadorfutebol.dto.TimeCreateRequest;
import br.com.fiap.vitorportelaf.jogadorfutebol.dto.TimeResponse;
import br.com.fiap.vitorportelaf.jogadorfutebol.dto.TimeUpdateRequest;
import br.com.fiap.vitorportelaf.jogadorfutebol.model.Time;

@Component
public class TimeMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public Time toModel(TimeCreateRequest dto) {
        return modelMapper.map(dto, Time.class);
    }

    public Time toModel(Long id, TimeUpdateRequest dto) {
        Time time = modelMapper.map(dto, Time.class);
        time.setId(id);
        return time;
    }

    public TimeResponse toDto(Time entity) {
        return modelMapper.map(entity, TimeResponse.class);
    }
}
