package trabalho_pratico2remake;

/**
 * Subclasse da classe Validator, representa um validador associado ao comprimento do conteudo de um campo do formulrio.
 * @author Lucas Martins a22103318
 */
public class Length extends Validator{
	/**
	 * _length: Representa o comprimento minimo que uma String com este validador deve ter para ser considerada valida.
	 */
	protected int _length;
	
	/**
	 * Construtor da classe Length.
	 * @param length Comprimento minimo para que uma String seja valida.
	 */
	public Length(int length){
		super();
		_length = length;
	}
	
	/**
	 * Permite obter o comprimento minimo de uma String que um validador Length aceita.
	 * @return Comprimento minimo de String aceite.
	 */
	public int getLength() {return this._length;}
	
	/**
	 * Permite alterar o comprimento minimo de uma String que um validador Length aceita.
	 * @param length Novo comprimento minimo de String aceite.
	 */
	public void setLength(int length) {this._length = length;}
	
	/**
	 * Verifica o comprimento de uma String e altera o resultado do validador Length para false se o comprimento da mesma for maior o igual que o comprimento minimo e true caso esta assuma um comprimento menor que o comprimento minimo.
	 * @param content String a ser validada.
	 */
	public void validateLength(String content) {
		if(content.length() < this._length){this.setResult(true);}
		else {this.setResult(false);}
	}
}
