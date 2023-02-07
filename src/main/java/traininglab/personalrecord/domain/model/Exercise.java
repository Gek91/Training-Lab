package traininglab.personalrecord.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Exercise {

	@Id
	private String id;
	private String name;
}
