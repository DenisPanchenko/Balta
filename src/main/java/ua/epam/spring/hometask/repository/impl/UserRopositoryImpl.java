package ua.epam.spring.hometask.repository.impl;

import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRopositoryImpl implements UserRepository {

    private static Map<Long, User> storage = new HashMap<Long, User>();

    @Override
    public Collection<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return storage.get(id);
    }

    @Override
    // TODO What's the point to return User on save operation?
    public User save(User user) {
        storage.put(user.getId(), user);
        return user;
    }

    @Override
    public void delete(User user) {
        storage.remove(user.getId());
    }
}
