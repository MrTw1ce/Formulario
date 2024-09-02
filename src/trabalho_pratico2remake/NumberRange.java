package trabalho_pratico2remake;

/**
 * Subclasse da classe Validator, representa um validador associado a um limite superior e inferior de um valor numerico.
 * @author Lucas Martins a22103318
 */
public class NumberRange extends Validator{
	/**
	 * _max: Limite maximo do valor numerico.
	 */
	protected int _max;
	/**
	 *_min: Limite minimo do valor numerico.
	 */
	protected int _min;
	
	/**
	 * Contrutor da classe NumberRange.
	 * @param min Limite minimo que um valor numerico pode assumir.
	 * @param max Limite maximo que um valor numerico pode assumir.
	 */
	public NumberRange(int min, int max){
		super();
		_min = min;
		_max = max;	
	}
	
	/**
	 * Permite obter o limite minimo associado a um validador NumberRange.
	 * @return Valor minimo que um valor numerico com este validador pode assumir.
	 */
	public int getMin() {return this._min;}
	
	/**
	 * Permite obter o limite maximo associado a um validador NumberRange.
	 * @return Valor maximo que um valor numerico com este validador pode assumir.
	 */
	public int getMax() {return this._max;}
	
	/**
	 * Permite alterar o limite minimo associado a um validador NumberRange.
	 * @param min Novo valor minimo que um valor numerico com este validador pode assumir.
	 */
	public void setMin(int min) {this._min = min;}
	
	/**
	 * Permite alterar o limite minimo associado a um validador NumberRange.
	 * @param max Novo valor minimo que um valor numerico com este validador pode assumir.
	 */
	public void setMax(int max) {this._max = max;}
	
	/**
	 * Verifica se um valor numerico esta entre os limites determinados num validador NumberLength, altera o resultado do mesmo para false se o valor estiver dentro dos limites, caso contrario o valor e alterado para true.
	 * @param content Representa o valor numerico a validar.
	 */
	public void validateRange(int content) {
		if(content < this._min || content > this._max){this.setResult(true);}
		else {this.setResult(false);}
	}
}
