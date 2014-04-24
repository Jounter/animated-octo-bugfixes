package model;

import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Bloco extends Iteravel implements Celula {
	private Posicao posicao;
	private PainelPrincipal painelPrincipal;
	private int resistencia;
	private String nomeImagem;
	private Elemento elemento;
	private Random random;
	// private Elemento elemento;
	
	public Bloco(Posicao posicao, PainelPrincipal painelPrincipal,
			int resistencia) {
		this.posicao = posicao;
		this.painelPrincipal = painelPrincipal;
		this.nomeImagem = nomeImagem;
		if (resistencia == 0) {
			nomeImagem = "/imagens/bloco0.png";
		} else if (resistencia == 1) {
			nomeImagem = "/imagens/bloco1.png";
		} else if (resistencia == 2) {
			nomeImagem = "/imagens/bloco2.png";
		}
		this.resistencia = resistencia;
		random = new Random();
	}

	public void diminuirResistencia() {
		if (resistencia != 0) {
			resistencia--;
		} else {
			resistencia = 0;
		}

	}
	
	public Posicao getPosicao() {
		return posicao;
	}
	
	public CellRepresentation getCellRepresentation() {
		if (elemento != null)
			return new OverlayCellRepresentation(new SingleImageCellRepresentation(nomeImagem), elemento.getRepresentacaoVisual());
		return new SingleImageCellRepresentation(nomeImagem);
	}

	public int getResistencia() {
		return resistencia;
	}
	
	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public void iterar() {
		
	}
}
