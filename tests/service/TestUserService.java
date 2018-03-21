package service;

import diploma.entity.User;
import diploma.enums.RoleEnum;
import diploma.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static diploma.utils.EntitiesFactory.generateUser;
import static org.junit.Assert.*;

public class TestUserService extends AbstractServiceTest {

    @Autowired
    private UserServiceImpl userService;

    private User user;

    @Before
    public void initEntities() {
        user = generateUser();
        userRepository.save(user);
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
        userService.save(user);

        User updated = userRepository.findOne(user.getId());
        assertNotNull(updated);
        assertEquals(user, updated);
    }

    @Test
    public void testDeleteEntity() {
        userService.delete(user);
        assertNull(userRepository.findOne(user.getId()));
    }
}