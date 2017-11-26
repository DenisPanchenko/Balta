package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.Auditorium;

import java.util.Collection;

public interface AuditoriumRepository {
    public Collection<Auditorium> findAll();

    public Auditorium findByName(String name);

    public Auditorium save(Auditorium user);

    public void delete(Auditorium user);
}
