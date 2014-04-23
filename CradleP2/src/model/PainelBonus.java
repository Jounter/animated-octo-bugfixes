package model;

import javax.swing.JPanel;

import pt.ipleiria.estg.dei.gridpanel.GridPanel;

public class PainelBonus extends Iteravel {
	private Jogo jogo;
	private GridPanel gridPanel;
	private BonusBomba bonusBomba;
	private BonusMartelo bonusMartelo;

	public PainelBonus(GridPanel gridPanel, Jogo jogo) {
		this.gridPanel = gridPanel;
		this.jogo = jogo;
		bonusBomba = new BonusBomba();
		bonusMartelo = new BonusMartelo();
		
		apresentarBonus();
	}

	
	private void apresentarBonus() {
		gridPanel.put(0, 0, bonusBomba.getCellRepresentation());
		gridPanel.put(1, 0, bonusMartelo.getCellRepresentation());
	}


	public void iterar() {
		// TODO Auto-generated method stub
		
	}

}
