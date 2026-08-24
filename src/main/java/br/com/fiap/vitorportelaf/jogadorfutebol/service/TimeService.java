package br.com.fiap.vitorportelaf.jogadorfutebol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.vitorportelaf.jogadorfutebol.model.Time;
import br.com.fiap.vitorportelaf.jogadorfutebol.repository.TimeRepository;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public Time createOrUpdate(Time time) {
        return repository.save(time);
    }

    public Optional<Time> findById(Long id) {
        return repository.findById(id);
    }

    public List<Time> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
