package traininglab.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import traininglab.rest.data.CreateRecordRequestDTO;
import traininglab.rest.data.ExerciseDTO;
import traininglab.rest.data.RecordEntryDTO;

import java.util.List;

@RestController
public interface RecordRestApi {

	@GetMapping(path = "/exercise", produces = "application/json")
	List<ExerciseDTO> getExeciseList();

	@PostMapping(path = "/records", produces = "application/json", consumes = "application/json")
	RecordEntryDTO createRecord(CreateRecordRequestDTO request);
}
