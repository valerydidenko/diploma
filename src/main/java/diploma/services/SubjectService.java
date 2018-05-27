package diploma.services;

import diploma.entities.Specialty;
import diploma.entities.Subject;

import java.util.List;

public interface SubjectService extends CrudService<Subject> {

	List<Subject> getAllBySpecialty(Specialty specialty);

}