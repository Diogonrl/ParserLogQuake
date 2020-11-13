package dnrl.TstEstagio;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import dnrl.TstEstagio.parse.ParseFile;

@SpringBootApplication
public class TesteEstagioApplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o numero do jogo, se for 0 irá mostrar todos");
		int escolha = in.nextInt();
		new ParseFile().executar(escolha);
	}

}
