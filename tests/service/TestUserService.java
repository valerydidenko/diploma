package service;

import diploma.config.AppConfig;
import diploma.entity.User;
import diploma.enums.RoleEnum;
import diploma.repository.UserRepository;
import diploma.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@Transactional
public class TestUserService {

    @Autowired
    private UserServiceImpl service;

    @Autowired
    private UserRepository repository;
    private User user;

    @Before
    public void initEntities () {
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
    public void testGetById () {
        assertEquals(user, service.getById(user.getId()));
    }

    @Test
    public void testSaveUser () {
        User user = new User();
        user.setLogin("new_test_login");
        user.setPassword("new_test_pass");
        user.setUkrName("new_test_ukr_name");
        user.setUkrSurname("new_test_ukr_surname");
        user.setEngName("new_test_eng_name");
        user.setEngSurname("new_test_eng_surname");
        user.setRole(RoleEnum.USER);
        service.save(user);

        assertNotNull(repository.getOne(user.getId()));
    }

    @Test
    public void testUpdateUser () {
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

    @Test(expected = JpaObjectRetrievalFailureException.class)
    public void testDeleteUser () {
        service.delete(user);
        repository.getOne(user.getId());
    }
}