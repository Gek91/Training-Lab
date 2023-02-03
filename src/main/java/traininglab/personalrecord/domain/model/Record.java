package traininglab.personalrecord.domain.model;

import lombok.Data;
import traininglab.user.domain.model.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "exercise_id")
	private Exercise exercise;
	private LocalDate recordDate;
	@Column(name = "\"value\"")
	private BigDecimal value;
}
