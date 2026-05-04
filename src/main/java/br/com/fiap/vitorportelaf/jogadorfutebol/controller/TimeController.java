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

import br.com.fiap.vitorportelaf.jogadorfutebol.model.Time;
import br.com.fiap.vitorportelaf.jogadorfutebol.repository.TimeRepository;

@RestController
@RequestMapping("api/${api.version}/times")
public class TimeController {

    @Autowired
    private TimeRepository repository;

    @PostMapping
    public ResponseEntity<Time> create(@RequestBody Time time) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(time));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> findById(@PathVariable Long id) {
        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Time>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> update(@PathVariable Long id,
                                       @RequestBody Time time) {

        Optional<Time> optTime = repository.findById(id);

        if (optTime.isPresent()) {
            time.setId(id);
            Time timeAlterado = repository.save(time);
            return ResponseEntity.ok(timeAlterado);
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