package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Vida extends Iteravel {
	private String nomeImagem;

	public Vida() {
		super();
		this.nomeImagem = "/imagens/vida_20.png";
	}

	public CellRepresentation getCellRepresentation() {
		return new SingleImageCellRepresentation(nomeImagem);
	}
	
	public void iterar() {

	}
}
