package trabalho_pratico2remake;

/**
 * Classe que representa os validadores associados a um campo.
 * @author Lucas Martins a22103318
 */
public class Validator {
	/**
	 * _result Representa o resultado do validador, por defeito assume o valor de false.
	 */
	protected boolean _result = false;
	
	/**
	 * Construtor da classe Validator.
	 */
	public Validator() {}
	
	/**
	 * Permite alterar o resultado de um validador.
	 * @param result Novo resultado do validador.
	 */
	public void setResult(boolean result) {this._result = result;}
	
	/**
	 * Permite obter o resultado de um validador.
	 * @return Resultado do validador.
	 */
	public boolean getResult() {return this._result;}
}


