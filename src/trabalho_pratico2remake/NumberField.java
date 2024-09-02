package trabalho_pratico2remake;

/**
 * Subclasse da classe Field, representa um campo que contem valores numericos.
 * @author Lucas Martins a22103318
 */
class NumberField extends Field{
	/**
	 * Construtor da classe NumberField.
	 * @param content Conteudo do campo.
	 * @param valid Array de validadores associado ao campo.
	 */
	public NumberField(String content, Validator[] valid){
		super(content,valid);
	}
	
	/**
	 * Permite obter um array de validadores associados a um campo numerico.
	 * @return Array de validadores associados ao campo.
	 */
	@Override	
	public Validator[] getValidators() {return this._valid;}
	
	/**
	 * Permite obter um validador associados a um campo numerico.
	 * @param i Representa o indice associado ao validador que se pretende obter.
	 * @return Validador de indice i do array de validadores associado a um campo numerico.
	 */
	@Override
	public Validator getValidator(int i) {return this._valid[i];}
	
	/**
	 * Permite obter o conteudo de um campo numerico como uma String.
	 * @return Conteudo de um campo numerico como uma String.
	 */
	@Override
	public String getContent() {return this._content;}
	
	/**
	 * Permite obter o conteudo de um campo numerico como um Integer.
	 * @return Conteudo de um campo numerico como um Integer.
	 */
	public Integer getContentInt() {return Integer.parseInt(this._content);}
	
	/**
	 * Permite alterar o conteudo de um campo numerico por meio de um Integer que sera convertido numa String.
	 * @param content Novo conteudo a introduzir no campo numerico.
	 */
	@Override
	public void setData(Integer content) {this._content = content.toString();}
	
	/**
	 * Converte o conteudo de um campo numerico numa String.
	 * @return Conteudo de um campo numerico como uma String.
	 */
	@Override
	public String toString() {return this._content.toString();}
}