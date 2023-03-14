package percentage.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import percentage.calculation.CalculationConfiguration;
import percentage.controller.impl.HTMLControllerImpl;
import percentage.calculation.service.PercentageCalculationService;
import percentage.controller.utils.WeightTableHTMLBuilder;

@Configuration
@Import({CalculationConfiguration.class})
public class ControllerConfiguration {

	@Bean
	public HTMLController htmlController(PercentageCalculationService personalRecordApplicationService) {
		return new HTMLControllerImpl(personalRecordApplicationService, weightTableHTMLBuilder());
	}

	@Bean
	public WeightTableHTMLBuilder weightTableHTMLBuilder() {
		return new WeightTableHTMLBuilder();
	}
}
