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

import br.com.fiap.vitorportelaf.jogadorfutebol.dto.JogadorCreateRequest;
import br.com.fiap.vitorportelaf.jogadorfutebol.dto.JogadorResponse;
import br.com.fiap.vitorportelaf.jogadorfutebol.dto.JogadorUpdateRequest;
import br.com.fiap.vitorportelaf.jogadorfutebol.mapper.JogadorMapper;
import br.com.fiap.vitorportelaf.jogadorfutebol.model.Jogador;
import br.com.fiap.vitorportelaf.jogadorfutebol.service.JogadorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/${api.version}/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService service;

    @Autowired
    private JogadorMapper mapper;

    @PostMapping
    public ResponseEntity<JogadorResponse> create(@Valid @RequestBody JogadorCreateRequest dtoRequest) {
        Jogador jogador = service.createOrUpdate(mapper.toModel(dtoRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(jogador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorResponse> findById(@PathVariable Long id) {
        return service
                .findById(id)
                .map(mapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<JogadorResponse>> findAll() {
        return ResponseEntity.ok(
                service.findAll().stream()
                        .map(mapper::toDto)
                        .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogadorResponse> update(@PathVariable Long id,
            @RequestBody JogadorUpdateRequest dtoRequest) {

        if (service.findById(id).isPresent()) {
            Jogador jogadorAlterado = service.createOrUpdate(mapper.toModel(id, dtoRequest));
            return ResponseEntity.ok(mapper.toDto(jogadorAlterado));
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
