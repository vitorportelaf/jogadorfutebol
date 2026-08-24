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
import br.com.fiap.vitorportelaf.jogadorfutebol.service.TimeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/times")
public class TimeController {

    @Autowired
    private TimeService service;

    @Autowired
    private TimeMapper mapper;

    @PostMapping
    public ResponseEntity<TimeResponse> create(@Valid @RequestBody TimeCreateRequest dtoRequest) {
        Time time = service.createOrUpdate(mapper.toModel(dtoRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(time));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeResponse> findById(@PathVariable Long id) {
        return service
                .findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<TimeResponse>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeResponse> update(@PathVariable Long id,
            @RequestBody TimeUpdateRequest dtoRequest) {

        if (service.findById(id).isPresent()) {
            Time timeAlterado = service.createOrUpdate(mapper.toModel(id, dtoRequest));
            return ResponseEntity.ok(mapper.toDto(timeAlterado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (service.findById(id).isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
