package traininglab.controller.impl;

import org.springframework.http.ResponseEntity;
import traininglab.calculation.service.PercentageCalculationService;
import traininglab.controller.WelcomeController;
import traininglab.controller.utils.WeightTableHTMLBuilder;

public class WelcomeControllerImpl implements WelcomeController {

	private PercentageCalculationService percentageCalculationService;
	private WeightTableHTMLBuilder weightTableHTMLBuilder;

	public WelcomeControllerImpl(PercentageCalculationService percentageCalculationService, WeightTableHTMLBuilder weightTableHTMLBuilder) {
		this.percentageCalculationService = percentageCalculationService;
		this.weightTableHTMLBuilder = weightTableHTMLBuilder;
	}

	@Override
	public String welcomeAsHTML() {
		return "<html>\n" + "<header><title>Welcome</title></header>\n" +
				"<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
	}

	@Override
	public ResponseEntity healthCheck() {
		return ResponseEntity.ok().build();
	}
}
