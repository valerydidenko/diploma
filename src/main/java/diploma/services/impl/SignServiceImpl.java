package diploma.services.impl;

import diploma.entities.Sign;
import diploma.repositories.SignRepository;
import diploma.services.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl extends CrudServiceImpl<Sign> implements SignService {

	@Autowired
	private SignRepository repository;

}