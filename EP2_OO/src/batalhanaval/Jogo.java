package batalhanaval;

import java.util.ArrayList;
import java.util.Random;


public class Jogo {
	
	private Random generate = new Random();
	
	//Distribui as embarcações no tabuleiro.
	//A posição de cada navio no tabuleiro é gerada randomicamente e armazenada nas variáveis linha e coluna.
	//Uma lista com os navios é criada e todas as posições do tabuleiro são preenchidas com 0 (água).
	//A orientação dos navios é gerada randomicamente e o método cabeNavio verifica se existe espaço.
	//Caso exista, os navios serão distribuídos, se não, novas posições são geradas.

	public void iniciaJogo(int[][] vetor, int[] qtdNavio){		
		// Cria a posição do navio no tabuleiro
		int linha = generate.nextInt(vetor.length); // Linha
		int coluna = generate.nextInt(vetor[0].length); // Coluna
		boolean cabe = false;
		
		// Criando ArrayList com navios
		ArrayList<Navio> navios = new ArrayList<>();
		
		// Adicionando navios na Lista
		navios.add(new Destroyer(qtdNavio[2]));
		navios.add(new Fragata(qtdNavio[1]));
		navios.add(new Submarino(qtdNavio[0]));
		
		// Preenche o vetor com Zeros (0)
		for (int i = 0; i < vetor.length; i++){
			for (int j = 0; j < vetor[0].length; j++){
				vetor[i][j] = 0;
			}
		}
		
		for(int cont = 0; cont < navios.size(); cont++){
			int contador = 0;
			while(navios.get(cont).getQtdDeNavios() > contador) {				
				
				// Cria a orientação do Navio. 0 Vertical. 1 Horizontal
				int orientacao = generate.nextInt(2);

				// Verifica se o navio cabe na posição do tabuleiro criada
				cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
				
				// Se o Navio não couber, gera outra posição
				if(cabe == false){
					while(cabe == false){
						linha = generate.nextInt(vetor.length); // Linha
						coluna = generate.nextInt(vetor[0].length); // Coluna
						cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
					}
				}
				
				// Se o Navio couber, distribui os navios 
				if (orientacao == 0){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						linha++;
					}
				}
				
				else if (orientacao == 1){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						coluna++;
					}
				}
				contador++;
			}
		}
	}
	
	//Verifica se o navio pode ser distribuído na posição gerada randomicamente.
	
	// O tabuleiro é distribuído como uma matriz, com linhas e colunas, os navios maiores precisam
	// estar distribuídos dentro dos limites do tabuleiro e em posições vazias, onde não existam navios
	// já distribuídos.
	 
	 //orientacao: Orientação do navio.
	 //tamanho: Tamanho de blocos que o navio ocupa.

	public boolean cabeNavio(int linha, int coluna, int orientacao, int tamanho, int vetor[][]){
		
		// Se a orientação for Vertical, trava a coluna e incrementa a linha
		
		if (orientacao == 0){
			if (linha > (vetor.length-1 - tamanho)){
				return false;
			}
			for (int row = 0; row < tamanho; row++){
				if (vetor[linha][coluna] == 0){
					linha++;
				}
				else {
					return false;//Se navio não couber
				}
			}
			return true; //Se navio couber
		}

		// Se a orientação for Horizontal, trava a linha e incrementa a coluna
		
		if (orientacao == 1){
			if (coluna > (vetor[0].length-1 - tamanho)){
				return false;
			}
			for (int col = 0; col < tamanho; col++){
				if (vetor[linha][coluna] == 0){
					coluna++;
				}
				else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
