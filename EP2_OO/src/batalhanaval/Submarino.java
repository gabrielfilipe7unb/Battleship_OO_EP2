package batalhanaval;

//Implementa a embarcação Submarino.

//Ocupa 1 blocos e existem 5 no Tabuleiro

public class Submarino implements Navio{
	
	private int qtdDeNavios;
	private int tamanhoNavio = 1;	
	private String nomeNavio = "Submarino";
	
	Submarino (int qtd){
		this.setQtdDeNavios(qtd);
	}
	
	public void setQtdDeNavios(int qtdDeNavios) {
		this.qtdDeNavios = qtdDeNavios;
	}
	
	@Override
	public int getTamanhoNavio() {
		return tamanhoNavio;
	}
	@Override
	public int getQtdDeNavios() {
		return qtdDeNavios;
	}
	@Override
	public String getNomeNavio(){
		return nomeNavio;
	}
}