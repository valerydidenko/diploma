package diploma.service.impl;

import diploma.entity.User;
import diploma.repository.UserRepository;
import diploma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {

    @Autowired
    private UserRepository repository;

}