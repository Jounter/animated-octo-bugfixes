package model;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class Jogo extends Iteravel {
	
	private PainelPrincipal painelPrincipal;
	private PainelBonus painelBonus;
	private PainelVida painelVida;
	
	public Jogo(GridPanel gridPainelPrincipal, GridPanel gridPainelBonus,
			GridPanel gridPainelVida) {
		super();
		painelPrincipal = new PainelPrincipal(gridPainelPrincipal, this);
		painelBonus = new PainelBonus(gridPainelBonus, this);
		painelVida = new PainelVida(gridPainelVida, this);
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
