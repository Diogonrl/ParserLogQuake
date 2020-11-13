package dnrl.TstEstagio.parse;

public class Kill {
	private String jogadorMatou;
	private String jogadorMorreu;
	public String getJogadorMatou() {
		return jogadorMatou;
	}
	public void setJogadorMatou(String jogadorMatou) {
		this.jogadorMatou = jogadorMatou;
	}
	public String getJogadorMorreu() {
		return jogadorMorreu;
	}
	public void setJogadorMorreu(String jogadorMorreu) {
		this.jogadorMorreu = jogadorMorreu;
	}
	public Kill(String jogadorMatou, String jogadorMorreu) {
		super();
		this.jogadorMatou = jogadorMatou;
		this.jogadorMorreu = jogadorMorreu;
	}

}
