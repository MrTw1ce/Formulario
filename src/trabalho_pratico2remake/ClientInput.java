package trabalho_pratico2remake;
import java.util.*;

/**
 * Subclasse da classe Form, representa o formulario a preencher e define os campos a serem preenchidos e os validadores associados a cada campo.
 */
class UsernameForm extends Form {
	/**
	 * Construtor da classe UsernameForm.
	 */
	UsernameForm(){
			super();
			this.put("username", new StringField("Username",new Validator[]{new Length(3)}));
			this.put("email", new StringField("Email", new Validator[]{new Required(), new ValidEmail()}));
			this.put("age", new NumberField("Age", new Validator[]{new NumberRange(16,99)}));
			this.put("gender", new SelectBoxField(new String[] {"Masculino","Feminino","Outro"},"Gender", new Validator[]{new ValidOption(3)}));
		}
}

/**
 * Versao alterada das classes Client fornecidas pelo docente, que permite o input de conteudos nos campos por meio da consola, continuando sujeito a aprovacao dos validadores.
 * @author Lucas Martins a22103318
 */
class ClientInput {
	/**
	 * Main da classe Client.
	 * @param args Array de parametros do tipo string.
	 */
	public static void main(String[] args) {
		UsernameForm form = new UsernameForm();
		Scanner sc = new Scanner(System.in);
		System.out.print("Username:");
		form.get("username").setData(sc.nextLine());
		System.out.print("Email:");
		form.get("email").setData(sc.nextLine());
		System.out.print("Age:");
		form.get("age").setData(sc.nextInt());
		System.out.print("\nGender:" + ((SelectBoxField) form.get("gender")).showOptions());
		form.get("gender").setData(sc.nextInt());
		form.validate();
		for(String err : form.errors)
		System.out.println(err);
		System.out.println(form.json());
		sc.close();
	}
}
