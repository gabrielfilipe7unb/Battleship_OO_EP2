package batalhanaval;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Pontuacao {
	
	private static Pontuacao instancia;	
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	//Construtor vazio para implementação do padrão Singleton.
	public Pontuacao(){
	}
	
	//Padrão Singleton para instanciar apenas uma Pontuação
	public static synchronized Pontuacao getInstance(){
		if (instancia == null) {
			instancia = new Pontuacao();
		}
		//Variável estática instância.
		return instancia;
	}	
	
	//Método que adiciona objetos do tipo Jogador na Lista
	public void adicionaJogador(Jogador jogador){
		jogadores.add(jogador);
	}
	
	public void salvaLista(){
		
		ArrayList<Jogador> arquivo = getJogadores();
		
		if (arquivo != null && !arquivo.isEmpty()){
			try {
				
				FileOutputStream file = new FileOutputStream("ranking.txt");
				
				ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("ranking.txt"));
				
				//Concatena as listas de jogadores
			
				stream.close();
				file.close();
				
			} catch (Exception e){
				System.out.println("Erro ao acessar o arquivo.");
			}
		}
		
		// Se o arquivo estiver vazio, cria um novo e preenche com a lista de jogadores
		try {
			FileOutputStream file = new FileOutputStream("ranking.txt");
			ObjectOutputStream stream = new ObjectOutputStream(file);
			stream.writeObject(jogadores);
			stream.close();
			file.close();
		} catch (Exception e){
			System.out.println("Erro ao acessar o arquivo.");
		}
	}

	//Busca a lista de jogadores no arquivo.
	//Utiliza o método salvaLista para verificar se existe lista já
	//persistida no arquivo, se não houver ele retorna uma lista null
	@SuppressWarnings("unchecked")
	public ArrayList<Jogador> getJogadores(){
		ArrayList<Jogador> jog = null;
		try {
			FileInputStream file = new FileInputStream("ranking.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			jog = (ArrayList<Jogador>) in.readObject();
			in.close();
			file.close();
		} catch (Exception e){
		}
		//Retorna a lista de jogadores buscada no arquivo, se não existir retorna null.
		return jog;
	}
}

