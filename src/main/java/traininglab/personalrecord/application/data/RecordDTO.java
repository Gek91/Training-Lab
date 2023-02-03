package traininglab.personalrecord.application.data;

import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;

@Value
public class RecordDTO {
	private Long id;
	private ExerciseDTO exercise;
	private LocalDate recordDate;
	private BigDecimal value;
}
