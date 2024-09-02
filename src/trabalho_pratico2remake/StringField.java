package trabalho_pratico2remake;

/**
 * Subclasse da classe Field, representa um campo que contem Strings.
 * @author Lucas Martins a22103318
 */
class StringField extends Field{	
	/**
	 * Construtor da classe StringField.
	 * @param content Conteudo do campo.
	 * @param valid Array de validadores associados ao campo.
	 */
	public StringField(String content, Validator[] valid) {
		super(content,valid);
	}
	
	/**
	 * Permite obter um array de validadores associados a um campo.
	 * @return Array de validadores associados ao campo.
	 */
	@Override	
	public Validator[] getValidators() {return this._valid;}
	
	/**
	 * Permite obter um validador associados a um campo.
	 * @param i Representa o indice associado ao validador que se pretende obter.
	 * @return Validador de indice i do array de validadores associado a um campo.
	 */
	@Override
	public Validator getValidator(int i) {return this._valid[i];}
	
	/**
	 * Permite obter o conteudo de um campo.
	 * @return Conteudo de um campo.
	 */
	@Override
	public String getContent() {return this._content;}
	
	/**
	 * Permite alterar o conteudo de um campo por meio de uma String.
	 * @param content Novo conteudo a introduzir no campo.
	 */
	@Override
	public void setData(String content) {this._content = content;}
	
	/**
	 * Converte o conteudo de um campo numa String.
	 * @return Conteudo de um campo como uma String.
	 */
	@Override
	public String toString() {return this._content.toString();}
}
