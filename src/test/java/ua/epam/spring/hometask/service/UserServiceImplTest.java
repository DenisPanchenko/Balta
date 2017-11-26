package ua.epam.spring.hometask.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.epam.spring.hometask.domain.User;

import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:user-service-test.xml")
public class UserServiceImplTest  {

    @Autowired
    private UserService userService;

    @Test
    public void getAllTest() {
        // When
        Collection<User> result = userService.getAll();

        // Then
        assertEquals(2, result.size());
    }


    @Test
    public void getByIdTest() {
        // Given
        Long id = 1L;

        // When
        User actualResult = userService.getById(id);

        // Then
        assertEquals(id, actualResult.getId());
    }

    @Test
    public void getByIdTestExeption() {
        // Given
        Long id = 100L;

        // When
        User actualResult = userService.getById(id);

        // Then
        assertEquals(null, actualResult);
    }
    
    @Test
    public void getByEmailTest() {
        // Given
        String email = "user0@gmail.com";

        // When
        User actualResult = userService.getUserByEmail(email);

        // Then
        assertEquals(0L, actualResult.getId().longValue());
    }

    @Test(expected = NoSuchElementException.class)
    public void getByEmailTestException() {
        // Given
        String email = "ABSENT@EMAIL.COM";

        // Then
        userService.getUserByEmail(email);
    }

    @Test
    public void saveTest() {
        // Given
        User newUser = new User();
        newUser.setId(2L);
        newUser.setEmail("user2");

        // When
        User addedUser = userService.save(newUser);

        // Then
        assertEquals(addedUser, newUser);

        // Rollback
        userService.remove(newUser);
    }

    @Test
    public void deleteTest() {
        // Given
        User user0 = new User();
        user0.setId(0L);
        user0.setEmail("user0@gmail.com");

        // When
        userService.remove(user0);

        // Then
        assertEquals(1, userService.getAll().size());

        // Rollback
        userService.save(user0);
    }
}
