package traininglab.personalrecord.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.RecordDTO;

import java.util.List;

@RestController
public interface RecordRestApi {

	@GetMapping(path = "/exercise", produces = "application/json")
	List<ExerciseDTO> getExeciseList();

	@PostMapping(path = "/records", produces = "application/json", consumes = "application/json")
	RecordDTO createRecord(CreateRecordRequestDTO request);
}
