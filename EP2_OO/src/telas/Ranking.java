package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import batalhanaval.Jogador;
import batalhanaval.ListaInvalidaException;
import batalhanaval.Pontuacao;
import java.awt.Font;
import java.awt.TextArea;

public class Ranking extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	// Criando painel para receber elementos
	private JPanel contentPane = new JPanel();
	// Criação do botão voltar
	private JButton voltar = new JButton("Voltar");
	//Criação da label Título
	private JLabel labelTitulo = new JLabel("RANK");
	//Criação da label Player
	private JLabel labelNome = new JLabel("PLAYER");
	//Criação da label Pontos
	private JLabel labelPontuacao = new JLabel("PONTOS");
	
	TextArea textArea = new TextArea();
	
	//Construtor da classe Ranking que cria os elementos gráficos da janela.
	public Ranking() {
		
		// Configura o nome da Janela
		setTitle("Ranking");
		// Retira a opção de redimensionar a janela
		setResizable(false);
		// Configura o fechamento da janela
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Configura o tamanho da janela
		setBounds(100, 100, 507, 409);
		// Centralizando a tela quando iniciada
		setLocationRelativeTo(null);
		// Retira o layout do painel
		contentPane.setLayout(null);
		// Seta o painel como painel do frame
		setContentPane(contentPane);
		
		// Botão voltar
		voltar.setBounds(396, 332, 95, 31);
		voltar.addActionListener(this);
		contentPane.add(voltar);
		
		// Label título
		labelTitulo.setFont(new Font("Verdana", Font.BOLD, 30));
		labelTitulo.setBounds(210, 20, 300, 29);
		contentPane.add(labelTitulo);		
		
		// Label Nome
		labelNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelNome.setBounds(40, 80, 300, 29);
		contentPane.add(labelNome);	
		
		// Label Pontuação
		labelPontuacao.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelPontuacao.setBounds(183, 80, 300, 29);
		contentPane.add(labelPontuacao);	
		
		// Configurando o tamnho da área de texto e adicionando no painel
		textArea.setBounds(10, 110, 486, 200);
		contentPane.add(textArea);
		
		// Criação da lista com o ranking, buscando direto do arquivo
		ArrayList<Jogador> jogadores = new Pontuacao().getJogadores();
		
		try {
			verificaLista(jogadores);
			
			// Ordenando os jogadores por maior pontuação com o metédo compareTo()
			Collections.sort(jogadores);
			
			// Criação de uma StringBuilder para concatenar todos os jogadores em uma String
			StringBuilder ranking = new StringBuilder();
			
			// Montagem da StringBuilder
			ranking.append("\n");
			
			for (Jogador jog : jogadores){
				ranking.append("        " + jog.getNome() + " 		" + jog.getPontuacao() + "\n");		
			}
			
			// Criação da String final que recebe o ranking completo e mostra na TextArea
			String rankingFinal = ranking.toString();
			textArea.setText(rankingFinal);	
			
		} catch (ListaInvalidaException e){
			System.out.println(e.getMessage());
		}			
	}
	
	//Verifica se a lista está vazia ou nula e lança exceção personalizada.
	public void verificaLista(ArrayList<Jogador> jogadores) throws ListaInvalidaException{
		if (jogadores == null || jogadores.isEmpty()){
			throw new ListaInvalidaException("O arquivo está vazio!");
		}
	}

	//O botão Voltar fecha a janela do ranking e retorna para a Tela Inicial
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == voltar){
			
			this.dispose();
			
			}
		}
	}

