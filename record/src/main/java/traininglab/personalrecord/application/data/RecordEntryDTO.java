package traininglab.personalrecord.application.data;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RecordEntryDTO {
	private Long id;
	private ExerciseDTO exercise;
	private LocalDate recordDate;
	private BigDecimal value;
	private BigDecimal percentage;
}
