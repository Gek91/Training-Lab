package traininglab.controller;

import org.springframework.web.bind.annotation.*;
import traininglab.personalrecord.application.data.CreateRecordRequestDTO;
import traininglab.personalrecord.application.data.ExerciseDTO;
import traininglab.personalrecord.application.data.RecordEntryDTO;

import java.util.List;

@RestController
public interface RecordRestController {

	@GetMapping(path = "/exercises", produces = "application/json")
	List<ExerciseDTO> getExeciseList();

	@GetMapping(path = "/records", produces = "application/json")
	List<RecordEntryDTO> getUserRecords(@RequestParam(name = "exerciseId", required = false) String exerciseId);

	@PostMapping(path = "/records", produces = "application/json", consumes = "application/json")
	RecordEntryDTO createRecord(@RequestBody CreateRecordRequestDTO request);

	@PutMapping(path = "/records/{id}", produces = "application/json")
	RecordEntryDTO updateRecord(@PathVariable("id") Long id, @RequestBody CreateRecordRequestDTO request);
}
