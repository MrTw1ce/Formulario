package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class LengthTest {

	@Test
	public void testLength() {
		Length valid = new Length(3);
		assertEquals(valid.getLength(),3);
		assertEquals(valid.getResult(),false);
	}

	@Test
	public void testGetLength() {
		Length valid = new Length(3);
		assertEquals(valid.getLength(),3);
	}

	@Test
	public void testSetLength() {
		Length valid = new Length(3);
		valid.setLength(12);
		assertEquals(valid.getLength(),12);
	}

	@Test
	public void testValidateLength() {
		Length length = new Length(3);
		length.validateLength("Tia");
		assertEquals(length.getResult(),false);
		
		length.validateLength("Ti");
		assertEquals(length.getResult(),true);
	}

}
