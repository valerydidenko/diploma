package diploma.services.impl;

import diploma.entities.User;
import diploma.repositories.UserRepository;
import diploma.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {

	@Autowired
	private UserRepository repository;

}