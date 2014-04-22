package model;

import javax.swing.JPanel;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class Jogo extends Iteravel {
	
	private PainelPrincipal painelPrincipal;
	private PainelBonus painelBonus;
	private PainelVida painelVida;
	
	public Jogo(GridPanel gridPainelPrincipal, JPanel jPanePainelBonus,
			JPanel jPanePainelVida) {
		super();
		painelPrincipal = new PainelPrincipal(gridPainelPrincipal, this);
		painelBonus = new PainelBonus(jPanePainelBonus, this);
		painelVida = new PainelVida(jPanePainelVida, this);
	}

	public void iterar() {
		painelPrincipal.iterar();
		painelBonus.iterar();
		painelVida.iterar();
	}

	public int atualizarVida() {
		return painelVida.getNivelVida();
	}

}
