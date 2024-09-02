package trabalho_pratico2remake;
import java.util.*;

/**
 * Define as funcoes que atuam sobre os formularios, sendo uma subclasse de um HashMap que aceita Strings como chave e objetos da classe Field como objetos.
 * @author Lucas Martins a22103318
 */
public class Form extends HashMap<String,Field>{
	/**
	 * errors: Array de Strings que define os erros encontrados num formulario.
	 */
	protected String[] errors;
	
	/**
	 * Construtor da classe Form.
	 * Inicializa errors como um array de 0 elementos para garantir que nao haja outputs desnecessarios na ausencia de erros no formulario.
	 */
	public Form() {
		super();
		this.errors = new String[0];
	}
	
	/**
	 * Valida os campos de um formulario procurando os validadores associados ao mesmo e alterando o resultado destes de modo a destinguir quais condicoes dos validadores foram cumpridas.
	 * Consoante os resultados obtidos, altera o tamanho do array de Strings errors inserindo no mesmo mensagens de erro associadas a cada validador, que encontrou o erro.
	 */
	public void validate() {
		int found_error = 0;
		for(Map.Entry<String, Field> set: this.entrySet()) {
			for(int i = 0; i<set.getValue().getValidators().length;i++) {
				if(set.getValue().getValidator(i) instanceof Length) {
					((Length)set.getValue().getValidator(i)).validateLength(((StringField) set.getValue()).getContent());
				} else if(set.getValue().getValidator(i) instanceof Required) {
					((Required) set.getValue().getValidator(i)).validateRequired(((StringField) set.getValue()).getContent());
				} else if(set.getValue().getValidator(i) instanceof NumberRange) {
					((NumberRange)set.getValue().getValidator(i)).validateRange(((NumberField) set.getValue()).getContentInt());	
				} else if(set.getValue().getValidator(i) instanceof ValidEmail) {
					((ValidEmail)set.getValue().getValidator(i)).validateEmail(((StringField) set.getValue()).getContent());
				} else if(set.getValue().getValidator(i) instanceof ValidOption) {
					((ValidOption)set.getValue().getValidator(i)).validateOption(Integer.parseInt(set.getValue().getContent()));
				} else {continue;}
				if(set.getValue().getValidator(i).getResult()) {found_error++;}
			}
		}
		this.errors = new String[found_error];
		int j=0;
		for(Map.Entry<String, Field> set: this.entrySet()) {
			for(int i = 0; i<set.getValue().getValidators().length;i++) {
				if(set.getValue().getValidator(i) instanceof Length) {if(set.getValue().getValidator(i).getResult()) {this.errors[j] = "Error: less than min"; j++;}
				} else if(set.getValue().getValidator(i) instanceof Required) {if(set.getValue().getValidator(i).getResult()) {this.errors[j] = "Error: value empty"; j++;} 
				} else if(set.getValue().getValidator(i) instanceof ValidEmail) {if(set.getValue().getValidator(i).getResult()) {this.errors[j] = "Error: invalid email"; j++;}
				} else if(set.getValue().getValidator(i) instanceof NumberRange) {if(set.getValue().getValidator(i).getResult()) {this.errors[j] = "Error: value not in range"; j++;}
				} else if(set.getValue().getValidator(i) instanceof ValidOption) {if(set.getValue().getValidator(i).getResult()) {this.errors[j] = "Error: invalid option"; j++;}
				} else {continue;}
			}
		}
	}	
	
	/**
	 * Permite obter uma string que contenha o nome de todos os campos envolvidos no formulario seguido do conteudo associado a cada um destes.
	 * @return Nome dos campos e o conteudo de cada um deles.
	 */
	public String content() {
		String formContent = "\n";
		for(Map.Entry<String, Field> set: this.entrySet()) {
			if(set.getKey().equals("email")) {formContent = formContent + "'email':" + set.getValue().getContent() + "\n";}
			else if(set.getKey().equals("age")) {formContent = formContent + "'age':" + set.getValue().getContent() + "\n";}
			else if(set.getKey().equals("username")) {formContent = formContent + "'username':" + set.getValue().getContent() + "\n";}
			else if(set.getKey().equals("gender")) {formContent = formContent + "'gender':" + ((SelectBoxField) set.getValue()).getOption(Integer.parseInt(set.getValue().getContent())-1) + "\n";}
		}
		return formContent;
	}
	
	/**
	 * Usa os conteudos do formulario e converte-os para o formato json.
	 * @return String com os conteudos do formulario convertidos para o formato json.
	 */
	public String json() {
		String[] fields = new String[this.size()];
		int count = 0;
		String formJson = "<form>\n";
		for(Map.Entry<String, Field> set: this.entrySet()) {
			if(set.getKey().equals("email")) {formJson = formJson + "\t<label for=’email’>email:</label>" + "\n\t<input name=’email’ type=’text’ value=’"+ set.getValue().getContent() +"’/><br>\n";fields[count]="email";count++;}
			else if(set.getKey().equals("age")) {formJson = formJson + "\t<label for=’age’>age:</label>" + "\n\t<input name=’age’ type=’number’ value=’" + set.getValue().getContent() + "’/><br>\n";fields[count]="age";count++;}
			else if(set.getKey().equals("username")) {formJson = formJson + "\t<label for=’username’>username:</label>" + "\n\t<input name=’username’ type=’text’ value='"+ set.getValue().getContent() +"'/><br>\n";fields[count]="username";count++;}
			else if(set.getKey().equals("gender")) {
				formJson = formJson + "\t<label for=’gender’>gender:</label>" + "<select name='gender'>";
				for(int i = 0; i < ((SelectBoxField) set.getValue()).optionsNumber(); i++) {
					formJson = formJson + "\n\t\t<option value='" + (i+1) + "'>" + ((SelectBoxField) set.getValue()).getOption(i) + "</option>";
				}
				formJson = formJson + "\n\t</select>\n";
				fields[count]="gender";count++;
			}
		}
		formJson = formJson + "</form>\n{";
		for(int i=0; i<fields.length; i++) {
			if(fields[i].equals("email")) {formJson = formJson + "’email’:’"+this.get("email")+"’";}
			else if(fields[i].equals("age")) {formJson = formJson + "’age’:"+this.get("age");}
			else if(fields[i].equals("username")) {formJson = formJson + "’username’:’"+this.get("username")+"’";}
			else if(fields[i].equals("gender")) {formJson = formJson + "’gender’:’"+this.get("gender")+"’";}
			if(i < fields.length-1) {formJson = formJson + ",";}
		}
		formJson = formJson + "}";
		return formJson;
	}
}
