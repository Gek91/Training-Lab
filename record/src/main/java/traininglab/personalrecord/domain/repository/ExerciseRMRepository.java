package traininglab.personalrecord.domain.repository;

import traininglab.personalrecord.domain.model.data.ExerciseRM;

import java.util.List;

public interface ExerciseRMRepository {

	ExerciseRM getExerciseRM(String exerciseId);

	List<ExerciseRM> getExercisesRM();
}
