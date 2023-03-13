package traininglab.personalrecord.persistence;

import traininglab.personalrecord.domain.model.Exercise;
import traininglab.personalrecord.domain.repository.ExerciseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ExerciseJPARepository implements ExerciseRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Exercise> getExerciseList() {
		return this.entityManager.createQuery("FROM Exercise", Exercise.class).getResultList();
	}
}
