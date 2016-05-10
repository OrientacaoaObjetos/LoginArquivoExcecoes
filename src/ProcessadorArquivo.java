import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class ProcessadorArquivo {
	
	@SuppressWarnings("resource")
	public static Map<String, String> processar(String arquivo) throws LoginException {
		
		Map<String, String> mapDados = new HashMap<>();
		File file = null;
		Scanner sc = null;
		
		try {
			file = new File(arquivo);
			sc = new Scanner(file);
		} catch (Exception e) {
			throw new LoginException("Erro ao abrir o arquivo: \n" + e);
		} 
		
		if (!sc.hasNextLine()) {
			throw new LoginException("Arquivo Vazio.");
		}
		
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (!s.contains("->")){
				throw new LoginException("Formato Inválido.");
			} else { 
				
				String[] palavras = s.split("->");
				
				if (palavras.length > 2) {
					throw new LoginException("Formato Inválido.");
				}
				
				mapDados.put(palavras[0], palavras[1]);
			}
		}
		
		return mapDados;
		
	}
}
