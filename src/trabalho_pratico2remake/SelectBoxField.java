package trabalho_pratico2remake;

/**
 * Subclasse da classe Field, permite implementar um campo que executa a funcao de uma Select Box.
 * @author Lucas Martins a22103318
 */
public class SelectBoxField extends Field{
	/**
	 * option: Array de Strings que representa as opcoes que se podem selecionar na Select Box.
	 */
	protected String[] option;
	
	/**
	 * Construtor da classe SelectBoxField.
	 * Quando se instancia um objeto desta classe, e adicionada uma opcao que nao pode ser selecionada.
	 * @param _option Opcoes a selecionar
	 * @param content Opcao selecionada
	 * @param valid Array de validadores associados ao campo
	 */
	public SelectBoxField(String[] _option,String content, Validator[] valid){
		super(content,valid);
		this.option = new String[_option.length+1];
		for(int i = 0; i < _option.length; i++) {
			this.option[i] = _option[i];
			if(i == (_option.length-1)) {this.option[i+1] = "Inválido";}
		}
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
	 * Permite obter uma das opcoes associadas a um campo do tipo Select Box.
	 * @param i Indice da opcao que se pretende obter.
	 * @return Opcao selecionada.
	 */
	public String getOption(int i) {return this.option[i];}
	
	/**
	 * Permite obter o numero de opcoes de uma Select Box.
	 * @return Numero de opcoes do campo do tipo Select Box.
	 */
	public int optionsNumber() {return this.option.length-1;}
	
	/**
	 * Permite alterar o conteudo de um campo por meio de um Integer, se o mesmo for o index do ultimo elemento do array ou fora dos limites do mesmo assume o valor do index do ultimo elemento do array, que representa uma opcao invalida.
	 * @param content Novo conteudo a introduzir no campo.
	 */
	@Override
	public void setData(Integer content) {
		if(content-1 > this.option.length-2 || content <=0) {content = this.option.length;}
		this._content = content.toString();
		}
	
	/**
	 * Cria uma String com todas as opcoes a selecionar.
	 * @return Opcoes que podem ser selecionadas de um campo do tipo Select Box.
	 */
	public String showOptions() {
		String option = "";
		for(int i = 0; i < this.option.length-1; i++) {
			option = option + "\n" + (i+1) + "-" + this.option[i];
		}
		option = option + "\nR:";
		return option;
	}
	
	/**
	 * Converte o conteudo de um campo numa string, neste caso mostra a opcao referente ao conteudo do campo.
	 * @return Opcao referente ao conteúdo do campo.
	 */
	@Override
	public String toString() {return this.option[Integer.parseInt(this.getContent())-1].toLowerCase();}
}
