package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Grelha {
	private Posicao posicao;
	private PainelPrincipal painelPrincipal;
	private String nomeImagem;
	
	
	public Grelha(Posicao posicao, PainelPrincipal painelPrincipal, String nomeImagem) {
		super();
		this.posicao = posicao;
		this.painelPrincipal = painelPrincipal;
		this.nomeImagem = nomeImagem;
	}

	public Posicao getPosicao() {
		return posicao;
	}
	
	public CellRepresentation getCellRepresentation() {
		return new SingleImageCellRepresentation(nomeImagem);
	}

}
