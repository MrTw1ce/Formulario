package trabalho_pratico2remake;
/**
 * Classe abstrata que define os campos que compoem um formulario, e as funcoes essenciais aos mesmos.
 * @author Lucas Martins a22103318
 */
abstract public class Field{
	/**
	 * _content: Representa o conteudo do campo.
	 */
	protected String _content;
	/**
	 * _valid: Representa os validadores associados ao campo.
	 */
	protected Validator[] _valid;
	
	/**
	 * Construtor da classe Field.
	 * @param content Representa o conteudo de um campo.
	 * @param valid Representa os validadores a que o conteudo de um campo esta sujeito.
	 */
	public Field(String content, Validator[] valid){
		this._content = content;
		this._valid = valid;
	}
	
	/**
	 * Permite obter o conteudo de um campo.
	 * @return O conteudo introduzido no campo em forma de uma String.
	 */
	public String getContent() {return this._content;}
	
	/**
	 * Permite obter os validadores de um campo.
	 * @return Array de validadores associados a um campo.
	 */
	public Validator[] getValidators() {return this._valid;}
	
	/**
	 * Permite obter um validador especifico de um campo.
	 * @param i Indice do validador no array de validadores associado ao campo.
	 * @return O validador de indice i do array de validadores associado ao campo.
	 */
	public Validator getValidator(int i) {return this.getValidator(i);}
	
	/**
	 * Permite alterar o conteudo de um campo atraves de uma String.
	 * @param content Novo conteudo do campo.
	 */
	public void setData(String content) {}
	
	/**
	 * Permite alterar o conteudo de um campo atraves de um Integer.
	 * @param content Novo conteudo do campo.
	 */
	public void setData(Integer content) {}
}
