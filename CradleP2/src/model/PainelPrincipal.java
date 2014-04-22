package model;

import java.util.LinkedList;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelPrincipal extends Iteravel {
	private Grelha[][] grelha;
	private Jogo jogo;
	private GridPanel gridPanel;
	private Elemento[][] elementos;

	public PainelPrincipal(GridPanel gridPanel, Jogo jogo) {
		this.gridPanel = gridPanel;
		this.jogo = jogo;
		grelha = new Grelha[18][9];

		grelha[0][0] = new Bloco(new Posicao(0, 0), this, 1);
		grelha[0][1] = new Bloco(new Posicao(0, 1), this, 2);
		grelha[0][2] = new Bloco(new Posicao(0, 2), this, 0);
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
