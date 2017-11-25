package ua.epam.spring.hometask.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.repository.UserRepository;
import ua.epam.spring.hometask.repository.impl.UserRopositoryImpl;
import ua.epam.spring.hometask.service.impl.UserServiceImpl;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest  {

    private static UserService userService;
    private UserRepository repository;

    @BeforeClass
    public static void beforeAll() {
        userService = new UserServiceImpl();
    }

    @Before
    public void beforeEach() {
        repository = new UserRopositoryImpl();
    }

    @Test
    public void findAllTest() {
        // Given
        User user0 = new User();
        user0.setId(0L);
        User user1 = new User();
        user1.setId(1L);
        User user2 = new User();
        user2.setId(2L);
        repository.save(user0);
        repository.save(user1);
        repository.save(user2);

        // When
        User[] result = (User[])userService.getAll().toArray();

        // Then
        assertEquals(result[0], user0);
        assertEquals(result[1], user1);
        assertEquals(result[2], user2);
    }

}
