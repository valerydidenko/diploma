package diploma.service.impl;

import diploma.entity.User;
import diploma.repository.UserRepository;
import diploma.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements BaseService<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public User getById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void deleteById(long id) {
        repository.delete(id);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }
}