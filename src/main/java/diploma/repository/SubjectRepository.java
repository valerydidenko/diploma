package diploma.repository;

import diploma.entity.Specialty;
import diploma.entity.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends BaseRepository<Subject> {

    List<Subject> findAllBySpecialty(Specialty specialty);

}