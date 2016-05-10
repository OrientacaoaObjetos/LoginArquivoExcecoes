import static org.junit.Assert.*;

import java.util.Map;

import javax.security.auth.login.LoginException;

import org.junit.Test;

public class TesteProcessadorArquivo {

	@Test
	public void arquivoLidoSucesso() throws LoginException {
		Map<String, String> map = ProcessadorArquivo.processar("dados.txt");
		assertEquals(!map.isEmpty(), Boolean.TRUE);
	}
	
	@Test(expected = LoginException.class)
	public void arquivoInexistente() throws LoginException {
		ProcessadorArquivo.processar("dados1.txt");
	}
	
	@Test(expected = LoginException.class)
	public void arquivoVazio() throws LoginException {
		ProcessadorArquivo.processar("dadosVazio.txt");
	}
	
	@Test(expected = LoginException.class)
	public void arquivoFormatoInvalido() throws LoginException {
		ProcessadorArquivo.processar("dadosFormatoInvalido.txt");
	}

}
