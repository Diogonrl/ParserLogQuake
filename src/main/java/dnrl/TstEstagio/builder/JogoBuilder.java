package dnrl.TstEstagio.builder;

import java.util.ArrayList;

import dnrl.TstEstagio.entidades.Jogador;
import dnrl.TstEstagio.entidades.Jogo;

public class JogoBuilder {
	public static Jogo build(int numero) {
		Jogo jogo = new Jogo();
		
		jogo.setName("game_" + (numero + 1));
		jogo.setJogadores(new ArrayList<Jogador>());
		
		return jogo;
	}
}
