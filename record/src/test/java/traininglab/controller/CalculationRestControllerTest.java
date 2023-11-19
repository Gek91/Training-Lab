package traininglab.controller;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import traininglab.controller.data.GetPercentageValuesFrom1RMValueResultDTO;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
public class CalculationRestControllerTest {

	@Test
	public void testGetPergentageValuesFrom1RmValue() {

		GetPercentageValuesFrom1RMValueResultDTO check = new GetPercentageValuesFrom1RMValueResultDTO();

		check.setValues(Arrays.asList(
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(40l, 2),BigDecimal.valueOf(4000l,2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(45l,2),BigDecimal.valueOf(4500l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(50l,2),BigDecimal.valueOf(5000l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(55l,2),BigDecimal.valueOf(5500l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(60l,2),BigDecimal.valueOf(6000l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(65l,2),BigDecimal.valueOf(6500l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(70l,2),BigDecimal.valueOf(7000l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(75l,2),BigDecimal.valueOf(7500l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(80l,2),BigDecimal.valueOf(8000l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(85l,2),BigDecimal.valueOf(8500l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(90l,2),BigDecimal.valueOf(9000l, 2)),
				new GetPercentageValuesFrom1RMValueResultDTO.PercentageValueValueDTO(BigDecimal.valueOf(95l,2),BigDecimal.valueOf(9500l, 2))

		));

		GetPercentageValuesFrom1RMValueResultDTO result = RestAssured.get("/calculations/standard-percentage-values/100").then().statusCode(200)
				.extract().as(GetPercentageValuesFrom1RMValueResultDTO.class);
		Assert.assertEquals(check, result);
	}

	@Test
	public void testGetValueFromPercentage() {

		BigDecimal result = RestAssured.get("/calculations/value-from-percentage?rm=100&percentage=0.5")
				.then().statusCode(200).extract().as(BigDecimal.class);

		Assert.assertEquals(result, new BigDecimal("50.00"));
	}

	@Test
	public void testGetPercentageFromValue() {

		BigDecimal result = RestAssured.get("/calculations/percentage-from-value?rm=100&value=50")
				.then().statusCode(200).extract().as(BigDecimal.class);

		Assert.assertEquals(result, new BigDecimal("0.50"));

	}

}
