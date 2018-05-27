package diploma.repositories;

import diploma.entities.abstractions.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}