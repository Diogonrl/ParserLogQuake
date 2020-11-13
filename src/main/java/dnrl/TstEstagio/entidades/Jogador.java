package dnrl.TstEstagio.entidades;

public class Jogador {
	
	private String nome;
	private int kills;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public Jogador(String nome) {
		super();
		this.nome = nome;
		this.kills = 0;
	}
	@Override
	public String toString() {
		return nome;
	}
}
