package diploma.service.impl;

import diploma.entity.Sign;
import diploma.repository.SignRepository;
import diploma.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl extends CrudServiceImpl<Sign> implements SignService {

	@Autowired
	private SignRepository repository;

}