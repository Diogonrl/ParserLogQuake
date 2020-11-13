package dnrl.TstEstagio.parse;

import java.util.List;

import dnrl.TstEstagio.entidades.Jogo;

public class Print {
	public static void imprimir(int escolha, List<Jogo> jogos) {
		if(escolha==0) {
			System.out.print(jogos);
		}
		else {
			System.out.print(jogos.get(escolha-1));
		}
	}
}
