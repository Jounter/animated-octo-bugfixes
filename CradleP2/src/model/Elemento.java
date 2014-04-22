package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Elemento extends Iteravel {
	private Posicao posicao;
	private String nomeImagem;
	
	public Elemento(Posicao posicao, String nomeImagem) {
		super();
		this.posicao = posicao;
		this.nomeImagem = nomeImagem;
	}
	
	public CellRepresentation getRepresentacaoVisual() {
		return new SingleImageCellRepresentation(nomeImagem);
	}
	
	public String getImagem (){
		return nomeImagem;
	}
	
}
