package diploma.repositories;

import diploma.entities.Specialty;
import diploma.entities.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends BaseRepository<Subject> {

	List<Subject> findAllBySpecialty(Specialty specialty);

}