package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFieldTest {

	@Test
	public void testNumberField() {
		NumberField field = new NumberField("0",new Validator[] {new NumberRange(3,9)});
		assertEquals(field.getContent(),"0");
		assertEquals(field.getValidator(0).getResult(),false);
		assertEquals(((NumberRange) field.getValidator(0)).getMax(),9);
		assertEquals(((NumberRange) field.getValidator(0)).getMin(),3);
	}

	@Test
	public void testGetValidators() {
		NumberField field = new NumberField("0",new Validator[] {new NumberRange(3,9)});
		Validator[] valid = field.getValidators();
		assertEquals(valid[0].getResult(),false);
		assertEquals(((NumberRange) valid[0]).getMax(),9);
		assertEquals(((NumberRange) valid[0]).getMin(),3);
	}

	@Test
	public void testGetValidator() {
		NumberField field = new NumberField("0",new Validator[] {new NumberRange(3,9)});
		assertEquals(field.getValidator(0).getResult(),false);
		assertEquals(((NumberRange) field.getValidator(0)).getMax(),9);
		assertEquals(((NumberRange) field.getValidator(0)).getMin(),3);
	}

	@Test
	public void testSetDataInteger() {
		NumberField field = new NumberField("12",new Validator[] {new NumberRange(3,9)});
		field.setData(10);;
		assertEquals(field.getContent(),"10");
	}

	@Test
	public void testGetContent() {
		NumberField field = new NumberField("10",new Validator[] {new NumberRange(3,9)});
		assertEquals(field.getContent(),"10");
	}

	@Test
	public void testGetContentInt() {
		NumberField field = new NumberField("10",new Validator[] {new NumberRange(3,9)});
		int content = field.getContentInt();
		assertEquals(content,10);
	}

	@Test
	public void testToString() {
		NumberField field = new NumberField("10",new Validator[] {new NumberRange(3,9)});
		assertEquals(field.toString(),"10");
	}

}
