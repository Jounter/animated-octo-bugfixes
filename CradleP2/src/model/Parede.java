package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;


public class Parede extends Grelha {
	private String nomeImagem;

	public Parede(Posicao posicao, PainelPrincipal painelPrincipal) {
		super(posicao, painelPrincipal);
		nomeImagem = "/imagens/parede.png";
	}

	public CellRepresentation getCellRepresentation() {
		return new SingleImageCellRepresentation(nomeImagem);
	}

}
