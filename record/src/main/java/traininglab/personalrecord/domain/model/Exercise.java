package traininglab.personalrecord.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Exercise {

	@Id
	private String id;
	private String name;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type")
	private ExerciseType type;
}
