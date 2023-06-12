package percentage.controller.impl;

import org.springframework.http.ResponseEntity;
import percentage.calculation.service.PercentageCalculationService;
import percentage.controller.HTMLController;
import percentage.controller.utils.WeightTableHTMLBuilder;

import java.math.BigDecimal;
import java.util.Map;

public class HTMLControllerImpl implements HTMLController {

	private PercentageCalculationService percentageCalculationService;
	private WeightTableHTMLBuilder weightTableHTMLBuilder;

	public HTMLControllerImpl(PercentageCalculationService percentageCalculationService, WeightTableHTMLBuilder weightTableHTMLBuilder) {
		this.percentageCalculationService = percentageCalculationService;
		this.weightTableHTMLBuilder = weightTableHTMLBuilder;
	}

	@Override
	public String welcomeAsHTML() {
		return "<html>\n" + "<header><title>Welcome</title></header>\n" +
				"<body>\n" + "Hello world\n" + "</body>\n" + "</html>";
	}

	@Override
	public String getWeightTableGiven1RMValue(String rm) {

		BigDecimal rmValue = new BigDecimal(rm);

		Map<BigDecimal, BigDecimal> percentagesvValueMap = percentageCalculationService.calculateStandardPercentagesFrom1RM(rmValue);

		return weightTableHTMLBuilder.buildHTML(percentagesvValueMap, rmValue);
	}

	@Override
	public ResponseEntity healthCheck() {
		return ResponseEntity.ok().build();
	}
}
