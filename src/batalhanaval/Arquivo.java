package batalhanaval;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Arquivo extends JFrame{
    
	private int altura;
    private int largura;
    
    private int qtdNavio[] = new int [3];
    
    public Arquivo(){
    }
    
    public int[] getqtdNavio() {
    	return this.qtdNavio;
	}
    
    public void setQtdNavio(int[] qtdNavio) {
		this.qtdNavio = qtdNavio;
	}
    
    public void setLargura(int largura){
        this.largura = largura;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    
    public int getLargura(){
        return this.largura;
    }
    public int getAltura(){
        return this.altura;
    }
    
    public void abreArquivo(){
        JFileChooser seletor = new JFileChooser();
        
        int retornarValor = seletor.showOpenDialog(this);
        int contador = 0;

        if(retornarValor == JFileChooser.APPROVE_OPTION){
            File arquivo = seletor.getSelectedFile();
            
            try {
                FileReader leitorArquivo = new FileReader( arquivo.getAbsolutePath() );
                BufferedReader lerArquivo = new BufferedReader(leitorArquivo);
                
                int i = 0, k = 0;
                String linha = lerArquivo.readLine();
                contador++;
                
                while (linha != null) {
                    if(contador == 2){
                        String[] separadorDeTexto = linha.split(" ");
                        this.largura = Integer.parseInt(separadorDeTexto[0]);
                        this.altura = Integer.parseInt(separadorDeTexto[1]);
                    }
                    
                    
                    if(contador >= 4){
                        this.qtdNavio[k] = Integer.parseInt(linha);
                        k++;  
                    }
                    
                    linha = lerArquivo.readLine();
                    contador++;
                }
          
                leitorArquivo.close();
                
            }catch (IOException ex) {
                System.out.println("problem accessing file" + arquivo.getAbsolutePath());
            }
                
        } else  if(retornarValor == JFileChooser.CANCEL_OPTION){
        	int vetor[] = {2,2,2};
        	setAltura(10);
        	setLargura(10);
        	setQtdNavio(vetor);
        }
    }
}
