package batalhanaval;

//Contém o método main e inicializa a Tela Inicial. O método
//cria uma Thread que inicializa a tela inicial e configura
//a visibilidade do frame.

import javax.swing.SwingUtilities;
import telas.TelaInicial;

public class Principal {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaInicial telaInicial = new TelaInicial();
				telaInicial.setVisible(true);
			}
		});		
	}

}
