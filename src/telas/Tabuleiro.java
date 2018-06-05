package telas;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import batalhanaval.Jogador;
import batalhanaval.Jogo;
import batalhanaval.Pontuacao;
import batalhanaval.Arquivo;

public class Tabuleiro extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private int altura;
	private int largura;
	private int[] qtdNavio;
	private boolean atqLinha = false;
	private boolean atqColuna = false;
	private boolean atq2x2 = false;
	private boolean atqNormal = true;
	private boolean atqMostrar2x2 = false;

	// Painéis
	JPanel grid = new JPanel();
	JPanel jContentPane = new JPanel();
	Container cp;

	// Botões
	JButton[][] Botoes;
	JButton novo = new JButton("Novo Jogo");
	JButton voltar = new JButton("Voltar");
	JButton ataqueColuna = new JButton("Atacar coluna!");
	JButton ataqueLinha = new JButton("Atacar linha!");
	JButton ataque2x2 = new JButton("Atacar 2x2!");
	JButton ataqueNormal = new JButton("Atacar Normal!");
	JButton mostrar2x2 = new JButton("Espionar 2x2!");

	// Labels
	JLabel naviosRestantes = new JLabel("Navios Restantes");
	JLabel tirosRestantes = new JLabel("Tiros Restantes");
	JLabel contNavios = new JLabel("");
	JLabel contTiros = new JLabel("");
	JLabel especiaisRestantes = new JLabel("Tiros Especiais");
	JLabel contEspecial = new JLabel("");

	int contadorNavio;
	int contadorTiro;
	int contadorEspecial = 3;

	// Vetor que fica por trás dos Botões e guarda água (0) ou navios
	private int vetor[][];
	int pontuacao = 0;
	String nomeJogador;

	// Instanciando classe jogo que preenche o vetor e distribui os navios
	Arquivo arquivo = new Arquivo();
	Jogo jogo = new Jogo();
	Jogador jogador = new Jogador();
	Pontuacao pontos = Pontuacao.getInstance();

	public Tabuleiro(String nomeJogador) {

		arquivo.abreArquivo();
		this.altura = arquivo.getAltura();
		this.largura = arquivo.getLargura();
		this.qtdNavio = arquivo.getqtdNavio();
		this.vetor = new int[altura][largura];

		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor[0].length; j++) {
				vetor[i][j] = 0;
			}
		}

		this.contadorNavio = 0;

		for (int i = 0; i < qtdNavio.length; i++) {
			this.contadorNavio += qtdNavio[i] * (i + 1);
		}
		this.contadorTiro = contadorNavio * 2;

		setTitle("Batalha Naval");

		setSize(657, 415);

		setLocationRelativeTo(null);

		setResizable(false);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setContentPane(jContentPane);
		cp = getContentPane();
		cp.setLayout(null);

		this.Botoes = new JButton[vetor.length][vetor[0].length];

		grid.setBounds(3, 58, 497, 325);
		grid.setLayout(new GridLayout(vetor.length, vetor[0].length, 2, 2));

		for (int linha = 0; linha < this.vetor.length; linha++) {
			for (int coluna = 0; coluna < this.vetor[0].length; coluna++) {
				Botoes[linha][coluna] = new JButton("");
				Botoes[linha][coluna].addActionListener(this);
				Botoes[linha][coluna].setFocusable(false);
				grid.add(Botoes[linha][coluna]);
			}
		}

		// Botão Novo Jogo
		novo.setBounds(7, 14, 96, 35);
		novo.setFocusable(false);
		novo.addActionListener(this);

		// Botão Voltar
		voltar.setBounds(398, 14, 96, 35);
		voltar.setFocusable(false);
		voltar.addActionListener(this);

		ataqueColuna.setBounds(500, 80, 150, 35);
		ataqueColuna.setFocusable(false);
		ataqueColuna.addActionListener(this);

		ataqueLinha.setBounds(500, 130, 150, 35);
		ataqueLinha.setFocusable(false);
		ataqueLinha.addActionListener(this);

		ataque2x2.setBounds(500, 180, 150, 35);
		ataque2x2.setFocusable(false);
		ataque2x2.addActionListener(this);

		ataqueNormal.setBounds(500, 230, 150, 35);
		ataqueNormal.setFocusable(false);
		ataqueNormal.addActionListener(this);

		mostrar2x2.setBounds(500, 280, 150, 35);
		mostrar2x2.setFocusable(false);
		mostrar2x2.addActionListener(this);

		// Label Navios Restantes
		naviosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
		naviosRestantes.setBounds(120, 10, 150, 18);

		// Label Tiros Restantes
		tirosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
		tirosRestantes.setBounds(272, 10, 118, 18);

		// Contador Navios Restantes
		contNavios.setFont(new Font("Roboto", Font.BOLD, 18));
		contNavios.setBounds(170, 28, 300, 26);
		contNavios.setText("" + contadorNavio);

		// Contaddor Tiros Restantes
		contTiros.setFont(new Font("Roboto", Font.BOLD, 18));
		contTiros.setBounds(320, 28, 300, 26);
		contTiros.setText("" + contadorTiro);

		// Label Especial Restantes
		especiaisRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
		especiaisRestantes.setBounds(520, 10, 300, 18);

		// Contador Tiros Especiais
		contEspecial.setFont(new Font("Roboto", Font.BOLD, 18));
		contEspecial.setBounds(560, 30, 300, 26);
		contEspecial.setText("" + contadorEspecial);

		// Adicionando os elementos no Container
		cp.add(grid);
		cp.add(novo);
		cp.add(voltar);
		cp.add(ataqueLinha);
		cp.add(ataqueColuna);
		cp.add(ataque2x2);
		cp.add(naviosRestantes);
		cp.add(tirosRestantes);
		cp.add(contNavios);
		cp.add(contTiros);
		cp.add(ataqueNormal);
		cp.add(contEspecial);
		cp.add(especiaisRestantes);
		cp.add(mostrar2x2);

		jogo.iniciaJogo(vetor, this.qtdNavio);
		// Passando o nome do jogador que está jogando para o objeto Jogador
		jogador.setNome(nomeJogador);
	}

	public void tiroNaAgua(int linha, int coluna) {
		// Configura a imagem da água
		Botoes[linha][coluna].setIcon(new ImageIcon(Tabuleiro.class.getResource("agua.gif")));

		// Configura a imagem para o botão desabilitado
		Botoes[linha][coluna].setDisabledIcon(new ImageIcon(Tabuleiro.class.getResource("agua.gif")));

		// Desabilita o botão já clicado para não continuar pontuando
		Botoes[linha][coluna].setEnabled(false);
	}

	public void tiroNoNavio(int linha, int coluna) {
		// Configura a imagem de navio destruído
		Botoes[linha][coluna].setIcon(new ImageIcon(Tabuleiro.class.getResource("expod.gif")));

		// Configura a imagem para o botão desabilitado
		Botoes[linha][coluna].setDisabledIcon(new ImageIcon(Tabuleiro.class.getResource("expod.gif")));

		// Desabilita o botão já clicado para não continuar pontuando
		Botoes[linha][coluna].setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Função do botão Voltar
		if (e.getSource() == voltar) {
			pontos.salvaLista();
			this.dispose();
		}

		if (e.getSource() == ataqueLinha) {
			if (contadorEspecial > 0) {
				this.atqLinha = true;
				this.atq2x2 = false;
				this.atqColuna = false;
				this.atqNormal = false;
				this.atqMostrar2x2 = false;
			}

		}

		if (e.getSource() == ataqueColuna) {
			if (contadorEspecial > 0) {
				this.atqLinha = false;
				this.atq2x2 = false;
				this.atqColuna = true;
				this.atqNormal = false;
				this.atqMostrar2x2 = false;
			}
		}

		if (e.getSource() == ataque2x2) {
			if (contadorEspecial > 0) {
				this.atqLinha = false;
				this.atq2x2 = true;
				this.atqColuna = false;
				this.atqNormal = false;
				this.atqMostrar2x2 = false;
			}

		}

		if (e.getSource() == mostrar2x2) {
			if (contadorEspecial > 0) {
				this.atqLinha = false;
				this.atq2x2 = false;
				this.atqColuna = false;
				this.atqNormal = false;
				this.atqMostrar2x2 = true;
			}

		}

		if (e.getSource() == ataqueNormal) {
			this.atqLinha = false;
			this.atq2x2 = false;
			this.atqColuna = false;
			this.atqNormal = true;
			this.atqMostrar2x2 = false;

		}
		// Função dos botões do Tabuleiro
		for (int linha = 0; linha < vetor.length; linha++) {
			for (int coluna = 0; coluna < vetor[0].length; coluna++) {

				// Quando um Botão é clicado
				if (e.getSource() == Botoes[linha][coluna]) {
					// Decrementando o número de tiros restantes
					--contadorTiro;
					contTiros.setText("" + contadorTiro);

					if (atqLinha == true) {
						contEspecial.setText("" + --contadorEspecial);
						atqLinha = false;
						atqNormal = true;
						for (int i = 0; i < vetor[0].length; i++) {
							if (vetor[linha][i] == 0) {

								tiroNaAgua(linha, i);
							}

							// Se não for 0, mostra a imagem de navio destruído
							else if (vetor[linha][i] != 0) {

								tiroNoNavio(linha, i);

								// Decrementa o contador de navios restantes e incrementa a pontuação
								contNavios.setText("" + --contadorNavio);
								pontuacao++;
							}
						}
					} else if (atqColuna == true) {
						contEspecial.setText("" + --contadorEspecial);
						atqColuna = false;
						atqNormal = true;
						for (int i = 0; i < vetor.length; i++) {
							if (vetor[i][coluna] == 0) {

								tiroNaAgua(i, coluna);
							}

							// Se não for 0, mostra a imagem de navio destruído
							else if (vetor[i][coluna] != 0) {

								tiroNoNavio(i, coluna);

								// Decrementa o contador de navios restantes e incrementa a pontuação
								contNavios.setText("" + --contadorNavio);
								pontuacao++;
							}
						}
					} else if (atq2x2 == true) {
						contEspecial.setText("" + --contadorEspecial);
						atq2x2 = false;
						atqNormal = true;
						for (int k = 0; k < 2; k++) {
							for (int i = 0; i < 2; i++) {
								if (linha + k < vetor.length && coluna + i < vetor[0].length) {

									if (vetor[linha + k][coluna + i] == 0) {

										tiroNaAgua(linha + k, coluna + i);
									}

									// Se não for 0, mostra a imagem de navio destruído
									else if (vetor[linha + k][coluna + i] != 0) {

										tiroNoNavio(linha + k, coluna + i);

										// Decrementa o contador de navios restantes e incrementa a pontuação
										contNavios.setText("" + --contadorNavio);
										pontuacao++;
									}
								}
							}
						}
					} else if (atqMostrar2x2 == true) {
						contEspecial.setText("" + --contadorEspecial);
						atqMostrar2x2 = false;
						atqNormal = true;
						for (int k = 0; k < 2; k++) {
							for (int i = 0; i < 2; i++) {
								if (linha + k < vetor.length && coluna + i < vetor[0].length) {

									if (vetor[linha + k][coluna + i] == 0) {

										Botoes[linha + k][coluna + i]
												.setIcon(new ImageIcon(Tabuleiro.class.getResource("aguadetec.gif")));

									}

									// Se não for 0, mostra a imagem de navio destruído
									else if (vetor[linha + k][coluna + i] != 0) {

										Botoes[linha + k][coluna + i]
												.setIcon(new ImageIcon(Tabuleiro.class.getResource("explodetec.gif")));

									}
								}
							}
						}

					} else if (atqNormal == true) {

						// Se for 0, acerta a água e mostra vazio
						if (vetor[linha][coluna] == 0) {

							tiroNaAgua(linha, coluna);
						}

						// Se não for 0, mostra a imagem de navio destruído
						else if (vetor[linha][coluna] != 0) {

							tiroNoNavio(linha, coluna);

							// Decrementa o contador de navios restantes e incrementa a pontuação
							contNavios.setText("" + --contadorNavio);
							pontuacao++;
						}
					}

					if (contadorNavio == 0) {
						// Mostra mensagem caso o jogador vença
						JOptionPane.showMessageDialog(this, "Parabéns, VOCÊ GANHOU! ", "Fim de Jogo",
								JOptionPane.INFORMATION_MESSAGE);

						// Grava a pontuação no objeto Jogador
						jogador.setPontuacao(pontuacao);

						// Salva jogador no Arraylist
						pontos.adicionaJogador(jogador);
						pontos.salvaLista();
						// Reinicia o jogo
						this.dispose();

					}

					if (contadorTiro == 0) {
						// Mostra mensagem de fim de jogo
						JOptionPane.showMessageDialog(this, "Fim de Jogo. Sua pontuação: " + pontuacao, "Fim de Jogo",
								JOptionPane.INFORMATION_MESSAGE);

						// Grava a pontuação no objeto Jogador
						jogador.setPontuacao(pontuacao);

						// Salva jogador no Arraylist
						pontos.adicionaJogador(jogador);
						pontos.salvaLista();
						// Reinicia o jogo
						this.dispose();

					}
				}
			}

			// Função do botão Novo Jogo
			if (e.getSource() == novo) {
				// Fecha a janela
				this.dispose();

				// Cria um novo tabuleiro e seta a visibilidade
				Tabuleiro tabuleiro = new Tabuleiro(jogador.getNome());
				tabuleiro.setVisible(true);

				// Mostra mensagem de Jogo Reiniciado
				JOptionPane.showMessageDialog(this, "Jogo reiniciado!", "Novo Jogo", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
