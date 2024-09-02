package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidOptionTest {

	@Test
	public void testValidOption() {
		ValidOption valid = new ValidOption(2);
		assertEquals(valid.getOptions(),3);
	}

	@Test
	public void testGetOptions() {
		ValidOption valid = new ValidOption(2);
		assertEquals(valid.getOptions(),3);
	}

	@Test
	public void testSetOptions() {
		ValidOption valid = new ValidOption(2);
		valid.setOptions(5);
		assertEquals(valid.getOptions(),6);
	}

	@Test
	public void testValidateOption() {
		ValidOption valid = new ValidOption(2);
		valid.validateOption(1);
		assertEquals(valid.getResult(),false);
		valid.validateOption(2);
		assertEquals(valid.getResult(),false);
		valid.validateOption(3);
		assertEquals(valid.getResult(),true);
	}
}
