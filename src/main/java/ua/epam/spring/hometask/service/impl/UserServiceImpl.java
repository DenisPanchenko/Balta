package ua.epam.spring.hometask.service.impl;

import org.springframework.stereotype.Service;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepository;
import ua.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return getAll().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findFirst().get();
    }

    @Override
    public User save(@Nonnull User object) {
        return userRepository.save(object);
    }

    @Override
    public void remove(@Nonnull User object) {
        userRepository.delete(object);
    }

    @Override
    public User getById(@Nonnull Long id) {
        return userRepository.findById(id);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return userRepository.findAll();
    }
}
