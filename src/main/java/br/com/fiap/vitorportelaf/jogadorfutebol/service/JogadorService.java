package br.com.fiap.vitorportelaf.jogadorfutebol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.vitorportelaf.jogadorfutebol.model.Jogador;
import br.com.fiap.vitorportelaf.jogadorfutebol.repository.JogadorRepository;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository repository;

    public Jogador createOrUpdate(Jogador jogador) {
        return repository.save(jogador);
    }

    public Optional<Jogador> findById(Long id) {
        return repository.findById(id);
    }

    public List<Jogador> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
