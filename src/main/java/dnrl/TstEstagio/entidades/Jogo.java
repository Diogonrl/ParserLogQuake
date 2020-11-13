package dnrl.TstEstagio.entidades;

import java.util.List;

public class Jogo {
	
	private String name;
	private List<Jogador> jogadores;
	private int killInGame;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	public int getKillInGame() {
		return killInGame;
	}
	public void setKillInGame(int killInGame) {
		this.killInGame = killInGame;
	}
	public Jogo(String name, List<Jogador> jogadores, int killInGame) {
		super();
		this.name = name;
		this.jogadores = jogadores;
		this.killInGame = killInGame;
	}
	public Jogo() {}
	
	
	@Override
	public String toString() {
		return  name +": {"+ "\n"+  
				"     total_kills:" + killInGame + "\n"+
				"     players: " + jogadores + ""+"\n"+
				"     kills: {" + "\n" +
				contador() +"        }"+"\n"+
				"}\n";
			
	}
	
	private String contador() {
		String kills ="";
		for(int i=0; i<jogadores.size();i++) {
			kills = kills + "        "+jogadores.get(i).getNome() +":"+ jogadores.get(i).getKills()+"\n";
		}
		
		return kills;
	}
}
	

