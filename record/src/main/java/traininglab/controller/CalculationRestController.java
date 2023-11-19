package traininglab.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import traininglab.controller.data.GetPercentageValuesFrom1RMValueResultDTO;

import java.math.BigDecimal;

@RestController
public interface CalculationRestController {

	@GetMapping(path= "/calculations/standard-percentage-values/{rm}", produces = "application/json")
	GetPercentageValuesFrom1RMValueResultDTO getPercentageValuesFrom1RMValue(@PathVariable("rm") String rm);

	@GetMapping(path= "/calculations/value-from-percentage", produces = "application/json")
	BigDecimal getValueFromPercentage(@RequestParam String rm, @RequestParam String percentage);

	@GetMapping(path= "/calculations/percentage-from-value", produces = "application/json")
	BigDecimal getPercentageFromValue(@RequestParam String rm, @RequestParam String value);
}
