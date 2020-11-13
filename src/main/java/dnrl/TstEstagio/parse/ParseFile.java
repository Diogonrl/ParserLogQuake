package dnrl.TstEstagio.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dnrl.TstEstagio.builder.JogoBuilder;
import dnrl.TstEstagio.entidades.Jogador;
import dnrl.TstEstagio.entidades.Jogo;

public class ParseFile {

	// TRATAMENTO DA LINHA DO KILL
	private Kill trataKill(String linha) {
		String[] linhaQuebrada = linha.split(" killed " + "");
		String[] parteUm = linhaQuebrada[0].split(": ");
		String[] parteDois = linhaQuebrada[1].split(" by");
		return new Kill("\\" + parteUm[2] + "\\", "\\" + parteDois[0] + "\\");
	}

	// TRATAMENTO DA LINHA DO JOGADOR
	private Jogador trataJogador(String linha) {
		String[] linhaQuebrada = linha.split(" n");// formatando a linha
		String[] linhaQuebrada2 = linhaQuebrada[1].split("t");// formantando a linha

		return new Jogador(linhaQuebrada2[0]);
	}

	// METODO PARA AUXILIAR NA INSERÇÃO DA LISTA SEM REPETIDOS
	private boolean buscaRepetidos(List<Jogo> jogos, Jogador jogador, int totalJogadores, int totalJogos) {
		boolean a = false;
		if (jogos.get(totalJogos).getJogadores().get(0).getNome().compareTo(jogador.getNome()) == 0) {
			return false;
		}
		for (int i = 0; i < jogos.get(totalJogos).getJogadores().size(); i++) {
			if (jogos.get(totalJogos).getJogadores().get(i).getNome().compareTo(jogador.getNome()) != 0) {
				a = true;
			} else {
				a = false;
			}
		}

		return a;
	}

	public void executar(int escolha) {

		File arquivo = new File("game.log");
		List<Jogo> jogos = new ArrayList<>();
		int totalJogos = 0;
		int totalJogadores = 0;
		List<Jogador> jogadores = new ArrayList<>();

		try {

			Scanner sc = new Scanner(arquivo);

			while (sc.hasNext()) {
				String linha = sc.nextLine();

				// COLHER AS INFORMÇÕES DE QUANDO O JOGO É INICIALIZADO DO LOG
				if (linha.contains("InitGame")) {
					jogos.add(JogoBuilder.build(totalJogos));

					jogadores.removeAll(jogadores);

				}
				// COLHER AS INFORMAÇÕES DOS JOGADORES DO LOG
				if (linha.contains("ClientUserinfoChanged:")) {
					Jogador jogador = trataJogador(linha);
					if (totalJogadores == 0) {

						jogos.get(totalJogos).getJogadores().add(jogador);
						totalJogadores++;

					} else {
						if (buscaRepetidos(jogos, jogador, totalJogadores, totalJogos) == true) {

							jogos.get(totalJogos).getJogadores().add(jogador);
							totalJogadores++;
						} else {

						}
					}
				}

				// COLHE AS INFORMAÇÕES DO KILL DO LOG
				if (linha.contains("Kill")) {

					jogos.get(totalJogos).setKillInGame( //
							jogos.get(totalJogos).getKillInGame() + 1 //
					);

					Kill kill = trataKill(linha);
					Jogador jogadorMatou = new Jogador(kill.getJogadorMatou());
					Jogador jogadorMorreu = new Jogador(kill.getJogadorMorreu());
					System.out.println(jogadorMatou + "  >  " + jogadorMorreu);
					if (jogadorMatou.getNome().compareTo("\\<world>") != 0) {
						if (jogos.get(totalJogos).getJogadores().get(0).getNome()
								.compareTo(jogadorMatou.getNome()) == 0) {
							jogos.get(totalJogos).getJogadores().get(0)
									.setKills(jogos.get(totalJogos).getJogadores().get(0).getKills() + 1);
						} else {
							for (int i = 0; i < jogos.get(totalJogos).getJogadores().size(); i++) {
								if (jogos.get(totalJogos).getJogadores().get(i).getNome()
										.compareTo(jogadorMatou.getNome()) == 0) {
									jogos.get(totalJogos).getJogadores().get(i)
											.setKills(jogos.get(totalJogos).getJogadores().get(i).getKills() + 1);

								}
							}
						}

					}
					if (jogos.get(totalJogos).getJogadores().get(0).getNome().compareTo(jogadorMorreu.getNome()) == 0) {
						jogos.get(totalJogos).getJogadores().get(0)
								.setKills(jogos.get(totalJogos).getJogadores().get(0).getKills() - 1);
					} else {
						for (int i = 0; i < jogos.get(totalJogos).getJogadores().size(); i++) {
							if (jogos.get(totalJogos).getJogadores().get(i).getNome()
									.compareTo(jogadorMorreu.getNome()) == 0) {
								jogos.get(totalJogos).getJogadores().get(i)
										.setKills(jogos.get(totalJogos).getJogadores().get(i).getKills() - 1);

							}
						}
					}
				}

				// COLHER AS INFORMÇÕES DE QUANDO O JOGO É FINALIZADO DO LOG
				if (linha.contains("ShutdownGame")) {
					System.out.println("\n");
					totalJogadores = 0;
					totalJogos++;

				}

			}

			sc.close();
			new Print();
			// Print.imprimir(escolha, jogos);
			System.out.print(jogos);

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não foi encontrado.");
		}

	}

}
