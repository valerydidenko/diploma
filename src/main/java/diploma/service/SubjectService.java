package diploma.service;

import diploma.entity.Specialty;
import diploma.entity.Subject;

import java.util.List;

public interface SubjectService extends CrudService<Subject> {

	List<Subject> getAllBySpecialty(Specialty specialty);

}