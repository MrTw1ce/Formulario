package trabalho_pratico2remake;

/**
 * Subclasse da classe Validator, representa um validador associado a obrigatoriedade de preencher um campo.
 * @author Lucas Martins a22103318
 */
public class Required extends Validator{
	/**
	 * Construtor da classe Required.
	 */
	public Required(){super();}
	
	/**
	 * Verifica se o campo foi preenchido, se o comprimento da String presente no campo for maior que 0 o resultado do validador e alterado para false, se o comprimento for 0 entao o resultado do validador e alterado para true. 
	 * @param content String a validar.
	 */
	public void validateRequired(String content) {
		if(content.length() == 0){this.setResult(true);}
		else {this.setResult(false);}
	}
}
