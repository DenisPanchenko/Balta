package ua.epam.spring.hometask.repository;

import ua.epam.spring.hometask.domain.User;

import java.util.Collection;

public interface UserRepository {

    public Collection<User> findAll();

    public User findById(Long id);

    public User save(User user);

    public void delete(User user);

}