package diploma.service.impl;

import diploma.entity.Grade;
import diploma.entity.embeddableIds.GradePrimaryKey;
import diploma.repository.GradeRepository;
import diploma.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade getById(GradePrimaryKey id) {
        return gradeRepository.findOne(id);
    }

    @Override
    public void save(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void delete(Grade grade) {
        gradeRepository.delete(grade);
    }

    @Override
    public void deleteById(GradePrimaryKey id) {
        gradeRepository.delete(id);
    }
}