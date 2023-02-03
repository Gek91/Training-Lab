package traininglab.user.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "\"user\"")
public class User {
	@Id
	private String id;
	private String firstname;
	private String lastname;
}
