package batalhanaval;

//Implementa a embarcação Destroyer.

//Ocupa 5 blocos e existem 1 no Tabuleiro

public class Destroyer implements Navio {
	
	private int qtdDeNavios;
	private int tamanhoNavio = 3;
	private String nomeNavio = "Destroyer";
	
	Destroyer (int qtd){
		this.setQtdDeNavios(qtd);
	}
	
	public void setQtdDeNavios(int qtdDeNavios) {
		this.qtdDeNavios = qtdDeNavios;
	}
	
	@Override
	public int getQtdDeNavios() {
		return qtdDeNavios;
	}
	@Override
	public int getTamanhoNavio() {
		return tamanhoNavio;
	}
	@Override
	public String getNomeNavio(){
		return nomeNavio;
	}
}
