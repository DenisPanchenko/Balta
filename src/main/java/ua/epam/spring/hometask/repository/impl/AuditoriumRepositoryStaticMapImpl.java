package ua.epam.spring.hometask.repository.impl;

import org.springframework.stereotype.Repository;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.repository.AuditoriumRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AuditoriumRepositoryStaticMapImpl implements AuditoriumRepository {

    private Map<String, Auditorium> storage = new HashMap<>();

    public void setStorage(Map<String, Auditorium> storage) {
        this.storage = storage;
    }

    @Override
    public Collection<Auditorium> findAll() {
        return storage.values();
    }

    @Override
    public Auditorium findByName(String name) {
        return storage.values().stream().filter(auditorium -> auditorium.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        return auditorium;
    }

    @Override
    public void delete(Auditorium auditorium) {
        storage.remove(auditorium);
    }
}
