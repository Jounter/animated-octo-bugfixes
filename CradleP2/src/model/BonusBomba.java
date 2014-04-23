package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class BonusBomba extends Iteravel {
	private String nomeImagem;

	public BonusBomba() {
		super();
		this.nomeImagem = "/imagens/bonus_bomba_0.png";
	}

	public CellRepresentation getCellRepresentation() {
		return new SingleImageCellRepresentation(nomeImagem);
	}

	public void iterar() {

	}
}
