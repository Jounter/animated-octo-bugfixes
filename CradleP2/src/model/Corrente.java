package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Corrente extends Iteravel {
	private Posicao posicao;
	private String nomeImagem;
	
	public Corrente(Posicao posicao) {
		super();
		this.posicao = posicao;
		this.nomeImagem = "/imagens/corrente_simples.png";
	}


	public CellRepresentation getRepresentacaoVisual() {
		return new SingleImageCellRepresentation(nomeImagem);
	}
	
public void iterar() {
		
	}
}
