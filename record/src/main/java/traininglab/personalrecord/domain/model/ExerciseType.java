package traininglab.personalrecord.domain.model;

import lombok.Getter;

@Getter
public enum ExerciseType {

	WEIGHTLIFTING(0, "Weightlifting"),
	GYMNASTIC(1, "Gymnastic");

	private Integer id;
	private String label;

	private ExerciseType(Integer id, String label) {
		this.id = id;
		this.label = label;
	}


}
