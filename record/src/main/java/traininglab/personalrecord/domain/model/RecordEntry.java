package traininglab.personalrecord.domain.model;

import lombok.*;
import traininglab.personalrecord.domain.model.data.CreateRecordData;
import traininglab.user.domain.model.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter(AccessLevel.PRIVATE)
@Entity
public class RecordEntry {

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
	@Column(name = "`value`")
	private BigDecimal value;
	@Column
	private BigDecimal percentage;

	@Column
	private Instant creationTimestamp;
	@Column
	private Instant lastModificationTimestamp;

	private RecordEntry() {}

	public static RecordEntry buildRecordFromData(CreateRecordData data) {

		RecordEntry entry = new RecordEntry();

		entry.setCreationTimestamp(Instant.now());

		entry.updateRecordEntryFromData(data);

		return entry;
	}

	public void updateRecordEntryFromData(CreateRecordData data) {

		this.setRecordDate(data.getRecordDate());
		this.setExercise(data.getExecise());
		this.setUser(data.getUser());
		this.setValue(data.getValue());
		this.setPercentage(data.getPercentage());
		this.setLastModificationTimestamp(Instant.now());
	}
}
