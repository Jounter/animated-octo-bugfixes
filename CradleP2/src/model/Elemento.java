package model;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Elemento extends Iteravel {
	private Posicao posicao;
	private String nomeImagem;
	private Corrente corrente;

	public Elemento(Posicao posicao, String nomeImagem) {
		super();
		this.posicao = posicao;
		this.nomeImagem = nomeImagem;
	}
	
	public CellRepresentation getRepresentacaoVisual() {
		if(corrente != null)
			return new OverlayCellRepresentation(new SingleImageCellRepresentation(nomeImagem), corrente.getRepresentacaoVisual());
		return new SingleImageCellRepresentation(nomeImagem);
	}
	
	public String getImagem (){
		return nomeImagem;
	}
	
	public Posicao getPosicao (){
		return posicao;
	}
	
	public Corrente getCorrente() {
		return corrente;
	}

	public void setCorrente(Corrente corrente) {
		this.corrente = corrente;
	}
	
}
