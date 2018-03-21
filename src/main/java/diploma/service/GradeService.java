package diploma.service;

import diploma.entity.Grade;
import diploma.entity.embeddableIds.GradePrimaryKey;

public interface GradeService {

    Grade getById(GradePrimaryKey id);

    void save(Grade object);

    void delete(Grade object);

    void deleteById(GradePrimaryKey id);
}
