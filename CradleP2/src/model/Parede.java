package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;


public class Parede extends Iteravel implements Celula {
	private Posicao posicao;
	private PainelPrincipal painelPrincipal;
	private String nomeImagem;

	public Parede(Posicao posicao, PainelPrincipal painelPrincipal) {
		this.posicao = posicao;
		this.painelPrincipal = painelPrincipal;
		this.nomeImagem = "/imagens/parede - Copy.png";
	}
	public CellRepresentation getCellRepresentation() {
		return new SingleImageCellRepresentation(nomeImagem);
	}

}
