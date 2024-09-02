package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberRangeTest {

	@Test
	public void testNumberRange() {
		NumberRange valid = new NumberRange(10,20);
		assertEquals(valid.getResult(),false);
		assertEquals(valid.getMin(),10);
		assertEquals(valid.getMax(),20);
	}

	@Test
	public void testGetMin() {
		NumberRange valid = new NumberRange(1,20);
		assertEquals(valid.getMin(),1);
	}

	@Test
	public void testGetMax() {
		NumberRange valid = new NumberRange(1,25);
		assertEquals(valid.getMax(),25);
	}

	@Test
	public void testSetMin() {
		NumberRange valid = new NumberRange(8,20);
		valid.setMin(1);
		assertEquals(valid.getMin(),1);
	}

	@Test
	public void testSetMax() {
		NumberRange valid = new NumberRange(8,60);
		valid.setMax(49);
		assertEquals(valid.getMax(),49);
	}

	@Test
	public void testValidateRange() {
		NumberRange valid = new NumberRange(1,60);
		valid.validateRange(12);
		assertEquals(valid.getResult(),false);
		valid.validateRange(1);
		assertEquals(valid.getResult(),false);
		valid.validateRange(60);
		assertEquals(valid.getResult(),false);
		valid.validateRange(0);
		assertEquals(valid.getResult(),true);
		valid.validateRange(61);
		assertEquals(valid.getResult(),true);
	}

}
