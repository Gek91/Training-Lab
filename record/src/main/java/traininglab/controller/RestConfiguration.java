package traininglab.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import traininglab.calculation.service.PercentageCalculationService;
import traininglab.controller.impl.HTMLControllerImpl;
import traininglab.controller.utils.WeightTableHTMLBuilder;
import traininglab.core.service.MapperService;
import traininglab.personalrecord.PersonalRecordConfiguration;
import traininglab.personalrecord.application.PersonalRecordApplicationService;
import traininglab.controller.impl.RecordRestControllerImpl;
import traininglab.user.application.UserService;


@Configuration
@Import(PersonalRecordConfiguration.class)
public class RestConfiguration {

	@Bean
	public RecordRestControllerImpl recordRestApiImp(PersonalRecordApplicationService personalRecordApplicationService, UserService userService) {
		return new RecordRestControllerImpl(personalRecordApplicationService, userService);
	}

	@Bean
	public HTMLController htmlController(PercentageCalculationService personalRecordApplicationService) {
		return new HTMLControllerImpl(personalRecordApplicationService, weightTableHTMLBuilder());
	}

	@Bean
	public WeightTableHTMLBuilder weightTableHTMLBuilder() {
		return new WeightTableHTMLBuilder();
	}

}
