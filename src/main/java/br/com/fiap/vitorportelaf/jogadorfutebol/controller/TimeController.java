package br.com.fiap.vitorportelaf.jogadorfutebol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.vitorportelaf.jogadorfutebol.dto.TimeCreateRequest;
import br.com.fiap.vitorportelaf.jogadorfutebol.dto.TimeResponse;
import br.com.fiap.vitorportelaf.jogadorfutebol.dto.TimeUpdateRequest;
import br.com.fiap.vitorportelaf.jogadorfutebol.mapper.TimeMapper;
import br.com.fiap.vitorportelaf.jogadorfutebol.model.Time;
import br.com.fiap.vitorportelaf.jogadorfutebol.repository.TimeRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/times")
public class TimeController {

    @Autowired
    private TimeRepository repository;

    @Autowired
    private TimeMapper mapper;

    @PostMapping
    public ResponseEntity<TimeResponse> create(@Valid @RequestBody TimeCreateRequest dtoRequest) {
        Time time = repository.save(mapper.toModel(dtoRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(time));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeResponse> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TimeResponse>> findAll() {
        return ResponseEntity.ok(
                repository.findAll().stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeResponse> update(@PathVariable Long id,
                                               @RequestBody TimeUpdateRequest dtoRequest) {

        if (repository.existsById(id)) {
            Time timeAlterado = repository.save(mapper.toModel(id, dtoRequest));
            return ResponseEntity.ok(mapper.toDto(timeAlterado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
