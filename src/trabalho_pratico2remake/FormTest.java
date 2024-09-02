package trabalho_pratico2remake;
import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class FormTest {

	@Test
	public void testForm() {
		Form form = new Form();
		form.put("username", new StringField("Username",new Validator[]{new Length(3)}));
		form.put("email", new StringField("Email", new Validator[]{new Required()}));
		form.put("age", new NumberField("Age", new Validator[]{new NumberRange(16,99)}));
		Field[] fields = {new StringField("Username",new Validator[]{new Length(3)}),
						  new StringField("Email", new Validator[]{new Required(), new ValidEmail()}),
						  new NumberField("Age", new Validator[]{new NumberRange(16,99)})
						 };
			assertEquals(form.get("username").getContent(),fields[0].getContent());
			assertEquals(((Length) form.get("username").getValidator(0)).getLength(),((Length) fields[0].getValidator(0)).getLength());
			assertEquals((form.get("username").getValidator(0)).getResult(),(fields[0].getValidator(0)).getResult());
			assertEquals(form.get("email").getContent(),fields[1].getContent());
			assertEquals((form.get("email").getValidator(0)).getResult(),(fields[1].getValidator(0)).getResult());
			assertEquals(form.get("age").getContent(),fields[2].getContent());
			assertEquals(((NumberRange) form.get("age").getValidator(0)).getMax(),((NumberRange) fields[2].getValidator(0)).getMax());
			assertEquals(((NumberRange) form.get("age").getValidator(0)).getMin(),((NumberRange) fields[2].getValidator(0)).getMin());
			assertEquals((form.get("age").getValidator(0)).getResult(),(fields[2].getValidator(0)).getResult());
	}

	@Test
	public void testValidate() {
		Form form = new Form();
		form.put("username", new StringField("tia",new Validator[]{new Length(3)}));
		form.put("email", new StringField("tia@gmail.com", new Validator[]{new Required(), new ValidEmail()}));
		form.put("age", new NumberField("16", new Validator[]{new NumberRange(16,99)}));
		form.put("gender", new SelectBoxField(new String[] {"Masculino","Feminino","Outro"},"1", new Validator[]{new ValidOption(3)}));
		form.validate();
		assertEquals((form.get("username").getValidator(0)).getResult(),false);
		assertEquals((form.get("email").getValidator(0)).getResult(),false);
		assertEquals((form.get("email").getValidator(1)).getResult(),false);
		assertEquals((form.get("age").getValidator(0)).getResult(),false);
		assertEquals((form.get("gender").getValidator(0)).getResult(),false);
		
		Form form_error1 = new Form();
		form_error1.put("username", new StringField("tia",new Validator[]{new Length(3)}));
		form_error1.put("email", new StringField("tiagmail.com", new Validator[]{new Required(), new ValidEmail()}));
		form_error1.put("age", new NumberField("0", new Validator[]{new NumberRange(16,99)}));
		form_error1.put("gender", new SelectBoxField(new String[] {"Masculino","Feminino","Outro"},"4", new Validator[]{new ValidOption(3)}));
		form_error1.validate();
		assertEquals((form_error1.get("username").getValidator(0)).getResult(),false);
		assertEquals((form_error1.get("email").getValidator(0)).getResult(),false);
		assertEquals((form_error1.get("email").getValidator(1)).getResult(),true);
		assertEquals((form_error1.get("age").getValidator(0)).getResult(),true);
		assertEquals((form_error1.get("gender").getValidator(0)).getResult(),true);
		
		Form form_error2 = new Form();
		form_error2.put("username", new StringField("ti",new Validator[]{new Length(3)}));
		form_error2.put("email", new StringField("", new Validator[]{new Required(), new ValidEmail()}));
		form_error2.put("age", new NumberField("0", new Validator[]{new NumberRange(16,99)}));
		form_error2.put("gender", new SelectBoxField(new String[] {"Masculino","Feminino","Outro"},"0", new Validator[]{new ValidOption(3)}));
		form_error2.validate();
		assertEquals((form_error2.get("username").getValidator(0)).getResult(),true);
		assertEquals((form_error2.get("email").getValidator(0)).getResult(),true);
		assertEquals((form_error2.get("email").getValidator(1)).getResult(),true);
		assertEquals((form_error2.get("age").getValidator(0)).getResult(),true);
		assertEquals((form_error1.get("gender").getValidator(0)).getResult(),true);
	}

	@Test
	public void testContent() {
		Form form_1 = new Form();
		form_1.put("username", new StringField("tia",new Validator[]{new Length(3)}));
		form_1.put("email", new StringField("tia@gmail.com", new Validator[]{new Required(), new ValidEmail()}));
		form_1.put("age", new NumberField("16", new Validator[]{new NumberRange(16,99)}));
		assertEquals(form_1.content(),"\n'email':tia@gmail.com\n'age':16\n'username':tia\n");
		Form form_2 = new Form();
		form_2.put("username", new StringField("tia",new Validator[]{new Length(3)}));
		form_2.put("email", new StringField("tia@gmail.com", new Validator[]{new Required(), new ValidEmail()}));
		form_2.put("age", new NumberField("16", new Validator[]{new NumberRange(16,99)}));
		form_2.put("gender", new SelectBoxField(new String[] {"Masculino","Feminino","Outro"},"2", new Validator[]{new ValidOption(3)}));
		assertEquals(form_2.content(),"\n'gender':Feminino\n'email':tia@gmail.com\n'age':16\n'username':tia\n");
	}

	@Test
	public void testJson() {
		Form form_1 = new Form();
		form_1.put("username", new StringField("tia",new Validator[]{new Length(3)}));
		form_1.put("email", new StringField("tia@gmail.com", new Validator[]{new Required(), new ValidEmail()}));
		form_1.put("age", new NumberField("16", new Validator[]{new NumberRange(16,99)}));
		assertEquals(form_1.json(),"<form>\n"
				+ "\t<label for=’email’>email:</label>\n"
				+ "\t<input name=’email’ type=’text’ value=’tia@gmail.com’/><br>\n"
				+ "\t<label for=’age’>age:</label>\n"
				+ "\t<input name=’age’ type=’number’ value=’16’/><br>\n"
				+ "\t<label for=’username’>username:</label>\n"
				+ "\t<input name=’username’ type=’text’ value='tia'/><br>\n</form>\n"
				+ "{’email’:’tia@gmail.com’,’age’:’16’,’username’:’tia’}");
		Form form_2 = new Form();
		form_2.put("username", new StringField("tia",new Validator[]{new Length(3)}));
		form_2.put("email", new StringField("tia@gmail.com", new Validator[]{new Required(), new ValidEmail()}));
		form_2.put("age", new NumberField("16", new Validator[]{new NumberRange(16,99)}));
		form_2.put("gender", new SelectBoxField(new String[] {"Masculino","Feminino","Outro"},"2", new Validator[]{new ValidOption(3)}));
		assertEquals(form_2.json(),"<form>\n"
				+ "\t<label for=’gender’>gender:</label><select name='gender'>\n"
				+ "\t\t<option value='1'>Masculino</option>\n"
				+ "\t\t<option value='2'>Feminino</option>\n"
				+ "\t\t<option value='3'>Outro</option>\n"
				+ "\t</select>\n"
				+ "\t<label for=’email’>email:</label>\n"
				+ "\t<input name=’email’ type=’text’ value=’tia@gmail.com’/><br>\n"
				+ "\t<label for=’age’>age:</label>\n"
				+ "\t<input name=’age’ type=’number’ value=’16’/><br>\n"
				+ "\t<label for=’username’>username:</label>\n"
				+ "\t<input name=’username’ type=’text’ value='tia'/><br>\n</form>\n"
				+ "{’gender’:’feminino’,’email’:’tia@gmail.com’,’age’:’16’,’username’:’tia’}");
	}
}
