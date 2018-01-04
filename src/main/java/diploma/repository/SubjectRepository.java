package diploma.repository;

import diploma.entity.Specialty;
import diploma.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findAllBySpecialty(Specialty specialty);

}