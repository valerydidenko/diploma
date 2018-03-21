package diploma.repository;

import diploma.entity.Grade;
import diploma.entity.embeddableIds.GradePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, GradePrimaryKey> {
}