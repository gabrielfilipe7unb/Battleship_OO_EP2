package batalhanaval;

//Implementa a embarcação Fragata.

//Ocupa 3 blocos e existem 3 no Tabuleiro
public class Fragata implements Navio {
	
	private int qtdDeNavios;
	private int tamanhoNavio = 2;
	private String nomeNavio = "Fragata";
	
	Fragata (int qtd){
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
