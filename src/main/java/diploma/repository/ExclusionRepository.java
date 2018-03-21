package diploma.repository;

import diploma.entity.Exclusion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExclusionRepository extends JpaRepository<Exclusion, Long> {
}