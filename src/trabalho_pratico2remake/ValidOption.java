package trabalho_pratico2remake;

/**
 * Subclasse da classe Validator, representa um validador associado a selecao de uma opcao valida de uma Select Box.
 * @author Lucas Martins a22103318
 */
public class ValidOption extends Validator{
	/**
	 * options Numero de opcoes validas de uma Select Box.
	 */
	protected int options;
	
	/**
	 * Construtor da classe ValidOption.
	 * @param _options Numero de opcoes validas, vai ser incrementado uma vez para determinar a opcao invalida.
	 */
	public ValidOption(int _options) {
		super();
		this.options = _options + 1;
	}
	
	/**
	 * Permite obter o numero total de opcoes incluindo aquela que e considerada invalida.
	 * @return Numero de opecoes total.
	 */
	public int getOptions() {return this.options;}
	
	/**
	 * Permite alterar o numero de opcoes do validador.
	 * @param _options Numero de opcoes validas, a semelhanca do construtor o valor introduzido neste campo tambem sera incrementado uma vez.
	 */
	public void setOptions(int _options) {this.options = _options + 1;}
	
	/**
	 * Valida a opcao introduzida.
	 * @param content Opcao a ser validada, se for igual ao valor incrementado do parametro que foi introduzido quando este validador foi instanciado entao o resultado do mesmo e alterado para true caso contrario e alterado para true.
	 */
	public void validateOption(int content) {
		if(content == this.options) {this.setResult(true);}
		else {this.setResult(false);}
	}
}
