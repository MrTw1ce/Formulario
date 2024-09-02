package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class RequiredTest {

	@Test
	public void testRequired() {
		Required valid = new Required();
		assertEquals(valid.getResult(),false);
	}

	@Test
	public void testValidateRequired() {
		Required valid = new Required();
		valid.validateRequired("Teste");
		assertEquals(valid.getResult(),false);
		
		Required valid_error = new Required();
		valid_error.validateRequired("");
		assertEquals(valid_error.getResult(),true);
	}

}
