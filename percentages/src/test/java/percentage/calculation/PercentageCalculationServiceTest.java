package percentage.calculation;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import percentage.calculation.service.PercentageCalculationService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PercentageCalculationServiceTest {

	@Autowired
	private PercentageCalculationService percentageCaluclationService;

	@Test
	public void testCalculatePercentageValueFrom1RMValueSimple() {
		Assert.assertEquals(new BigDecimal("10.00"), percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), new BigDecimal("0.10")));
		Assert.assertEquals(new BigDecimal("01.00"), percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), new BigDecimal("0.01")));
		Assert.assertEquals(new BigDecimal("110.00"), percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), new BigDecimal("1.10")));
	}

	@Test
	public void testCalculatePercentageValueFrom1RMValueWithDecimal() {
		Assert.assertEquals(new BigDecimal("80.50"), percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), new BigDecimal("0.8050")));
		Assert.assertEquals(new BigDecimal("33.33"), percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), new BigDecimal("0.3333")));
		Assert.assertEquals(new BigDecimal("16.66"), percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), new BigDecimal("0.1666")));
	}

	@Test
	public void testCalculatePercentageValueFrom1RMValueInvalidValue() {
		try {
			percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), null);
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("percentage is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFrom1RMValue(null, new BigDecimal("0.10"));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("oneRMValue is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(-100l), new BigDecimal("0.10"));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("oneRMValue is less or equal zero", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), new BigDecimal("-0.10"));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("percentage is less or equal zero", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFrom1RMValue(BigDecimal.valueOf(100l), new BigDecimal("0.11111"));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("percentage scale must be less than 5", exception.getMessage());
		}
	}

	///////

	@Test
	public void calculatePercentageValueFromPercentageValueSimple() {
		Assert.assertEquals(new BigDecimal("10.00"), percentageCaluclationService.calculatePercentageValueFromPercentageValue(new BigDecimal("1.00"), BigDecimal.valueOf(100l), new BigDecimal("0.10")));
		Assert.assertEquals(new BigDecimal("110.00"), percentageCaluclationService.calculatePercentageValueFromPercentageValue(new BigDecimal("1.00"), BigDecimal.valueOf(100l), new BigDecimal("1.10")));
	}

	@Test
	public void calculatePercentageValueFromPercentageValue() {
		Assert.assertEquals(new BigDecimal("64.29"), percentageCaluclationService.calculatePercentageValueFromPercentageValue(new BigDecimal("0.70"), BigDecimal.valueOf(50l), new BigDecimal("0.90")));
		Assert.assertEquals(new BigDecimal("38.89"), percentageCaluclationService.calculatePercentageValueFromPercentageValue(new BigDecimal("0.90"), BigDecimal.valueOf(50l), new BigDecimal("0.70")));
	}

	@Test
	public void calculatePercentageValueFromPercentageValueInvalidValue() {
		try {
			percentageCaluclationService.calculatePercentageValueFromPercentageValue(BigDecimal.valueOf(100l), BigDecimal.valueOf(100l), null);
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("outputPercentage is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFromPercentageValue(BigDecimal.valueOf(100l), null, BigDecimal.valueOf(100l));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("inputValue is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFromPercentageValue(null, BigDecimal.valueOf(100l), BigDecimal.valueOf(100l));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("inputPercentage is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFromPercentageValue(BigDecimal.valueOf(100l), BigDecimal.valueOf(100l), BigDecimal.valueOf(-100l));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("outputPercentage is less or equal zero", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFromPercentageValue(BigDecimal.valueOf(100l), BigDecimal.valueOf(-100l), BigDecimal.valueOf(100l));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("inputValue is less or equal zero", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFromPercentageValue(BigDecimal.valueOf(-100l), BigDecimal.valueOf(100l), BigDecimal.valueOf(100l));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("inputPercentage is less or equal zero", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFromPercentageValue(new BigDecimal("0.11111"), BigDecimal.valueOf(100l), BigDecimal.valueOf(100l));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("inputPercentage scale must be less than 5", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageValueFromPercentageValue(BigDecimal.valueOf(100l), BigDecimal.valueOf(100l), new BigDecimal("0.11111"));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("outputPercentage scale must be less than 5", exception.getMessage());
		}
	}

	///////

	@Test
	public void testcalculateTensPercentagesFrom1RMSimple() {

		Map<BigDecimal, BigDecimal> result = percentageCaluclationService.calculateStandardPercentagesFrom1RM(BigDecimal.valueOf(100l));

		Assert.assertEquals(12, result.size());

		Assert.assertEquals(new BigDecimal("40.00"), result.get(new BigDecimal("0.40")));
		Assert.assertEquals(new BigDecimal("45.00"), result.get(new BigDecimal("0.45")));
		Assert.assertEquals(new BigDecimal("50.00"), result.get(new BigDecimal("0.50")));
		Assert.assertEquals(new BigDecimal("55.00"), result.get(new BigDecimal("0.55")));
		Assert.assertEquals(new BigDecimal("60.00"), result.get(new BigDecimal("0.60")));
		Assert.assertEquals(new BigDecimal("65.00"), result.get(new BigDecimal("0.65")));
		Assert.assertEquals(new BigDecimal("70.00"), result.get(new BigDecimal("0.70")));
		Assert.assertEquals(new BigDecimal("75.00"), result.get(new BigDecimal("0.75")));
		Assert.assertEquals(new BigDecimal("80.00"), result.get(new BigDecimal("0.80")));
		Assert.assertEquals(new BigDecimal("85.00"), result.get(new BigDecimal("0.85")));
		Assert.assertEquals(new BigDecimal("90.00"), result.get(new BigDecimal("0.90")));
		Assert.assertEquals(new BigDecimal("95.00"), result.get(new BigDecimal("0.95")));

		//check sorting
		Iterator<BigDecimal> iterator = result.values().iterator();

		Assert.assertEquals(new BigDecimal("40.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("45.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("50.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("55.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("60.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("65.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("70.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("75.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("80.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("85.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("90.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("95.00"), iterator.next());
	}

	@Test
	public void calculateTensPercentagesFrom1RMInvalidValue() {

		try {
			percentageCaluclationService.calculateStandardPercentagesFrom1RM(null);
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("oneRMValue is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculateStandardPercentagesFrom1RM(BigDecimal.valueOf(-100l));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("oneRMValue is less or equal zero", exception.getMessage());
		}
	}

	////

	@Test
	public void testCalculateGivenPercentagesFrom1RM() {

		Map<BigDecimal, BigDecimal> result = percentageCaluclationService.calculateGivenPercentagesFrom1RM(BigDecimal.valueOf(100l), Arrays.asList(new BigDecimal("0.10"), new BigDecimal("0.30"), new BigDecimal("0.20")));

		Assert.assertEquals(3, result.size());

		Assert.assertEquals(new BigDecimal("10.00"), result.get(new BigDecimal("0.10")));
		Assert.assertEquals(new BigDecimal("20.00"), result.get(new BigDecimal("0.20")));
		Assert.assertEquals(new BigDecimal("30.00"), result.get(new BigDecimal("0.30")));

		//check sorting
		Iterator<BigDecimal> iterator = result.values().iterator();

		Assert.assertEquals(new BigDecimal("10.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("20.00"), iterator.next());
		Assert.assertEquals(new BigDecimal("30.00"), iterator.next());
	}

	@Test
	public void calculateGivenPercentagesFrom1RMInvalidValue() {

		try {
			percentageCaluclationService.calculateGivenPercentagesFrom1RM(null, Arrays.asList(new BigDecimal("0.10"), new BigDecimal("0.20")));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("oneRMValue is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculateGivenPercentagesFrom1RM(BigDecimal.valueOf(-100l), Arrays.asList(new BigDecimal("0.10"), new BigDecimal("0.20")));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("oneRMValue is less or equal zero", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculateGivenPercentagesFrom1RM(BigDecimal.valueOf(100l), Arrays.asList(null, new BigDecimal("0.20")));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("one of percentages is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculateGivenPercentagesFrom1RM(BigDecimal.valueOf(100l), Arrays.asList(new BigDecimal("-0.10"), new BigDecimal("0.20")));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("one of percentages is less or equal zero", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculateGivenPercentagesFrom1RM(BigDecimal.valueOf(100l), Arrays.asList(new BigDecimal("0.10"), new BigDecimal("0.22222")));
			Assert.fail();
		} catch(IllegalArgumentException exception) {
			Assert.assertEquals("percentages scale must be less than 5", exception.getMessage());
		}
	}

	////

	@Test
	public void calculatePercentageOfValueFrom1RMValueSimple() {

		Assert.assertEquals(new BigDecimal("0.50"), percentageCaluclationService.calculatePercentageOfValueFrom1RMValue(BigDecimal.valueOf(100l), BigDecimal.valueOf(50l)));
		Assert.assertEquals(new BigDecimal("1.10"), percentageCaluclationService.calculatePercentageOfValueFrom1RMValue(BigDecimal.valueOf(100l), BigDecimal.valueOf(110l)));
	}

	@Test
	public void calculatePercentageOfValueFrom1RMValue() {

		Assert.assertEquals(new BigDecimal("0.78"), percentageCaluclationService.calculatePercentageOfValueFrom1RMValue(BigDecimal.valueOf(90l), BigDecimal.valueOf(70l)));
		Assert.assertEquals(new BigDecimal("1.29"), percentageCaluclationService.calculatePercentageOfValueFrom1RMValue(BigDecimal.valueOf(70l), BigDecimal.valueOf(90l)));
	}

	@Test
	public void calculatePercentageOfValueFrom1RMValueInvalidValue() {

		try {
			percentageCaluclationService.calculatePercentageOfValueFrom1RMValue(null, BigDecimal.valueOf(70l));
			Assert.fail();
		} catch (IllegalArgumentException exception) {
			Assert.assertEquals("oneRMValue is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageOfValueFrom1RMValue(BigDecimal.valueOf(70l), null);
			Assert.fail();
		} catch (IllegalArgumentException exception) {
			Assert.assertEquals("inputValue is null", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageOfValueFrom1RMValue(BigDecimal.valueOf(-70l), BigDecimal.valueOf(70l));
			Assert.fail();
		} catch (IllegalArgumentException exception) {
			Assert.assertEquals("oneRMValue is less or equal zero", exception.getMessage());
		}

		try {
			percentageCaluclationService.calculatePercentageOfValueFrom1RMValue(BigDecimal.valueOf(70l), BigDecimal.valueOf(-70l));
			Assert.fail();
		} catch (IllegalArgumentException exception) {
			Assert.assertEquals("inputValue is less or equal zero", exception.getMessage());
		}
	}
}
