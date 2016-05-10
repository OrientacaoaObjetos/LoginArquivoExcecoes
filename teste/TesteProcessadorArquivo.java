import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Test;

public class TesteProcessadorArquivo {

	@Test
	public void arquivoLidoSucesso() throws LeituraArquivoException {
		Map<String, String> map = ProcessadorArquivo.processar("dados.txt");
		assertEquals(!map.isEmpty(), Boolean.TRUE);
	}
	
	public void arquivoInexistente(){
		try {
			ProcessadorArquivo.processar("dados1.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertTrue(e.getMessage().startsWith("Erro ao abrir o arquivo"));
		}
	}
	
	@Test()
	public void arquivoVazio() {
		try {
			ProcessadorArquivo.processar("dadosVazio.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Arquivo Vazio.", e.getMessage());
		}
	}
	
	@Test()
	public void arquivoFormatoInvalido() {
		try {
			ProcessadorArquivo.processar("dadosFormatoInvalido.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Formato Inválido.", e.getMessage());
		}
	}
	
	@Test
	public void arquivoFormatoSemSeparador() {
		try {
			ProcessadorArquivo.processar("dadosSemSeparador.txt");
			fail();
		} catch (LeituraArquivoException e) {
			assertEquals("Formato Inválido.", e.getMessage());
		}
	}
}
