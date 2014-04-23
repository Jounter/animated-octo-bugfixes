package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class BonusMartelo extends Iteravel {
	private String nomeImagem;

	public BonusMartelo() {
		super();
		this.nomeImagem = "/imagens/bonus_martelo_0.png";
	}

	public CellRepresentation getCellRepresentation() {
		return new SingleImageCellRepresentation(nomeImagem);
	}
	
	public void iterar() {

	}
}
