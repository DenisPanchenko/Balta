package ua.epam.spring.hometask.repository.impl;

import org.springframework.stereotype.Repository;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryStaticMapImpl implements UserRepository {

    private Map<Long, User> storage = new HashMap<Long, User>();

    private UserRepositoryStaticMapImpl(Map<Long, User> storage) {
        this.storage = storage;
    }

    @Override
    public Collection<User> findAll() {
        return storage.values();
    }

    @Override
    public User findById(Long id) {
        return storage.get(id);
    }

    // TODO What's the point to return User on save operation?
    @Override
    public User save(User user) {
        storage.put(user.getId(), user);
        return user;
    }

    @Override
    public void delete(User user) {
        storage.remove(user.getId());
    }
}
