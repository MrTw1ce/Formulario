package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringFieldTest {

	@Test
	public void testStringField() {
		StringField field = new StringField("Teste",new Validator[] {new Length(3)});
		assertEquals(field.getContent(),"Teste");
		assertEquals(field.getValidator(0).getResult(),false);
		assertEquals(((Length) field.getValidator(0)).getLength(),3);
	}
	
	@Test
	public void testGetContent() {
		StringField field = new StringField("Teste",new Validator[] {new Length(3)});
		assertEquals(field.getContent(),"Teste");
	}

	@Test
	public void testGetValidators() {
		StringField field = new StringField("Teste",new Validator[] {new Length(3)});
		Validator[] valid = field.getValidators();
		assertEquals(valid[0].getResult(),false);
		assertEquals(((Length) valid[0]).getLength(),3);
	}

	@Test
	public void testGetValidator() {
		StringField field = new StringField("Teste",new Validator[] {new Length(3)});
		assertEquals(field.getValidator(0).getResult(),false);
		assertEquals(((Length) field.getValidator(0)).getLength(),3);
	}

	@Test
	public void testSetDataString() {
		StringField field = new StringField("Teste",new Validator[] {new Length(3)});
		field.setData("Testado");
		assertEquals(field.getContent(),"Testado");
	}

	@Test
	public void testToString() {
		StringField field = new StringField("Teste",new Validator[] {new Length(3)});
		assertEquals(field.toString(),"Teste");
	}

}
