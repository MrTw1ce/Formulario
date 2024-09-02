package trabalho_pratico2remake;
import java.util.regex.*;

/**
 * Subclasse da classe Validator, representa um validador associado a validade de um email.
 * @author Lucas Martins a22103318
 */
public class ValidEmail extends Validator{
	/**
	 * Construtor da classe ValidEmail.
	 */
	public ValidEmail() {super();}
	
	/**
	 * Valida um email por meio de uma expressão regular.
	 * @param content Representa o email a ser validado.
	 */
	public void validateEmail(String content) {
		Pattern email = Pattern.compile("[0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+([.-]?[0-9,a-z,A-Z])*(.){1}[a-zA-Z]{2,4}");
		if(content.equals(null)) {this.setResult(true);}
		else {
			if(email.matcher(content).matches()) {this.setResult(false);}
			else {this.setResult(true);}
		}
	}
}
