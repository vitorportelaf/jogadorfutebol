package br.com.fiap.vitorportelaf.jogadorfutebol.controller;

import java.util.List;
import java.util.Optional;

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
import br.com.fiap.vitorportelaf.jogadorfutebol.model.Jogador;
import br.com.fiap.vitorportelaf.jogadorfutebol.repository.JogadorRepository;

@RestController
@RequestMapping("api/${api.version}/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository repository;

    @PostMapping
    public ResponseEntity<Jogador> create(@RequestBody Jogador jogador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(jogador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> update(@PathVariable Long id,
                                          @RequestBody Jogador jogador) {

        Optional<Jogador> optJogador = repository.findById(id);

        if (optJogador.isPresent()) {
            jogador.setId(id);
            Jogador jogadorAlterado = repository.save(jogador);
            return ResponseEntity.ok(jogadorAlterado);
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
