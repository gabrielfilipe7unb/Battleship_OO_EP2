package batalhanaval;

//Implementa os testes dos métodos da classe Jogo.

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class JogoTest {
	
	Jogo jogo;
	int[][] vetor = new int[10][10];	
	
	 // Método de configuração que lança exceção para possíveis erros e instancia a classe Jogo.
	
	@Before
	public void setUp() throws Exception{ // Exception Lança exceção de erro durante a execução dos testes.
		jogo = new Jogo();
	}
	
	 // Método de teste que testa se o retorno do método cabeNavio é falso.

	@Test
	public void testCabeNavioFalse(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		assertEquals(false, jogo.cabeNavio(3, 7, 1, 5, vetor)); // Parâmetro: valores que estouram o limite da matriz, retornando falso.

	}
	
	//Método de teste que testa se o retorno do método cabeNavio é verdadeiro.
	@Test
	public void testCabeNavioTrue(){
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		assertEquals(true, jogo.cabeNavio(3, 2, 1, 3, vetor)); // Nesse caso é testado se o funcionamento está consistente, passando um vetor vazio e as posições dentro do limites da matriz.
		
	}
}
