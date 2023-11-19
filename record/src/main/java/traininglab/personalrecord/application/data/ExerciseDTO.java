package traininglab.personalrecord.application.data;

import lombok.Data;

@Data
public class ExerciseDTO {

	private String id;
	private String name;
	private ExerciseTypeDTO type;

	@Data
	public static class ExerciseTypeDTO {
		private Integer id;
		private String label;
	}
}


