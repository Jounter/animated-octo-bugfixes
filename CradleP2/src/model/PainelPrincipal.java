package model;

import java.util.logging.FileHandler;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelPrincipal extends Iteravel {
	private Grelha[][] grelha;
	private Jogo jogo;
	private GridPanel gridPanel;
	private Elemento[][] elementos;
	private static final String BLOCO = "B";
	private static final String PAREDE = "P";

	public PainelPrincipal(GridPanel gridPanel, Jogo jogo) {
		this.gridPanel = gridPanel;
		this.jogo = jogo;
		grelha = new Grelha[18][9];

//		grelha[0][0] = new Bloco(new Posicao(0, 0), this, 1);
//		grelha[0][1] = new Bloco(new Posicao(0, 1), this, 2);
//		grelha[0][2] = new Bloco(new Posicao(0, 2), this, 0);
		
		carregarFicheiroNivel();
	}

	private void carregarFicheiroNivel() {
		FileHandler handler	= new FileHandler("/niveis/nivel1.txt");
		
	}

	public void iterar() {
		for (int coluna = 0; coluna < 18; coluna++) {
			for (int linha = 0; linha < 9; linha++) {
				if (grelha[coluna][linha] instanceof Bloco) {
					((Bloco) grelha[coluna][linha]).iterar();
					gridPanel.put(linha, coluna, ((Bloco) grelha[coluna][linha]).getCellRepresentation());
					
					
				}
			}
		}
	}

}
