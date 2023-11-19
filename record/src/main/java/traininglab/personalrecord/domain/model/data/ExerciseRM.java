package traininglab.personalrecord.domain.model.data;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import traininglab.personalrecord.domain.model.RecordEntry;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter(AccessLevel.PRIVATE)
public class ExerciseRM {

	@OneToOne
	@JoinColumn(name = "record_entry_id")
	private RecordEntry recordEntry;
	@Column(name = "`value`")
	private BigDecimal value;


	private ExerciseRM() {}


}
