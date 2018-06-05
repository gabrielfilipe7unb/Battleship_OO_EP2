package telas;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	

	private JPanel contentPane = new JPanel();
		

	private JTextField caixaDeTexto = new JTextField(20);

	private JButton iniciarJogo = new JButton("Iniciar Jogo");
	private JButton fecharJogo = new JButton("Fechar Jogo");
	private JButton ranking = new JButton("Ranking");
	

	private JLabel labelBatalhaNaval = new JLabel("Batalha Naval");
	private JLabel labelUsuario = new JLabel("PLAYER NAME");


	public TelaInicial() {
		
		
		setTitle("Batalha Naval");

		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 507, 409);		
		
		contentPane.setBorder(null);

		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		caixaDeTexto.setBounds(140, 155, 223, 29);		
		contentPane.add(caixaDeTexto);	
		
		labelBatalhaNaval.setFont(new Font("Roboto", Font.BOLD, 40));
		labelBatalhaNaval.setBounds(110, 45, 300, 29);
		contentPane.add(labelBatalhaNaval);
		
		labelUsuario.setFont(new Font("Roboto", Font.BOLD, 16));
		labelUsuario.setBounds(190, 110, 200, 40);
		contentPane.add(labelUsuario);
			
		iniciarJogo.setBounds(195, 200, 111, 36);
		iniciarJogo.setFont(new Font("Verdana", Font.BOLD, 12));		
		iniciarJogo.addActionListener(this);		
		contentPane.add(iniciarJogo);
		
		ranking.setFont(new Font("Verdana", Font.BOLD, 12));
		ranking.setBounds(1, 238, 111, 36);
		ranking.setFocusable(false);
		ranking.addActionListener(this);
		contentPane.add(ranking);

		fecharJogo.setBounds(386, 238, 120, 36);
		fecharJogo.setFont(new Font("Verdana", Font.BOLD, 12));
		fecharJogo.setFocusable(false);		
		fecharJogo.addActionListener(this);		
		contentPane.add(fecharJogo);
		
		setLocationRelativeTo(null);
		
		getRootPane().setDefaultButton(iniciarJogo);
		
	}

	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == iniciarJogo){
			

			String nomeJogador = caixaDeTexto.getText();
			
		
			if (nomeJogador.equals("")){
				JOptionPane.showMessageDialog(null, "Insira um player válido!");
			}
			
			if (!(nomeJogador.equals(""))){
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {						
						Tabuleiro tabuleiro = new Tabuleiro(nomeJogador);
						tabuleiro.setVisible(true);						
					}
				});				
				
				caixaDeTexto.setText("");
			}			
		}
		

		if (e.getSource() == fecharJogo){
			
			System.exit(0);
		}
		
		if (e.getSource() == ranking){
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Ranking ranking = new Ranking();
					ranking.setVisible(true);					
				}
			});
		}
	}
}
