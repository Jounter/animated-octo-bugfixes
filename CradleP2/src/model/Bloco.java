package model;

import java.util.HashMap;
import java.util.Random;

import pt.ipleiria.estg.dei.gridpanel.CellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.OverlayCellRepresentation;
import pt.ipleiria.estg.dei.gridpanel.SingleImageCellRepresentation;

public class Bloco extends Grelha {
	private int resistencia;
	private String nomeImagem;
	private Elemento elemento;
	private Random random;

	// private Elemento elemento;
	public Bloco(Posicao posicao, PainelPrincipal painelPrincipal,
			int resistencia) {
		super(posicao, painelPrincipal);
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

	public CellRepresentation getCellRepresentation() {
		if (elemento != null)
			return new OverlayCellRepresentation(new SingleImageCellRepresentation(nomeImagem), elemento.getRepresentacaoVisual());
		return new SingleImageCellRepresentation(nomeImagem);
	}


	public int getResistencia() {
		return resistencia;
	}
	
	public void iterar() {
		switch (random.nextInt(8)) {
		case 0:
			elemento = new Anel(this.getPosicao());
			break;
		case 1:
			elemento = new Balde(this.getPosicao());
			break;
		case 2:
			elemento = new Bomba(this.getPosicao());
			break;
		case 3:
			elemento = new Camarao(this.getPosicao());
			break;
		case 4:
			elemento = new Carne(this.getPosicao());
			break;
		case 5:
			elemento = new Elmo(this.getPosicao());
			break;
		case 6:
			elemento = new Folha(this.getPosicao());
			break;
		case 7:
			elemento = new Madeira(this.getPosicao());
			break;
		case 8:
			elemento = new Martelo(this.getPosicao());
			break;
		}
		
	}
}
