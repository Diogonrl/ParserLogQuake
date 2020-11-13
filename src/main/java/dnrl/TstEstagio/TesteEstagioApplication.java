package dnrl.TstEstagio;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import dnrl.TstEstagio.parse.ParseFile;

@SpringBootApplication
public class TesteEstagioApplication {

	public static void main(String[] args) {
		new ParseFile().executar();
	}

}
