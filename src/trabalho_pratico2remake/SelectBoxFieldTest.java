package trabalho_pratico2remake;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectBoxFieldTest {

	@Test
	public void testSelectBoxField() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		assertEquals(field.getContent(),"2");
		assertEquals(field.getOption(0),"Solteiro");
		assertEquals(field.getOption(1),"Casado");
		assertEquals(((ValidOption) field.getValidator(0)).getOptions(),3);
	}
	
	@Test
	public void testGetContent() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		assertEquals(field.getContent(),"2");
	}

	@Test
	public void testGetValidators() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		Validator[] _valid = field.getValidators();
		assertEquals(((ValidOption) _valid[0]).getOptions(),3);
	}

	@Test
	public void testGetValidator() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		Validator valid = field.getValidator(0);
		assertEquals(((ValidOption) valid).getOptions(),3);
	}

	@Test
	public void testSetDataInteger() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		field.setData(1);
		assertEquals(field.getContent(),"1");
		field.setData(0);
		assertEquals(field.getContent(),"3");
		field.setData(6);
		assertEquals(field.getContent(),"3");
	}

	@Test
	public void testGetOption() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		assertEquals(field.getOption(0),"Solteiro");
		assertEquals(field.getOption(1),"Casado");
	}

	@Test
	public void testOptionsNumber() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		assertEquals(field.optionsNumber(),2);
	}

	@Test
	public void testShowOptions() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		assertEquals(field.showOptions(),"\n1-Solteiro\n2-Casado\nR:");
	}

	@Test
	public void testToString() {
		SelectBoxField field = new SelectBoxField(new String[] {"Solteiro","Casado"},"2", new Validator[]{new ValidOption(2)});
		assertEquals(field.toString(),"casado");
		field.setData(1);
		assertEquals(field.toString(),"solteiro");
		field.setData(4);
		assertEquals(field.toString(),"inválido");
	}

}
