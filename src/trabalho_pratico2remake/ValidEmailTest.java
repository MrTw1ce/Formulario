package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidEmailTest {

	@Test
	public void testValidEmail() {
		ValidEmail valid = new ValidEmail();
		assertEquals(valid.getResult(),false);
	}

	@Test
	public void testValidateEmail() {
		ValidEmail valid = new ValidEmail();
		String email1 = "tia@gmail.com";
		valid.validateEmail(email1);
		assertEquals(valid.getResult(),false);
		
		String email2 = "tiagmail.com";
		valid.validateEmail(email2);
		assertEquals(valid.getResult(),true);
		
		String email3 = "tiagmail..com";
		valid.validateEmail(email3);
		assertEquals(valid.getResult(),true);
		
		String email4 = "@.pt";
		valid.validateEmail(email4);
		assertEquals(valid.getResult(),true);
		
		String email5 = "tia@gmail..com";
		valid.validateEmail(email5);
		assertEquals(valid.getResult(),true);
		
		String email6 = "tia@gmail.pt";
		valid.validateEmail(email6);
		assertEquals(valid.getResult(),false);
		
		String email7 = "";
		valid.validateEmail(email7);
		assertEquals(valid.getResult(),true);
	}

}
