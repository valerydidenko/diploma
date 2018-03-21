package service;

import diploma.entity.User;
import diploma.enums.RoleEnum;
import diploma.repository.UserRepository;
import diploma.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TestUserService extends AbstractServiceTest {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private UserRepository repository;

    private User user;

    @Before
    public void initEntities() {
        user = new User();
        user.setLogin("test_login");
        user.setPassword("test_pass");
        user.setUkrName("test_ukr_name");
        user.setUkrSurname("test_ukr_surname");
        user.setEngName("test_eng_name");
        user.setEngSurname("test_eng_surname");
        user.setRole(RoleEnum.USER);
        repository.save(user);
    }

    @Test
    public void testUpdateEntity() {
        entityManager.detach(user);

        user.setLogin("upd_test_login");
        user.setPassword("upd_test_pass");
        user.setUkrName("upd_test_ukr_name");
        user.setUkrSurname("upd_test_ukr_surname");
        user.setEngName("upd_test_eng_name");
        user.setEngSurname("upd_test_eng_surname");
        user.setRole(RoleEnum.ADMIN);
        service.save(user);

        User updated = repository.findOne(user.getId());
        assertNotNull(updated);
        assertEquals(user, updated);
    }

    @Test
    public void testDeleteEntity() {
        service.delete(user);
        assertNull(repository.findOne(user.getId()));
    }
}