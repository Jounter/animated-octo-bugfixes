package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import pt.ipleiria.estg.dei.gridpanel.GridPanel;

import model.Jogo;

public class JanelaCradle extends JFrame {

	private JPanel contentPane;
	private JLabel lblPontuacao;
	private GridPanel gridPainelPrincipal;
	private GridPanel gridPainelBonus;
	private JPanel jPanePainelVida;
	private Thread novaThread;
	private Jogo jogo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCradle frame = new JanelaCradle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaCradle() {
		setTitle("Jogo do Cradle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel() {
			protected void paintComponent(java.awt.Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(JanelaCradle.class
							.getResource("/imagens/fundo0.jpg")), 0, 0, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Painel Pontuaçao
		JPanel panelPontos = new JPanel();
		panelPontos.setBackground(Color.red);
		contentPane.add(panelPontos, BorderLayout.NORTH);
		
		JLabel lblPontuacaoTexto = new JLabel("Pontuação: ");
		lblPontuacaoTexto.setForeground(Color.orange);
		panelPontos.add(lblPontuacaoTexto);
		
		lblPontuacao = new JLabel("0");
		lblPontuacao.setForeground(Color.yellow);
		panelPontos.add(lblPontuacao);

		//Painel Principal
		gridPainelPrincipal = new GridPanel();
		gridPainelPrincipal.setRowSize(40);
		gridPainelPrincipal.setColumnSize(40);
		gridPainelPrincipal.setShowGridLines(false);
		gridPainelPrincipal.setColumns(18);
		contentPane.add(gridPainelPrincipal, BorderLayout.CENTER);
		
		//Painel Bonus
		gridPainelBonus = new GridPanel();
		gridPainelBonus.setRows(1);
		gridPainelBonus.setRowSize(80);
		gridPainelBonus.setColumnSize(80);
		gridPainelBonus.setShowGridLines(false);
		gridPainelBonus.setColumns(2);
		contentPane.add(gridPainelBonus, BorderLayout.SOUTH);
		
		//PainelVida
		jPanePainelVida = new JPanel() {
			protected void paintComponent(java.awt.Graphics g) {
				super.paintComponent(g);
				try {
					g.drawImage(ImageIO.read(JanelaCradle.class
							.getResource("/imagens/vida_"+ jogo.atualizarVida() +".png")), 0, 0, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		jPanePainelVida.setPreferredSize(new Dimension(200, 10));
		jPanePainelVida.setOpaque(false);
		contentPane.add(jPanePainelVida, BorderLayout.EAST);

		jogo = new Jogo(gridPainelPrincipal, gridPainelBonus, jPanePainelVida);

		novaThread = new Thread() {
			public void run() {
				while (true) {
					try {
						jogo.iterar();
						sleep(1000);
						gridPainelPrincipal.repaint();
						gridPainelBonus.repaint();
						jPanePainelVida.repaint();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		novaThread.start();
	}
}
