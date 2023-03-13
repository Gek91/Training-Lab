package traininglab.personalrecord.domain.repository;

import traininglab.personalrecord.domain.model.Exercise;

import java.util.List;

public interface ExerciseRepository {

	List<Exercise> getExerciseList();
}
