package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void testValidator() {
		Validator valid = new Validator();
		assertEquals(valid.getResult(),false);
	}

	@Test
	public void testSetResult() {
		Validator valid = new Validator();
		valid.setResult(true);
		assertEquals(valid.getResult(),true);
	}

	@Test
	public void testGetResult() {
		Validator valid = new Validator();
		assertEquals(valid.getResult(),false);
	}

}
